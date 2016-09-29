package com.leonwang.app.chinashop.entity;

/**
 * 当前类注释：小米天气实时情况
 * Author :LeonWang
 * Created  2016/9/29.16:49
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class WeatherNowEntity {


    /**
     * weatherinfo : {"SD":"32%","WD":"西南风","WS":"2级","WSE":"","city":"北京","cityid":"101010100","isRadar":"1","radar":"JC_RADAR_AZ9010_JB","temp":"23","time":"18:35","weather":"霾"}
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
         * SD : 32%
         * WD : 西南风
         * WS : 2级
         * WSE :
         * city : 北京
         * cityid : 101010100
         * isRadar : 1
         * radar : JC_RADAR_AZ9010_JB
         * temp : 23
         * time : 18:35
         * weather : 霾
         */

        private String SD;
        private String WD;
        private String WS;
        private String WSE;
        private String city;
        private String cityid;
        private String isRadar;
        private String radar;
        private String temp;
        private String time;
        private String weather;

        public void setSD(String SD) {
            this.SD = SD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public void setWSE(String WSE) {
            this.WSE = WSE;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public void setIsRadar(String isRadar) {
            this.isRadar = isRadar;
        }

        public void setRadar(String radar) {
            this.radar = radar;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getSD() {
            return SD;
        }

        public String getWD() {
            return WD;
        }

        public String getWS() {
            return WS;
        }

        public String getWSE() {
            return WSE;
        }

        public String getCity() {
            return city;
        }

        public String getCityid() {
            return cityid;
        }

        public String getIsRadar() {
            return isRadar;
        }

        public String getRadar() {
            return radar;
        }

        public String getTemp() {
            return temp;
        }

        public String getTime() {
            return time;
        }

        public String getWeather() {
            return weather;
        }
    }
}
