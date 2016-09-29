package com.leonwang.app.chinashop.entity;

/**
 * 当前类注释：小米天气实时指数
 * Author :LeonWang
 * Created  2016/9/29.16:51
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class WeatherAqiEntity {


    /**
     * aqi : {"city":"北京","city_id":"101010100","pub_time":"2014-04-08 18:00","aqi":"206","pm25":"156","pm10":"196","so2":"47","no2":"42","src":"中国环境监测总站","spot":""}
     */

    private AqiEntity aqi;

    public void setAqi(AqiEntity aqi) {
        this.aqi = aqi;
    }

    public AqiEntity getAqi() {
        return aqi;
    }

    public static class AqiEntity {
        /**
         * city : 北京
         * city_id : 101010100
         * pub_time : 2014-04-08 18:00
         * aqi : 206
         * pm25 : 156
         * pm10 : 196
         * so2 : 47
         * no2 : 42
         * src : 中国环境监测总站
         * spot :
         */

        private String city;
        private String city_id;
        private String pub_time;
        private String aqi;
        private String pm25;
        private String pm10;
        private String so2;
        private String no2;
        private String src;
        private String spot;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public void setSpot(String spot) {
            this.spot = spot;
        }

        public String getCity() {
            return city;
        }

        public String getCity_id() {
            return city_id;
        }

        public String getPub_time() {
            return pub_time;
        }

        public String getAqi() {
            return aqi;
        }

        public String getPm25() {
            return pm25;
        }

        public String getPm10() {
            return pm10;
        }

        public String getSo2() {
            return so2;
        }

        public String getNo2() {
            return no2;
        }

        public String getSrc() {
            return src;
        }

        public String getSpot() {
            return spot;
        }
    }
}
