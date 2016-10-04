package com.leonwang.app.chinashop.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxAppCompatBaseActivity;
import com.leonwang.app.chinashop.entity.VideoEntity;
import com.leonwang.app.chinashop.utils.LogUtils;
import com.superplayer.library.SuperPlayer;

import butterknife.BindView;


/**
 * 当前类注释：LOL视频播放
 * Author: LeonWang
 * Time: 2016/10/4.17:59
 * E-mail:lijiawangjun@gmail.com
 * Description：
 */

public class LolVedioActivity extends RxAppCompatBaseActivity implements View.OnClickListener, SuperPlayer.OnNetChangeListener {

    @BindView(R.id.view_super_player)
    SuperPlayer mViewSuperPlayer;
    @BindView(R.id.tv_super_player_complete)
    TextView mTvSuperPlayerComplete;
    private String mUrl;
    private String mTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lol_video;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        VideoEntity.DataEntity dataEntity =
                (VideoEntity.DataEntity) bundle.getSerializable("loldata");
        mUrl = dataEntity.getVideo_url();
        mTitle = dataEntity.getTitle();

        LogUtils.d("----------mUrl---------" + mUrl + "--------mTitle----------" + mTitle);
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {
        mViewSuperPlayer.setLive(false);
        mViewSuperPlayer.setTitle(mTitle);
        mViewSuperPlayer.setNetChangeListener(true)
                .setOnNetChangeListener(this)
                .onPrepared(new SuperPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared() {
                        /**
                         * 监听视频是否已经准备完成开始播放。（可以在这里处理视频封面的显示跟隐藏）
                         */
                    }
                })
                .onComplete(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         * 监听视频是否已经播放完成了。（可以在这里处理视频播放完成进行的操作）
                         */
                    }
                })
                .onInfo(new SuperPlayer.OnInfoListener() {
                    @Override
                    public void onInfo(int what, int extra) {
                        /**
                         * 监听视频的相关信息。
                         */

                    }
                })
                .onError(new SuperPlayer.OnErrorListener() {
                    @Override
                    public void onError(int what, int extra) {
                        /**
                         * 监听视频播放失败的回调
                         */

                    }
                })
                .setTitle(mUrl)//设置视频的titleName
                .play(mUrl);//开始播放视频
        mViewSuperPlayer.setScaleType(SuperPlayer.SCALETYPE_FITXY);
    }

    @Override
    protected void onHandlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 网络链接监听类
     */
    @Override
    public void onWifi() {
        Toast.makeText(this,"当前网络环境是WIFI",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMobile() {
        Toast.makeText(this,"当前网络环境是手机网络",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisConnect() {
        Toast.makeText(this,"网络链接断开",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoAvailable() {
        Toast.makeText(this,"无网络链接",Toast.LENGTH_SHORT).show();
    }

    /**
     * 下面的这几个Activity的生命状态很重要
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (mViewSuperPlayer != null) {
            mViewSuperPlayer.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mViewSuperPlayer != null) {
            mViewSuperPlayer.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mViewSuperPlayer != null) {
            mViewSuperPlayer.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mViewSuperPlayer != null) {
            mViewSuperPlayer.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (mViewSuperPlayer != null && mViewSuperPlayer.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
