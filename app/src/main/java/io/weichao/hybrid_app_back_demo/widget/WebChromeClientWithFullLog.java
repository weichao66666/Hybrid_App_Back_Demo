package io.weichao.hybrid_app_back_demo.widget;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by chao.wei on 2017/11/28.
 */
public class WebChromeClientWithFullLog extends WebChromeClient {
    private static final String TAG = "WebChromeClientWithFullLog";

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        Log.i(TAG, "onProgressChanged(" + newProgress + ")");
        super.onProgressChanged(view, newProgress);
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.i(TAG, "onConsoleMessage(" + consoleMessage.message() + ")");
        return super.onConsoleMessage(consoleMessage);
    }

    @Override
    public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        Log.i(TAG, "onCreateWindow(" + isDialog + ", " + isUserGesture + ", " + resultMsg.toString() + ")");
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Log.i(TAG, "onJsAlert(" + url + ", " + message + ", " + result.toString() + ")");
        return super.onJsAlert(view, url, message, result);
    }

    @Override
    public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        Log.i(TAG, "onJsBeforeUnload(" + url + ", " + message + ", " + result.toString() + ")");
        return super.onJsBeforeUnload(view, url, message, result);
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        Log.i(TAG, "onJsConfirm(" + url + ", " + message + ", " + result.toString() + ")");
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Log.i(TAG, "onJsPrompt(" + url + ", " + message + ", " + defaultValue + ", " + result.toString() + ")");
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    // android 5.0
    @Override
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
        Log.i(TAG, "onShowFileChooser()");
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
    }

    @Override
    public void onCloseWindow(WebView window) {
        Log.i(TAG, "onCloseWindow()");
        super.onCloseWindow(window);
    }

    @Override
    public void onGeolocationPermissionsHidePrompt() {
        Log.i(TAG, "onGeolocationPermissionsHidePrompt()");
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        Log.i(TAG, "onGeolocationPermissionsShowPrompt(" + origin + ", " + callback.toString() + ")");
        super.onGeolocationPermissionsShowPrompt(origin, callback);
    }

    @Override
    public void onHideCustomView() {
        Log.i(TAG, "onHideCustomView()");
        super.onHideCustomView();
    }

    @Override
    public void onPermissionRequest(PermissionRequest request) {
        Log.i(TAG, "onPermissionRequest(" + request.toString() + ")");
        super.onPermissionRequest(request);
    }

    @Override
    public void onPermissionRequestCanceled(PermissionRequest request) {
        Log.i(TAG, "onPermissionRequestCanceled(" + request.toString() + ")");
        super.onPermissionRequestCanceled(request);
    }

    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        Log.i(TAG, "onReceivedIcon()");
        super.onReceivedIcon(view, icon);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        Log.i(TAG, "onReceivedTitle(" + title + ")");
        super.onReceivedTitle(view, title);
    }

    @Override
    public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
        Log.i(TAG, "onReceivedTouchIconUrl(" + url + ", " + precomposed + ")");
        super.onReceivedTouchIconUrl(view, url, precomposed);
    }

    @Override
    public void onRequestFocus(WebView view) {
        Log.i(TAG, "onRequestFocus()");
        super.onRequestFocus(view);
    }

    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {
        Log.i(TAG, "onShowCustomView(" + callback.toString() + ")");
        super.onShowCustomView(view, callback);
    }
}
