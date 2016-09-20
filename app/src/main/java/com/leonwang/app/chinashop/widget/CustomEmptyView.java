package com.leonwang.app.chinashop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.leonwang.app.chinashop.R;


/**
 * 当前类注释：自定义emptyView
 * Author :LeonWang
 * Created  2016/9/20.12:49
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */
public class CustomEmptyView extends FrameLayout
{

    private ImageView mEmptyImg;

    private TextView mEmptyText;

    private Button mReloadBtn;

    private ReloadOnClickListener OnReloadOnClickListener;

    public CustomEmptyView(Context context, AttributeSet attrs, int defStyleAttr)
    {

        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomEmptyView(Context context)
    {

        this(context, null);
    }

    public CustomEmptyView(Context context, AttributeSet attrs)
    {

        this(context, attrs, 0);
    }


    public void init()
    {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty, this);
        mEmptyImg = (ImageView) view.findViewById(R.id.empty_img);
        mEmptyText = (TextView) view.findViewById(R.id.empty_text);
        mReloadBtn = (Button) view.findViewById(R.id.btn_reload);
    }

    public void setEmptyImage(int imgRes)
    {

        mEmptyImg.setImageResource(imgRes);
    }

    public void setEmptyText(String text)
    {

        mEmptyText.setText(text);
    }

    public void hideReloadButton()
    {

        mReloadBtn.setVisibility(GONE);
    }


    public void reload(ReloadOnClickListener onReloadOnClickListener)
    {

        this.OnReloadOnClickListener = onReloadOnClickListener;

        mReloadBtn.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                if (OnReloadOnClickListener != null)
                {
                    OnReloadOnClickListener.reloadClick();
                }
            }
        });
    }


    public interface ReloadOnClickListener
    {

        void reloadClick();
    }
}
