package com.leonwang.app.chinashop.entity;

import java.util.Date;
import java.util.List;

/**
 * 当前类注释：魅族天气
 * Author :LeonWang
 * Created  2016/9/30.10:08
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class WeatherMZEntity {

    /**
     * alarms : []
     * city : 上海
     * cityid : 101020100
     * indexes : [{"abbreviation":"zs","alias":"","content":"温度不高，其他各项气象条件适宜，中暑机率极低。","level":"无","name":"中暑指数"},{"abbreviation":"ys","alias":"","content":"有降水，如果您要短时间外出的话可不必带雨伞。","level":"带伞","name":"雨伞指数"},{"abbreviation":"yh","alias":"","content":"虽然有时会有降水，但只要做好防雨工作，你仍然可以有一个愉快的约会。","level":"较适宜","name":"约会指数"},{"abbreviation":"yd","alias":"","content":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。","level":"较不宜","name":"运动指数"},{"abbreviation":"xq","alias":"","content":"有降水，雨水可能会使心绪无端地挂上轻愁，与其因下雨而无精打采，不如放松心情，好好欣赏一下雨景。你会发现雨中的世界是那般洁净温和、清新葱郁。","level":"较差","name":"心情指数"},{"abbreviation":"xc","alias":"","content":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","level":"不宜","name":"洗车指数"},{"abbreviation":"wc","alias":"","content":"温度未达到风寒所需的低温，稍作防寒准备即可。","level":"无","name":"风寒指数"},{"abbreviation":"uv","alias":"","content":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。","level":"弱","name":"紫外线强度指数"},{"abbreviation":"tr","alias":"","content":"有降水，温度适宜，在细雨中游玩别有一番情调，可不要错过机会呦！但记得出门要携带雨具。","level":"适宜","name":"旅游指数"},{"abbreviation":"pp","alias":"","content":"天气较热，建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂。","level":"去油","name":"化妆指数"},{"abbreviation":"pl","alias":"","content":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。","level":"良","name":"空气污染扩散条件指数"},{"abbreviation":"pk","alias":"","content":"天气不好，不适宜放风筝。","level":"不宜","name":"放风筝指数"},{"abbreviation":"pj","alias":"","content":"炎热的天气可能增加啤酒对您的诱惑，适量饮用啤酒会给您带来清凉的感觉，但千万注意不要过量呦！","level":"适宜","name":"啤酒指数"},{"abbreviation":"nl","alias":"","content":"虽然有降水，但只要提前有所准备，您仍然可以享受夜生活的乐趣。","level":"较适宜","name":"夜生活指数"},{"abbreviation":"mf","alias":"","content":"头发需要保持清洁，同时要注意防晒，含防晒成分洗发护发品以及遮阳帽、伞是很好的选择。","level":"一般","name":"美发指数"},{"abbreviation":"ls","alias":"","content":"有降水，可能会淋湿晾晒的衣物，不太适宜晾晒。请随时注意天气变化。","level":"不太适宜","name":"晾晒指数"},{"abbreviation":"lk","alias":"","content":"有降水，路面潮湿，车辆易打滑，请小心驾驶。","level":"潮湿","name":"路况指数"},{"abbreviation":"jt","alias":"","content":"有降水，能见度不太好且路面潮湿，不适宜高速行驶，司机应更加集中注意力，小心驾驶。","level":"较好","name":"交通指数"},{"abbreviation":"hc","alias":"","content":"白天天气不好，不适宜划船，建议选择别的娱乐方式。","level":"不适宜","name":"划船指数"},{"abbreviation":"gm","alias":"","content":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","level":"少发","name":"感冒指数"},{"abbreviation":"gj","alias":"","content":"虽有降水，但还是较适宜逛街的，不过要记得带上雨具。","level":"较适宜","name":"逛街指数"},{"abbreviation":"fs","alias":"","content":"紫外线强度较弱，建议涂擦SPF在12-15之间，PA+的防晒护肤品。","level":"较弱","name":"防晒指数"},{"abbreviation":"dy","alias":"","content":"较适合垂钓，但天气稍热，会对垂钓产生一定的影响。","level":"较适宜","name":"钓鱼指数"},{"abbreviation":"ct","alias":"","content":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","level":"热","name":"穿衣指数"},{"abbreviation":"co","alias":"","content":"白天虽然有雨，但仍无法削弱较高气温带来的暑意，同时降雨造成湿度加大会您感到有些闷热，不很舒适。","level":"较不舒适","name":"舒适度指数"},{"abbreviation":"cl","alias":"","content":"有降水，较不宜晨练，室外锻炼请携带雨具。建议年老体弱人群适当减少晨练时间。","level":"较不宜","name":"晨练指数"},{"abbreviation":"ag","alias":"","content":"天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。","level":"较易发","name":"过敏指数"},{"abbreviation":"ac","alias":"","content":"您将感到很舒适，一般不需要开启空调。","level":"较少开启","name":"空调开启指数"}]
     * pm25 : {"advice":"","aqi":"27","citycount":1737,"cityrank":84,"co":"0.0","color":"","level":"0","no2":"0","o3":"0","pm10":"19","pm25":"12","quality":"优","so2":"0","timestamp":"0","upDateTime":"2016-09-30 09:00:00"}
     * provinceName : 上海市
     * realtime : {"img":"2","sD":"97","sendibleTemp":"24","temp":"24","time":"2016-09-30 09:00:00","wD":"东风","wS":"1级","weather":"阴","ziwaixian":"N/A"}
     * weatherDetailsInfo : {"publishTime":"2016-09-30 10:00:00","weather24HoursDetailsInfos":[{"endTime":"2016-09-30 12:00:00","highestTemperature":"27","img":"2","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-09-30 11:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-09-30 13:00:00","highestTemperature":"28","img":"2","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 12:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-09-30 14:00:00","highestTemperature":"28","img":"2","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 13:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-09-30 15:00:00","highestTemperature":"28","img":"1","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 14:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 16:00:00","highestTemperature":"28","img":"1","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 15:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 17:00:00","highestTemperature":"27","img":"1","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-09-30 16:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 18:00:00","highestTemperature":"27","img":"1","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-09-30 17:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 19:00:00","highestTemperature":"26","img":"1","isRainFall":"降水","lowerestTemperature":"26","precipitation":"1","startTime":"2016-09-30 18:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 20:00:00","highestTemperature":"26","img":"1","isRainFall":"降水","lowerestTemperature":"26","precipitation":"1","startTime":"2016-09-30 19:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 21:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 20:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 22:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 21:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 23:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 22:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 00:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 23:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 01:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 00:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 02:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 01:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 03:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 02:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 04:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 03:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 05:00:00","highestTemperature":"24","img":"1","isRainFall":"降水","lowerestTemperature":"24","precipitation":"1","startTime":"2016-10-01 04:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 06:00:00","highestTemperature":"24","img":"1","isRainFall":"降水","lowerestTemperature":"24","precipitation":"1","startTime":"2016-10-01 05:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 07:00:00","highestTemperature":"24","img":"1","isRainFall":"降水","lowerestTemperature":"24","precipitation":"1","startTime":"2016-10-01 06:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 08:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 07:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 09:00:00","highestTemperature":"26","img":"1","isRainFall":"降水","lowerestTemperature":"26","precipitation":"1","startTime":"2016-10-01 08:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 10:00:00","highestTemperature":"27","img":"1","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-10-01 09:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 11:00:00","highestTemperature":"27","img":"2","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-10-01 10:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-10-01 12:00:00","highestTemperature":"28","img":"2","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-10-01 11:00:00","wd":"","weather":"阴","ws":""}]}
     * weathers : [{"date":"2016-09-30","img":"3","sun_down_time":"17:40","sun_rise_time":"05:47","temp_day_c":"29","temp_day_f":"84.2","temp_night_c":"24","temp_night_f":"75.2","wd":"南风","weather":"阵雨","week":"星期五","ws":"0级"},{"date":"2016-10-01","img":"1","sun_down_time":"17:39","sun_rise_time":"05:48","temp_day_c":"30","temp_day_f":"86.0","temp_night_c":"25","temp_night_f":"77.0","wd":"东南风","weather":"多云","week":"星期六","ws":"0级"},{"date":"2016-10-02","img":"1","sun_down_time":"17:38","sun_rise_time":"05:48","temp_day_c":"30","temp_day_f":"86.0","temp_night_c":"24","temp_night_f":"75.2","wd":"南风","weather":"多云","week":"星期日","ws":"0级"},{"date":"2016-10-03","img":"3","sun_down_time":"17:37","sun_rise_time":"05:49","temp_day_c":"27","temp_day_f":"80.6","temp_night_c":"23","temp_night_f":"73.4","wd":"东北风","weather":"阵雨","week":"星期一","ws":"0级"},{"date":"2016-10-04","img":"1","sun_down_time":"17:35","sun_rise_time":"05:49","temp_day_c":"28","temp_day_f":"82.4","temp_night_c":"23","temp_night_f":"73.4","wd":"东北风","weather":"多云","week":"星期二","ws":"0级"},{"date":"2016-10-05","img":"1","sun_down_time":"17:34","sun_rise_time":"05:50","temp_day_c":"28","temp_day_f":"82.4","temp_night_c":"22","temp_night_f":"71.6","wd":"东北风","weather":"多云","week":"星期三","ws":"0级"},{"date":"2016-09-29","img":"9","sun_down_time":"17:42","sun_rise_time":"05:46","temp_day_c":"25","temp_day_f":"77.0","temp_night_c":"23","temp_night_f":"73.4","wd":"东南风","weather":"大雨","week":"星期四","ws":"0级"}]
     */

    private String city;
    private int cityid;
    /**
     * advice :
     * aqi : 27
     * citycount : 1737
     * cityrank : 84
     * co : 0.0
     * color :
     * level : 0
     * no2 : 0
     * o3 : 0
     * pm10 : 19
     * pm25 : 12
     * quality : 优
     * so2 : 0
     * timestamp : 0
     * upDateTime : 2016-09-30 09:00:00
     */

    private Pm25Bean pm25;
    private String provinceName;
    /**
     * img : 2
     * sD : 97
     * sendibleTemp : 24
     * temp : 24
     * time : 2016-09-30 09:00:00
     * wD : 东风
     * wS : 1级
     * weather : 阴
     * ziwaixian : N/A
     */

    private RealtimeBean realtime;
    /**
     * publishTime : 2016-09-30 10:00:00
     * weather24HoursDetailsInfos : [{"endTime":"2016-09-30 12:00:00","highestTemperature":"27","img":"2","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-09-30 11:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-09-30 13:00:00","highestTemperature":"28","img":"2","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 12:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-09-30 14:00:00","highestTemperature":"28","img":"2","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 13:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-09-30 15:00:00","highestTemperature":"28","img":"1","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 14:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 16:00:00","highestTemperature":"28","img":"1","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-09-30 15:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 17:00:00","highestTemperature":"27","img":"1","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-09-30 16:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 18:00:00","highestTemperature":"27","img":"1","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-09-30 17:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 19:00:00","highestTemperature":"26","img":"1","isRainFall":"降水","lowerestTemperature":"26","precipitation":"1","startTime":"2016-09-30 18:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 20:00:00","highestTemperature":"26","img":"1","isRainFall":"降水","lowerestTemperature":"26","precipitation":"1","startTime":"2016-09-30 19:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 21:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 20:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 22:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 21:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-09-30 23:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 22:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 00:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-09-30 23:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 01:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 00:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 02:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 01:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 03:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 02:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 04:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 03:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 05:00:00","highestTemperature":"24","img":"1","isRainFall":"降水","lowerestTemperature":"24","precipitation":"1","startTime":"2016-10-01 04:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 06:00:00","highestTemperature":"24","img":"1","isRainFall":"降水","lowerestTemperature":"24","precipitation":"1","startTime":"2016-10-01 05:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 07:00:00","highestTemperature":"24","img":"1","isRainFall":"降水","lowerestTemperature":"24","precipitation":"1","startTime":"2016-10-01 06:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 08:00:00","highestTemperature":"25","img":"1","isRainFall":"降水","lowerestTemperature":"25","precipitation":"1","startTime":"2016-10-01 07:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 09:00:00","highestTemperature":"26","img":"1","isRainFall":"降水","lowerestTemperature":"26","precipitation":"1","startTime":"2016-10-01 08:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 10:00:00","highestTemperature":"27","img":"1","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-10-01 09:00:00","wd":"","weather":"多云","ws":""},{"endTime":"2016-10-01 11:00:00","highestTemperature":"27","img":"2","isRainFall":"降水","lowerestTemperature":"27","precipitation":"1","startTime":"2016-10-01 10:00:00","wd":"","weather":"阴","ws":""},{"endTime":"2016-10-01 12:00:00","highestTemperature":"28","img":"2","isRainFall":"降水","lowerestTemperature":"28","precipitation":"1","startTime":"2016-10-01 11:00:00","wd":"","weather":"阴","ws":""}]
     */

    private WeatherDetailsInfoBean weatherDetailsInfo;
    private List<?> alarms;
    /**
     * abbreviation : zs
     * alias :
     * content : 温度不高，其他各项气象条件适宜，中暑机率极低。
     * level : 无
     * name : 中暑指数
     */

    private List<IndexesBean> indexes;
    /**
     * date : 2016-09-30
     * img : 3
     * sun_down_time : 17:40
     * sun_rise_time : 05:47
     * temp_day_c : 29
     * temp_day_f : 84.2
     * temp_night_c : 24
     * temp_night_f : 75.2
     * wd : 南风
     * weather : 阵雨
     * week : 星期五
     * ws : 0级
     */

    private List<WeathersBean> weathers;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public Pm25Bean getPm25() {
        return pm25;
    }

    public void setPm25(Pm25Bean pm25) {
        this.pm25 = pm25;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public RealtimeBean getRealtime() {
        return realtime;
    }

    public void setRealtime(RealtimeBean realtime) {
        this.realtime = realtime;
    }

    public WeatherDetailsInfoBean getWeatherDetailsInfo() {
        return weatherDetailsInfo;
    }

    public void setWeatherDetailsInfo(WeatherDetailsInfoBean weatherDetailsInfo) {
        this.weatherDetailsInfo = weatherDetailsInfo;
    }

    public List<?> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<?> alarms) {
        this.alarms = alarms;
    }

    public List<IndexesBean> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<IndexesBean> indexes) {
        this.indexes = indexes;
    }

    public List<WeathersBean> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeathersBean> weathers) {
        this.weathers = weathers;
    }

    public static class Pm25Bean {
        private String advice;
        private int aqi;
        private int citycount;
        private int cityrank;
        private String co;
        private String color;
        private String level;
        private String no2;
        private String o3;
        private String pm10;
        private String pm25;
        private String quality;
        private String so2;
        private String timestamp;
        private String upDateTime;

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public int getCitycount() {
            return citycount;
        }

        public void setCitycount(int citycount) {
            this.citycount = citycount;
        }

        public int getCityrank() {
            return cityrank;
        }

        public void setCityrank(int cityrank) {
            this.cityrank = cityrank;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getO3() {
            return o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getUpDateTime() {
            return upDateTime;
        }

        public void setUpDateTime(String upDateTime) {
            this.upDateTime = upDateTime;
        }
    }

    public static class RealtimeBean {
        private String img;
        private int sD;
        private String sendibleTemp;
        private String temp;
        private String time;
        private String wD;
        private String wS;
        private String weather;
        private String ziwaixian;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getSD() {
            return sD;
        }

        public void setSD(int sD) {
            this.sD = sD;
        }

        public String getSendibleTemp() {
            return sendibleTemp;
        }

        public void setSendibleTemp(String sendibleTemp) {
            this.sendibleTemp = sendibleTemp;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getWD() {
            return wD;
        }

        public void setWD(String wD) {
            this.wD = wD;
        }

        public String getWS() {
            return wS;
        }

        public void setWS(String wS) {
            this.wS = wS;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getZiwaixian() {
            return ziwaixian;
        }

        public void setZiwaixian(String ziwaixian) {
            this.ziwaixian = ziwaixian;
        }
    }

    public static class WeatherDetailsInfoBean {
        private String publishTime;
        /**
         * endTime : 2016-09-30 12:00:00
         * highestTemperature : 27
         * img : 2
         * isRainFall : 降水
         * lowerestTemperature : 27
         * precipitation : 1
         * startTime : 2016-09-30 11:00:00
         * wd :
         * weather : 阴
         * ws :
         */

        private List<Weather24HoursDetailsInfosBean> weather24HoursDetailsInfos;

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public List<Weather24HoursDetailsInfosBean> getWeather24HoursDetailsInfos() {
            return weather24HoursDetailsInfos;
        }

        public void setWeather24HoursDetailsInfos(List<Weather24HoursDetailsInfosBean> weather24HoursDetailsInfos) {
            this.weather24HoursDetailsInfos = weather24HoursDetailsInfos;
        }

        public static class Weather24HoursDetailsInfosBean {
            private String endTime;
            private int highestTemperature;
            private String img;
            private String isRainFall;
            private int lowerestTemperature;
            private String precipitation;
            private String startTime;
            private String wd;
            private String weather;
            private String ws;

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public int getHighestTemperature() {
                return highestTemperature;
            }

            public void setHighestTemperature(int highestTemperature) {
                this.highestTemperature = highestTemperature;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIsRainFall() {
                return isRainFall;
            }

            public void setIsRainFall(String isRainFall) {
                this.isRainFall = isRainFall;
            }

            public int getLowerestTemperature() {
                return lowerestTemperature;
            }

            public void setLowerestTemperature(int lowerestTemperature) {
                this.lowerestTemperature = lowerestTemperature;
            }

            public String getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(String precipitation) {
                this.precipitation = precipitation;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWs() {
                return ws;
            }

            public void setWs(String ws) {
                this.ws = ws;
            }
        }
    }

    public static class IndexesBean {
        private String abbreviation;
        private String alias;
        private String content;
        private String level;
        private String name;

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class WeathersBean {
        private Date date;
        private String img;
        private String sun_down_time;
        private String sun_rise_time;
        private int temp_day_c;
        private String temp_day_f;
        private int temp_night_c;
        private String temp_night_f;
        private String wd;
        private String weather;
        private String week;
        private String ws;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSun_down_time() {
            return sun_down_time;
        }

        public void setSun_down_time(String sun_down_time) {
            this.sun_down_time = sun_down_time;
        }

        public String getSun_rise_time() {
            return sun_rise_time;
        }

        public void setSun_rise_time(String sun_rise_time) {
            this.sun_rise_time = sun_rise_time;
        }

        public int getTemp_day_c() {
            return temp_day_c;
        }

        public void setTemp_day_c(int temp_day_c) {
            this.temp_day_c = temp_day_c;
        }

        public String getTemp_day_f() {
            return temp_day_f;
        }

        public void setTemp_day_f(String temp_day_f) {
            this.temp_day_f = temp_day_f;
        }

        public int getTemp_night_c() {
            return temp_night_c;
        }

        public void setTemp_night_c(int temp_night_c) {
            this.temp_night_c = temp_night_c;
        }

        public String getTemp_night_f() {
            return temp_night_f;
        }

        public void setTemp_night_f(String temp_night_f) {
            this.temp_night_f = temp_night_f;
        }

        public String getWd() {
            return wd;
        }

        public void setWd(String wd) {
            this.wd = wd;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWs() {
            return ws;
        }

        public void setWs(String ws) {
            this.ws = ws;
        }
    }
}
