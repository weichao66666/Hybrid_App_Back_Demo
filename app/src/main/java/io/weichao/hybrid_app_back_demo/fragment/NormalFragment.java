package io.weichao.hybrid_app_back_demo.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import io.weichao.hybrid_app_back_demo.R;
import io.weichao.hybrid_app_back_demo.activity.MainActivity;

/**
 * Created by WEI CHAO on 2017/12/31.
 */
public class NormalFragment extends Fragment {
    private static final String TAG = "NormalFragment";

    private static MainActivity mMainActivity;

    private Button mChange2WebWrapperFragmentBtn;
    private boolean mDialogShown;

    public static NormalFragment newInstance() {
        return new NormalFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mMainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_normal, null);
        mChange2WebWrapperFragmentBtn = rootView.findViewById(R.id.btn_change2WebWrapperFragment);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mChange2WebWrapperFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainActivity != null) {
                    mMainActivity.change2WebWrapperFragment();
                } else {
                    Log.e(TAG, "mMainActivity == null");
                }
            }
        });
    }

    public void release() {
        mMainActivity = null;
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("是否退出？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (mMainActivity != null) {
                            mMainActivity.onBackPressed();
                        } else {
                            Log.e(TAG, "mMainActivity == null");
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        mDialogShown = false;
                    }
                })
                .show();
        mDialogShown = true;
    }

    public boolean isDialogShown() {
        return mDialogShown;
    }
}
