package io.weichao.hybrid_app_back_demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.weichao.hybrid_app_back_demo.R;
import io.weichao.hybrid_app_back_demo.activity.MainActivity;
import io.weichao.hybrid_app_back_demo.js_interation.WebWrapperJsInteration;
import io.weichao.hybrid_app_back_demo.widget.WebChromeClientWithFullLog;
import io.weichao.hybrid_app_back_demo.widget.WebViewClientWithFullLog;

/**
 * Created by WEI CHAO on 2018/1/21.
 */
public class WebWrapperFragment extends Fragment {
    private static final String TAG = "WebWrapperFragment";

    private static MainActivity mMainActivity;

    private WebView mWebView;

    private List<String> mBackStackList;

    public static WebWrapperFragment newInstance() {
        return new WebWrapperFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mMainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_web_wrapper, null);
        mWebView = rootView.findViewById(R.id.webView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        WebSettings webSettings = mWebView.getSettings();
        // 设置可控制拉伸
//        webSettings.setBuiltInZoomControls(true);
        // 解决在用户调整手机字体大小/用户调整浏览器字体大小后，布局错乱问题。
        webSettings.setTextZoom(100);
        // 设置 Java 可调用 JS 方法
        webSettings.setJavaScriptEnabled(true);
        // 打开本地缓存
        webSettings.setDomStorageEnabled(true);

        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        // 设置硬件加速
//        WebView.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        // 设置可以访问文件
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);

        webSettings.setDatabaseEnabled(true);

        mWebView.setWebChromeClient(new WebChromeClientWithFullLog());
        mWebView.setWebViewClient(new WebViewClientWithFullLog());
        // 设置 JS 可调用 Java 方法
        mWebView.addJavascriptInterface(new WebWrapperJsInteration(this), WebWrapperJsInteration.JAVA_INTERFACE);

        mWebView.loadUrl("file:///android_asset/demo.html");

        mWebView.requestFocus();
    }

    public void release() {
        if (mWebView != null) {
            mWebView.addJavascriptInterface(null, null);
            mWebView.stopLoading();
            mWebView.clearCache(true);
            mWebView.clearHistory();
            mWebView.destroy();
            mWebView = null;
        }

        mMainActivity = null;
    }

    public void showToast(final String str) {
        if (mMainActivity != null) {
            mMainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Log.e(TAG, "mMainActivity == null");
        }
    }

    public void addBackStack(String arg) {
        if (mBackStackList == null) {
            mBackStackList = new ArrayList<>();
        }
        mBackStackList.add(arg);
    }

    public boolean isBackStackEmpty() {
        return mBackStackList == null || mBackStackList.size() == 0;
    }

    public void goBackStack() {
        String arg = mBackStackList.get(mBackStackList.size() - 1);
        if (mWebView != null) {
            mWebView.loadUrl("javascript:clickBack('" + arg + "')");// 传字符串需要加引号
            showToast("javascript:clickBack(" + arg + ")");
        } else {
            Log.e(TAG, "mWebView == null");
        }
    }

    public void removeBackStack(String str) {
        int index = mBackStackList.lastIndexOf(str);
        if (index != -1) {
            mBackStackList.remove(index);
        } else {
            Log.e(TAG, "index == -1)");
        }
    }

    public void onBackPressed() {
        if (mMainActivity != null) {
            mMainActivity.onBackPressed();
        } else {
            Log.e(TAG, "mMainActivity == null");
        }
    }
}
