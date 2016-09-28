package com.leonwang.app.chinashop.ui.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;

import butterknife.BindView;

/**
 * 当前类注释：开发
 * Author :LeonWang
 * Created  2016/9/22.13:18
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class DeveloperFragment extends RxLazyBaseFragment {

    @BindView(R.id.button)
    Button mButton;

    public static DeveloperFragment newInstance(String param4) {
        DeveloperFragment developerFragment = new DeveloperFragment();
        Bundle args = new Bundle();
        args.putString("args4", param4);
        developerFragment.setArguments(args);
        return developerFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_developer;
    }

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        //6.0权限请求
        ActivityCompat.requestPermissions(getActivity(),mPermissionList, 100);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    protected void lazyLoad() {

    }

    //可以将一下代码加到你的MainActivity中，或者在任意一个需要调用分享功能的activity当中
    String[] mPermissionList = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_LOGS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.SET_DEBUG_APP,
            Manifest.permission.SYSTEM_ALERT_WINDOW,
    };
}
