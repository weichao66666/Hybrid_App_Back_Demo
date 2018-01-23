package io.weichao.hybrid_app_back_demo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import io.weichao.hybrid_app_back_demo.R;
import io.weichao.hybrid_app_back_demo.fragment.NormalFragment;
import io.weichao.hybrid_app_back_demo.fragment.WebWrapperFragment;
import io.weichao.hybrid_app_back_demo.util.FragmentUtil;

public class MainActivity extends AppCompatActivity {
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        change2NormalFragment();
    }

    @Override
    protected void onDestroy() {
        NormalFragment normalFragment = (NormalFragment) getSupportFragmentManager().findFragmentByTag("NormalFragment");
        if (normalFragment != null) {
            normalFragment.release();
        }
        WebWrapperFragment webWrapperFragment = (WebWrapperFragment) getSupportFragmentManager().findFragmentByTag("WebWrapperFragment");
        if (webWrapperFragment != null) {
            webWrapperFragment.release();
        }

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (mFragment instanceof NormalFragment) {
            NormalFragment fragment = (NormalFragment) mFragment;
            if (fragment.isDialogShown()) {
                finish();
            } else {
                fragment.showDialog();
            }
        } else if (mFragment instanceof WebWrapperFragment) {
            WebWrapperFragment fragment = (WebWrapperFragment) mFragment;
            if (fragment.isBackStackEmpty()) {
                change2NormalFragment();
            } else {
                fragment.goBackStack();
            }
        }
    }

    public void change2NormalFragment() {
        NormalFragment fragment = (NormalFragment) getSupportFragmentManager().findFragmentByTag("NormalFragment");
        if (fragment == null) {
            fragment = NormalFragment.newInstance();
            FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fragment, mFragment, fragment, "NormalFragment");
        } else {
            if (mFragment != fragment) {
                FragmentUtil.showFragment(getSupportFragmentManager(), mFragment, fragment);
            }
        }
        mFragment = fragment;
    }

    public void change2WebWrapperFragment() {
        WebWrapperFragment fragment = (WebWrapperFragment) getSupportFragmentManager().findFragmentByTag("WebWrapperFragment");
        if (fragment == null) {
            fragment = WebWrapperFragment.newInstance();
            FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fragment, mFragment, fragment, "WebWrapperFragment");
        } else {
            if (mFragment != fragment) {
                FragmentUtil.showFragment(getSupportFragmentManager(), mFragment, fragment);
            }
        }
        mFragment = fragment;
    }
}
