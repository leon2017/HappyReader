package com.leonwang.app.chinashop.ui;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.AppCompatTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.leonwang.app.chinashop.R;
import com.leonwang.app.chinashop.base.RxAppCompatBaseActivity;

import butterknife.BindView;

public class MainActivity extends RxAppCompatBaseActivity {


    //简单的测试
    @BindView(R.id.appCompatTextView)
    AppCompatTextView mAppCompatTextView;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.toggleButton)
    ToggleButton mToggleButton;
    @BindView(R.id.checkBox)
    CheckBox mCheckBox;
    @BindView(R.id.radioButton)
    RadioButton mRadioButton;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.seekBar)
    SeekBar mSeekBar;
    @BindView(R.id.seekBar2)
    SeekBar mSeekBar2;
    @BindView(R.id.switch1)
    Switch mSwitch1;
    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onHandlerMessage(Message msg) {

    }

}



    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/