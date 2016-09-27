package com.leonwang.app.chinashop.ui.fragment.itemFragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.adapter.LolVideoAdapter;
import com.leonwang.app.chinashop.adapter.RefreshCallback;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.entity.VideoEntity;
import com.leonwang.app.chinashop.iml.SwipeItemCallback;
import com.leonwang.app.chinashop.net.RetrofitHelper;
import com.leonwang.app.chinashop.utils.ConstantUtils;
import com.leonwang.app.chinashop.utils.LayoutHelper;
import com.leonwang.app.chinashop.widget.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 当前类注释：视频子fragment
 * Author :LeonWang
 * Created  2016/9/27.14:25
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class VideoItemFragment extends RxLazyBaseFragment {

    @BindView(R.id.swipeRecyclerView)
    SwipeRecyclerView mSwipeRecyclerView;
    private ConstantUtils.LolType mLolType;
    private ArrayList<VideoEntity.DataEntity> mEntityArrayList = new ArrayList<>();
    //当前页码
    int curpage = 1;
    //总条目数
    int totalSize ;
    //初始化条目数
    private boolean isListSatae = true;
    private LolVideoAdapter mLolVideoAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_video_item;
    }

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        isPrepared = true;
        isListSatae = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) return;
        initData();
        isPrepared = false;
    }

    private void initData() {
        RecyclerView recyclerView = mSwipeRecyclerView.getRecyclerView();
        recyclerView.addItemDecoration(LayoutHelper.getHorizontalDividerTranslate(getApplicationContext()));
        mSwipeRecyclerView.setRefreshCallback(new RefreshCallback() {
            @Override
            public void downRefresh() {
                if (mEntityArrayList != null ) mEntityArrayList.clear();
                curpage = 1;
                getNetData();
            }

            @Override
            public void upRefresh(int count) {
                curpage +=1;
                getNetData();
            }
        });

        mLolVideoAdapter = new LolVideoAdapter(getApplicationContext(), new SwipeItemCallback<VideoEntity.DataEntity>() {
            @Override
            public void callback(View view, int position, VideoEntity.DataEntity dataEntity) {

            }
        });

        mSwipeRecyclerView.setAdapter(mLolVideoAdapter);
        mSwipeRecyclerView.startDownRefresh();

    }

    public void setLolType(ConstantUtils.LolType lolType) {
        mLolType = lolType;
    }


    private void getNetData() {

        Map<String,String> params = new HashMap<>();
        params.put("catid",mLolType.getCatid());
        params.put("catwordid",mLolType.getCatwordid());
        params.put("page",curpage+"");
        params.put("t_",mLolType.getT_());
        params.put("p_",mLolType.getP_());

        RetrofitHelper.getLolVedioApi()
                .getLolVideoUrl(params)
                .compose(this.<VideoEntity>bindToLifecycle())
                .flatMap(new Func1<VideoEntity, Observable<?>>() {
                    @Override
                    public Observable<?> call(VideoEntity videoEntity) {
                        mEntityArrayList = videoEntity.getData();
                        if (isListSatae) {
                            totalSize = mEntityArrayList.size()*60;
                            isListSatae = false;
                        }
//                        LogUtils.d("-------------mEntityArrayList----------"+mEntityArrayList.size());
                        return Observable.just("onNext");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        mLolVideoAdapter.load(mEntityArrayList,totalSize);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mSwipeRecyclerView.downRefreshComplete(3);
                    }
                });

    }
}
