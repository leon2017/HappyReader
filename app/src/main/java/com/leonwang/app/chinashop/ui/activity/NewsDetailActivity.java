package com.leonwang.app.chinashop.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxAppCompatBaseActivity;
import com.leonwang.app.chinashop.config.App;
import com.leonwang.app.chinashop.entity.TopNewsEntity.ResultEntity.DataEntity;
import com.leonwang.app.chinashop.utils.LogUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;

import static com.leonwang.app.chinashop.R.id.fab;
import static com.leonwang.app.chinashop.R.id.toolbar;

/**
 * 当前类注释：新闻详情页面
 * Author :LeonWang
 * Created  2016/10/8.10:52
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class NewsDetailActivity extends RxAppCompatBaseActivity {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.news_detail_photo_iv)
    ImageView mNewsDetailPhotoIv;
    @BindView(R.id.mask_view)
    View mMaskView;
    @BindView(toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;
    @BindView(fab)
    FloatingActionButton mFab;
    private String mUrl;
    private String mShareLink;
    private String mTitle;
    private String mHeaderImage;


    @Override
    protected int getLayoutId() {
        return R.layout.act_news_detail;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        DataEntity dataEntity = (DataEntity) bundle.getSerializable("news_detail");
        mUrl = dataEntity.getUrl();
        mTitle = dataEntity.getTitle();
        mHeaderImage = dataEntity.getThumbnail_pic_s();
        LogUtils.d("-----------URL---------" + mUrl);

        initWebView();
    }

    @Override
    protected void initToolBar() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });

        //分享
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mShareLink == null) {
                    mShareLink = "";
                }
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_contents, mTitle, mShareLink));
                startActivity(Intent.createChooser(intent, getTitle()));
            }
        });
    }

    private void initWebView() {
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return (motionEvent.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        setWebViewSettings();
    }

    private void setWebViewSettings() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //支持js
        webSettings.setSupportZoom(true); //支持缩放
//        webSettings.setBuiltInZoomControls(true); // 放大和缩小的按钮，容易引发异常 http://blog.csdn.net/dreamer0924/article/details/34082687

        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }


    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.parse(new URL(mUrl), 5000);
                    LogUtils.d("--------document-------------" + document);
                    Element j_article = document.getElementById("J_article");
                    LogUtils.d("---------Element-----------" + j_article.html());
                    Message msg = Message.obtain();
                    msg.obj = j_article.html();
                    mHandler.sendMessage(msg);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
        setToolBarLayout(mTitle);
        App.getInstance().displayImage(mHeaderImage, mNewsDetailPhotoIv, 0, false, DiskCacheStrategy.ALL);
    }

    private void setToolBarLayout(String newsTitle) {
        mToolbarLayout.setTitle(newsTitle);
        mToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));
        mToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.primary_text_white));
    }

    @Override
    protected void onHandlerMessage(Message msg) {
        String body = (String) msg.obj;
        setWebView(body);
    }

    private void setWebView(String htmlBody) {
        String html = "<html><body>" + htmlBody + "</body></html>";
        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null) view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                    mFab.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.removeAllViews();
        webView.destroy();
    }

}
