package io.weichao.hybrid_app_back_demo.js_interation;

import android.util.Log;
import android.webkit.JavascriptInterface;

import io.weichao.hybrid_app_back_demo.fragment.WebWrapperFragment;

/**
 * Created by pi on 2017/5/27.
 */
public class WebWrapperJsInteration {
    private static final String TAG = "WebWrapperJsInteration";

    public static final String JAVA_INTERFACE = "javaInterface";

    private WebWrapperFragment mView;

    public WebWrapperJsInteration(WebWrapperFragment view) {
        mView = view;
    }

    @JavascriptInterface
    public void back(String str) {
        Log.d(TAG, "back(" + str + ")");
        mView.showToast("back(" + str + ")");
        mView.addBackStack(str);
    }

    @JavascriptInterface
    public void removeBack(String str) {
        Log.d(TAG, "removeBack(" + str + ")");
        mView.showToast("removeBack(" + str + ")");
        mView.removeBackStack(str);
    }

    @JavascriptInterface
    public void exit() {
        Log.d(TAG, "exit()");
        mView.showToast("exit()");
        mView.onBackPressed();
    }
}
