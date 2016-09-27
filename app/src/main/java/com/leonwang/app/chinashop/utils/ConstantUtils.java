package com.leonwang.app.chinashop.utils;

import com.leonwang.app.chinashop.R;

/**
 * 当前类注释：常量参数
 * Author :LeonWang
 * Created  2016/9/19.17:52
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class ConstantUtils {

    /**
     * 加载失败显示的图片
     */
    public static final int ERROR_IMAGE_ID = R.drawable.loading_image;

    /**
     * 加载过程中显示的图片
     */
    public static final int LOADING_IMAGE_ID = R.drawable.loading_image;

    //聚合数据--新闻头条apikey
    public static final String NEWS_APIKEY = "5b379bc0fafcc419de5bcc0e8e8aeb13";

    /**
     * 新闻头条页面相关数据
     */
    public enum ENewsType {
//        头条，科技，娱乐，社会，国内，国际，体育，军事，财经，时尚

        TOP_NEWS(0, "top", "头条"),
        KEJI_NEWS(1, "keji", "科技"),
        YULE_NEWS(1, "yule", "娱乐"),
        SHEHUI_NEWS(1, "shehui", "社会"),
        GUONEI_NEWS(1, "guonei", "国内"),
        GUOJI_NEWS(1, "guoji", "国际"),
        TIYU_NEWS(1, "tiyu", "体育"),
        JUNSHI_NEWS(1, "junshi", "军事"),
        CAIJING_NEWS(1, "caijing", "财经"),
        SHISHANG_NEWS(1, "shishang", "时尚");

        ENewsType(int index, String type, String title) {
            mIndex = index;
            mType = type;
            mTitle = title;
        }

        private int mIndex;
        private String mType;
        private String mTitle;

        public String getType() {
            return mType;
        }

        public String getTitle() {
            return mTitle;
        }
    }

    /*
    * lol视频相关数据
    *  ----- catid
    *  ----- catwordid
    *  ----- curPage
    *  ----- t_
    *  ----- p_
    * */
    public enum LolType {

        RUOFENG(0, "若风解说", "10172", "146", "1467794913084", "11597"),
        ZUIXIN_JIESHUO(1, "最新解说", "10172", "113", "1467794446790", "22715"),
        ZUIXIN_SAISHI(1, "最新赛事", "10173", "114", "1467794563851", "13898"),
        MENGBI(1, "懵逼瞬间", "10174", "48", "1467794689385", "30500"),
        OTHER(1, "其他LOL", "10174", "91", "1470366703179", "11882");

        LolType(int index, String title, String catid, String catwordid, String t_, String p_) {
            mIndex = index;
            mTitle = title;
            mCatid = catid;
            mCatwordid = catwordid;
            mT_ = t_;
            mP_ = p_;
        }

        private int mIndex;
        private String mTitle;
        private String mCatid;
        private String mCatwordid;
        private String mT_;
        private String mP_;

        public String getTitle() {
            return mTitle;
        }

        public String getCatid() {
            return mCatid;
        }

        public String getCatwordid() {
            return mCatwordid;
        }

        public String getT_() {
            return mT_;
        }

        public String getP_() {
            return mP_;
        }
    }
}
