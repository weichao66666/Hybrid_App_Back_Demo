package io.weichao.hybrid_app_back_demo.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by WEI CHAO on 2017/5/13.
 */
public class FragmentUtil {
    private FragmentUtil() {
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment fragment) {
        replaceFragment(fragmentManager, frameId, fragment, null);
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(frameId, fragment, tag);
        transaction.commit();
    }

    public static void addFragment(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment fragment) {
        addFragment(fragmentManager, frameId, fragment, null);
    }

    public static void addFragment(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment fragment, String tag) {
        addFragment(fragmentManager, frameId, null, fragment, tag);
    }

    public static void addFragment(@NonNull FragmentManager fragmentManager, int frameId, Fragment hideFragment, @NonNull Fragment showFragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .add(frameId, showFragment, tag);
        if (hideFragment != null) {
            transaction.hide(hideFragment);
        }
        transaction.commit();
    }

    public static void addFragmentAfterPop(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment fragment, String tag) {
        addFragmentAfterPop(fragmentManager, frameId, null, fragment, tag);
    }

    public static void addFragmentAfterPop(@NonNull FragmentManager fragmentManager, int frameId, Fragment hideFragment, @NonNull Fragment showFragment, String tag) {
        fragmentManager.popBackStack();
        addFragment2BackStack(fragmentManager, frameId, hideFragment, showFragment, tag);
    }

    public static void addFragment2BackStack(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment fragment) {
        addFragment2BackStack(fragmentManager, frameId, fragment, null);
    }

    public static void addFragment2BackStack(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment fragment, String tag) {
        addFragment2BackStack(fragmentManager, frameId, null, fragment, null);
    }

    public static void addFragment2BackStack(@NonNull FragmentManager fragmentManager, int frameId, Fragment hideFragment, @NonNull Fragment showFragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .add(frameId, showFragment, tag)
                .addToBackStack(tag);
        if (hideFragment != null) {
            transaction.hide(hideFragment);
        }
        transaction.commit();
    }

    public static void showFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        showFragment(fragmentManager, null, fragment);
    }

    public static void showFragment(@NonNull FragmentManager fragmentManager, Fragment hideFragment, @NonNull Fragment showFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .show(showFragment);
        if (hideFragment != null) {
            transaction.hide(hideFragment);
        }
        transaction.commit();
    }

    public static void popBackStack(@NonNull FragmentManager fragmentManager) {
        fragmentManager.popBackStack();
    }

//    public static Fragment getCurrentVisibleFragment(@NonNull FragmentManager fragmentManager) {
//        List<Fragment> fragments = fragmentManager.getFragments();
//        if (fragments != null) {
//            for (Fragment f : fragments) {
//                if (f != null && f.isVisible()) {
//                    return f;
//                }
//            }
//        }
//        return null;
//    }
//
//    public static Fragment getCurrentVisibleFragment2(@NonNull FragmentManager fragmentManager) {
//        List<Fragment> fragments = fragmentManager.getFragments();
//        if (fragments != null) {
//            for (Fragment f : fragments) {
//                if (f != null && f.isVisible() && !(f instanceof CatalogWebViewFragment)) {
//                    return f;
//                }
//            }
//        }
//        return null;
//    }
}
