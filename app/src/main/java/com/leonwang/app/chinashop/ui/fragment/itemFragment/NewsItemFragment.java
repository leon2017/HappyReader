package com.leonwang.app.chinashop.ui.fragment.itemFragment;

import android.os.Bundle;
import android.widget.TextView;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxLazyBaseFragment;
import com.leonwang.app.chinashop.utils.ConstantUtils;
import com.leonwang.app.chinashop.utils.LogUtils;

import butterknife.BindView;

/**
 * 当前类注释：新闻页面子条目
 * Author :LeonWang
 * Created  2016/9/22.15:24
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class NewsItemFragment extends RxLazyBaseFragment {

    @BindView(R.id.text)
    TextView mText;
    private ConstantUtils.ENewsType mENewsType;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_news_item;
    }

    @Override
    protected void finishCreateView(Bundle savedInstanceState) {
        isPrepared = true;
//        initData();
        LogUtils.d("我被初始化了");
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) return;
        initData();
        isPrepared = false;
    }

    private void initData() {
        mText.setText(mENewsType.getTitle());
    }

    public void setNewsType(ConstantUtils.ENewsType type) {
        mENewsType = type;
    }

}
