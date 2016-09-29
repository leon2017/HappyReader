package com.leonwang.app.chinashop.entity;

/**
 * 当前类注释：小米天气未来五天的天气情况
 * Author :LeonWang
 * Created  2016/9/29.16:47
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class WeatherDay5Entity {


    /**
     * weatherinfo : {"city":"北京","city_en":"beijing","cityid":"101010100","date":"","date_y":"2014年04月08日","fchh":"18","fl1":"3-4级转4-5级","fl2":"3-4级转小于3级","fl3":"小于3级","fl4":"小于3级","fl5":"小于3级","fl6":"微风","fx1":"南风转北风","fx2":"东北风转无持续风向","img_title1":"霾","img_title10":"多云","img_title11":"晴","img_title12":"晴","img_title2":"多云","img_title3":"晴","img_title4":"多云","img_title5":"多云","img_title6":"阴","img_title7":"阴","img_title8":"多云","img_title9":"晴","img_title_single":"","index":"较舒适","index48":"","index48_d":"","index48_uv":"","index_ag":"极易发","index_cl":"不宜","index_co":"舒适","index_d":"","index_ls":"不宜","index_tr":"适宜","index_uv":"最弱","index_xc":"不宜","temp1":"12℃~28℃","temp2":"11℃~18℃","temp3":"8℃~18℃","temp4":"9℃~22℃","temp5":"10℃~22℃","temp6":"0℃~0℃","weather1":"霾转多云","weather2":"晴转多云","weather3":"多云转阴","weather4":"阴转多云","weather5":"晴转多云","weather6":"晴","week":"星期二","wind1":"南风转北风","wind2":"东北风转无持续风向","wind3":"微风","wind4":"微风","wind5":"微风","wind6":"微风"}
     */

    private WeatherinfoEntity weatherinfo;

    public void setWeatherinfo(WeatherinfoEntity weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public WeatherinfoEntity getWeatherinfo() {
        return weatherinfo;
    }

    public static class WeatherinfoEntity {
        /**
         * city : 北京
         * city_en : beijing
         * cityid : 101010100
         * date :
         * date_y : 2014年04月08日
         * fchh : 18
         * fl1 : 3-4级转4-5级
         * fl2 : 3-4级转小于3级
         * fl3 : 小于3级
         * fl4 : 小于3级
         * fl5 : 小于3级
         * fl6 : 微风
         * fx1 : 南风转北风
         * fx2 : 东北风转无持续风向
         * img_title1 : 霾
         * img_title10 : 多云
         * img_title11 : 晴
         * img_title12 : 晴
         * img_title2 : 多云
         * img_title3 : 晴
         * img_title4 : 多云
         * img_title5 : 多云
         * img_title6 : 阴
         * img_title7 : 阴
         * img_title8 : 多云
         * img_title9 : 晴
         * img_title_single :
         * index : 较舒适
         * index48 :
         * index48_d :
         * index48_uv :
         * index_ag : 极易发
         * index_cl : 不宜
         * index_co : 舒适
         * index_d :
         * index_ls : 不宜
         * index_tr : 适宜
         * index_uv : 最弱
         * index_xc : 不宜
         * temp1 : 12℃~28℃
         * temp2 : 11℃~18℃
         * temp3 : 8℃~18℃
         * temp4 : 9℃~22℃
         * temp5 : 10℃~22℃
         * temp6 : 0℃~0℃
         * weather1 : 霾转多云
         * weather2 : 晴转多云
         * weather3 : 多云转阴
         * weather4 : 阴转多云
         * weather5 : 晴转多云
         * weather6 : 晴
         * week : 星期二
         * wind1 : 南风转北风
         * wind2 : 东北风转无持续风向
         * wind3 : 微风
         * wind4 : 微风
         * wind5 : 微风
         * wind6 : 微风
         */

        private String city;
        private String city_en;
        private String cityid;
        private String date;
        private String date_y;
        private String fchh;
        private String fl1;
        private String fl2;
        private String fl3;
        private String fl4;
        private String fl5;
        private String fl6;
        private String fx1;
        private String fx2;
        private String img_title1;
        private String img_title10;
        private String img_title11;
        private String img_title12;
        private String img_title2;
        private String img_title3;
        private String img_title4;
        private String img_title5;
        private String img_title6;
        private String img_title7;
        private String img_title8;
        private String img_title9;
        private String img_title_single;
        private String index;
        private String index48;
        private String index48_d;
        private String index48_uv;
        private String index_ag;
        private String index_cl;
        private String index_co;
        private String index_d;
        private String index_ls;
        private String index_tr;
        private String index_uv;
        private String index_xc;
        private String temp1;
        private String temp2;
        private String temp3;
        private String temp4;
        private String temp5;
        private String temp6;
        private String weather1;
        private String weather2;
        private String weather3;
        private String weather4;
        private String weather5;
        private String weather6;
        private String week;
        private String wind1;
        private String wind2;
        private String wind3;
        private String wind4;
        private String wind5;
        private String wind6;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCity_en(String city_en) {
            this.city_en = city_en;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setDate_y(String date_y) {
            this.date_y = date_y;
        }

        public void setFchh(String fchh) {
            this.fchh = fchh;
        }

        public void setFl1(String fl1) {
            this.fl1 = fl1;
        }

        public void setFl2(String fl2) {
            this.fl2 = fl2;
        }

        public void setFl3(String fl3) {
            this.fl3 = fl3;
        }

        public void setFl4(String fl4) {
            this.fl4 = fl4;
        }

        public void setFl5(String fl5) {
            this.fl5 = fl5;
        }

        public void setFl6(String fl6) {
            this.fl6 = fl6;
        }

        public void setFx1(String fx1) {
            this.fx1 = fx1;
        }

        public void setFx2(String fx2) {
            this.fx2 = fx2;
        }

        public void setImg_title1(String img_title1) {
            this.img_title1 = img_title1;
        }

        public void setImg_title10(String img_title10) {
            this.img_title10 = img_title10;
        }

        public void setImg_title11(String img_title11) {
            this.img_title11 = img_title11;
        }

        public void setImg_title12(String img_title12) {
            this.img_title12 = img_title12;
        }

        public void setImg_title2(String img_title2) {
            this.img_title2 = img_title2;
        }

        public void setImg_title3(String img_title3) {
            this.img_title3 = img_title3;
        }

        public void setImg_title4(String img_title4) {
            this.img_title4 = img_title4;
        }

        public void setImg_title5(String img_title5) {
            this.img_title5 = img_title5;
        }

        public void setImg_title6(String img_title6) {
            this.img_title6 = img_title6;
        }

        public void setImg_title7(String img_title7) {
            this.img_title7 = img_title7;
        }

        public void setImg_title8(String img_title8) {
            this.img_title8 = img_title8;
        }

        public void setImg_title9(String img_title9) {
            this.img_title9 = img_title9;
        }

        public void setImg_title_single(String img_title_single) {
            this.img_title_single = img_title_single;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public void setIndex48(String index48) {
            this.index48 = index48;
        }

        public void setIndex48_d(String index48_d) {
            this.index48_d = index48_d;
        }

        public void setIndex48_uv(String index48_uv) {
            this.index48_uv = index48_uv;
        }

        public void setIndex_ag(String index_ag) {
            this.index_ag = index_ag;
        }

        public void setIndex_cl(String index_cl) {
            this.index_cl = index_cl;
        }

        public void setIndex_co(String index_co) {
            this.index_co = index_co;
        }

        public void setIndex_d(String index_d) {
            this.index_d = index_d;
        }

        public void setIndex_ls(String index_ls) {
            this.index_ls = index_ls;
        }

        public void setIndex_tr(String index_tr) {
            this.index_tr = index_tr;
        }

        public void setIndex_uv(String index_uv) {
            this.index_uv = index_uv;
        }

        public void setIndex_xc(String index_xc) {
            this.index_xc = index_xc;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }

        public void setTemp3(String temp3) {
            this.temp3 = temp3;
        }

        public void setTemp4(String temp4) {
            this.temp4 = temp4;
        }

        public void setTemp5(String temp5) {
            this.temp5 = temp5;
        }

        public void setTemp6(String temp6) {
            this.temp6 = temp6;
        }

        public void setWeather1(String weather1) {
            this.weather1 = weather1;
        }

        public void setWeather2(String weather2) {
            this.weather2 = weather2;
        }

        public void setWeather3(String weather3) {
            this.weather3 = weather3;
        }

        public void setWeather4(String weather4) {
            this.weather4 = weather4;
        }

        public void setWeather5(String weather5) {
            this.weather5 = weather5;
        }

        public void setWeather6(String weather6) {
            this.weather6 = weather6;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public void setWind1(String wind1) {
            this.wind1 = wind1;
        }

        public void setWind2(String wind2) {
            this.wind2 = wind2;
        }

        public void setWind3(String wind3) {
            this.wind3 = wind3;
        }

        public void setWind4(String wind4) {
            this.wind4 = wind4;
        }

        public void setWind5(String wind5) {
            this.wind5 = wind5;
        }

        public void setWind6(String wind6) {
            this.wind6 = wind6;
        }

        public String getCity() {
            return city;
        }

        public String getCity_en() {
            return city_en;
        }

        public String getCityid() {
            return cityid;
        }

        public String getDate() {
            return date;
        }

        public String getDate_y() {
            return date_y;
        }

        public String getFchh() {
            return fchh;
        }

        public String getFl1() {
            return fl1;
        }

        public String getFl2() {
            return fl2;
        }

        public String getFl3() {
            return fl3;
        }

        public String getFl4() {
            return fl4;
        }

        public String getFl5() {
            return fl5;
        }

        public String getFl6() {
            return fl6;
        }

        public String getFx1() {
            return fx1;
        }

        public String getFx2() {
            return fx2;
        }

        public String getImg_title1() {
            return img_title1;
        }

        public String getImg_title10() {
            return img_title10;
        }

        public String getImg_title11() {
            return img_title11;
        }

        public String getImg_title12() {
            return img_title12;
        }

        public String getImg_title2() {
            return img_title2;
        }

        public String getImg_title3() {
            return img_title3;
        }

        public String getImg_title4() {
            return img_title4;
        }

        public String getImg_title5() {
            return img_title5;
        }

        public String getImg_title6() {
            return img_title6;
        }

        public String getImg_title7() {
            return img_title7;
        }

        public String getImg_title8() {
            return img_title8;
        }

        public String getImg_title9() {
            return img_title9;
        }

        public String getImg_title_single() {
            return img_title_single;
        }

        public String getIndex() {
            return index;
        }

        public String getIndex48() {
            return index48;
        }

        public String getIndex48_d() {
            return index48_d;
        }

        public String getIndex48_uv() {
            return index48_uv;
        }

        public String getIndex_ag() {
            return index_ag;
        }

        public String getIndex_cl() {
            return index_cl;
        }

        public String getIndex_co() {
            return index_co;
        }

        public String getIndex_d() {
            return index_d;
        }

        public String getIndex_ls() {
            return index_ls;
        }

        public String getIndex_tr() {
            return index_tr;
        }

        public String getIndex_uv() {
            return index_uv;
        }

        public String getIndex_xc() {
            return index_xc;
        }

        public String getTemp1() {
            return temp1;
        }

        public String getTemp2() {
            return temp2;
        }

        public String getTemp3() {
            return temp3;
        }

        public String getTemp4() {
            return temp4;
        }

        public String getTemp5() {
            return temp5;
        }

        public String getTemp6() {
            return temp6;
        }

        public String getWeather1() {
            return weather1;
        }

        public String getWeather2() {
            return weather2;
        }

        public String getWeather3() {
            return weather3;
        }

        public String getWeather4() {
            return weather4;
        }

        public String getWeather5() {
            return weather5;
        }

        public String getWeather6() {
            return weather6;
        }

        public String getWeek() {
            return week;
        }

        public String getWind1() {
            return wind1;
        }

        public String getWind2() {
            return wind2;
        }

        public String getWind3() {
            return wind3;
        }

        public String getWind4() {
            return wind4;
        }

        public String getWind5() {
            return wind5;
        }

        public String getWind6() {
            return wind6;
        }
    }
}
