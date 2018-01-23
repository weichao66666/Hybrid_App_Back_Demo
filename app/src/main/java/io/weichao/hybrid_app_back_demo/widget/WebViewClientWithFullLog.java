package io.weichao.hybrid_app_back_demo.widget;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by chao.wei on 2017/11/28.
 */
public class WebViewClientWithFullLog extends WebViewClient {
    private static final String TAG = "WebViewClientWithFullLog";

    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        Log.i(TAG, "shouldOverrideKeyEvent(" + event.toString() + ")");
        return super.shouldOverrideKeyEvent(view, event);
    }

    @Override
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        Log.i(TAG, "onReceivedClientCertRequest(" + request.toString() + ")");
        super.onReceivedClientCertRequest(view, request);
    }

    @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        Log.i(TAG, "onFormResubmission(" + dontResend.toString() + ", " + resend.toString() + ")");
        super.onFormResubmission(view, dontResend, resend);
    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
        Log.i(TAG, "onPageCommitVisible(" + url + ")");
        super.onPageCommitVisible(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Log.i(TAG, "onPageStarted(" + url + ")");
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        Log.i(TAG, "onLoadResource(" + url + ")");
        super.onLoadResource(view, url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Log.i(TAG, "onPageFinished(" + url + ")");
        // 必须在页面加载结束后再调用 js
        super.onPageFinished(view, url);
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        Log.i(TAG, "onReceivedHttpAuthRequest(" + host + ", " + realm + ")");
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String url) {
        Log.i(TAG, "onReceivedError(" + errorCode + ", " + description + ", " + url + ")");
        super.onReceivedError(view, errorCode, description, url);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        // 这个方法在6.0才出现
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.i(TAG, "onReceivedError(" + request.getUrl().toString() + ", " + error.getDescription() + ")");
        }
        if (request.isForMainFrame()) { // 或 if (request.getUrl().toString().equals(view.getUrl()))
        }
    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse response) {
        // 这个方法在6.0才出现
        Log.i(TAG, "onReceivedHttpError(" + request.getUrl().toString() + ", " + response.getStatusCode() + ")");
        super.onReceivedHttpError(view, request, response);
    }

    @Override
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        Log.i(TAG, "onReceivedLoginRequest(" + realm + ", " + account + ", " + args + ")");
        super.onReceivedLoginRequest(view, realm, account, args);
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Log.i(TAG, "onReceivedSslError(" + error.toString() + ")");
        super.onReceivedSslError(view, handler, error);
    }

    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        Log.i(TAG, "onScaleChanged(" + oldScale + ", " + newScale + ")");
        super.onScaleChanged(view, oldScale, newScale);
    }

    @Override
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        Log.i(TAG, "onUnhandledKeyEvent(" + event.toString() + ")");
        super.onUnhandledKeyEvent(view, event);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.i(TAG, "shouldOverrideUrlLoading(" + url + ")");
        // True means that app handled url
        // https://stackoverflow.com/questions/42367358/webview-on-android-7-0-doesnt-render-page
        return false;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Log.i(TAG, "shouldOverrideUrlLoading(" + request.getUrl().toString() + ")");
        // True means that app handled url
        // https://stackoverflow.com/questions/42367358/webview-on-android-7-0-doesnt-render-page
        return false;
    }

    @Override
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Log.i(TAG, "onRenderProcessGone(" + detail.toString() + ")");
        return super.onRenderProcessGone(view, detail);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Log.i(TAG, "shouldInterceptRequest(" + request.getUrl().toString() + ")");
        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        Log.i(TAG, "doUpdateVisitedHistory(" + url + ", " + isReload + ")");
        super.doUpdateVisitedHistory(view, url, isReload);
    }
}
