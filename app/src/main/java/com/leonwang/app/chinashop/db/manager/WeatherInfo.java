package com.leonwang.app.chinashop.db.manager;

import com.leonwang.app.chinashop.db.dao.greendao.Alarms;
import com.leonwang.app.chinashop.db.dao.greendao.Aqi;
import com.leonwang.app.chinashop.db.dao.greendao.HourForeCast;
import com.leonwang.app.chinashop.db.dao.greendao.RealWeather;
import com.leonwang.app.chinashop.db.dao.greendao.WeekForeCast;
import com.leonwang.app.chinashop.db.dao.greendao.Zhishu;

import java.util.List;

/**
 * Created by ghbha on 2016/5/15.
 */
public class WeatherInfo {
    private List<WeekForeCast> weekForeCasts;
    private List<HourForeCast> hourForeCasts;
    private RealWeather realWeather;
    private Aqi aqi;
    private List<Zhishu> zhishu;
    private Alarms alarms;

    public List<WeekForeCast> getWeekForeCasts() {
        return weekForeCasts;
    }

    public void setWeekForeCasts(List<WeekForeCast> weekForeCasts) {
        this.weekForeCasts = weekForeCasts;
    }

    public List<HourForeCast> getHourForeCasts() {
        return hourForeCasts;
    }

    public void setHourForeCasts(List<HourForeCast> hourForeCasts) {
        this.hourForeCasts = hourForeCasts;
    }

    public RealWeather getRealWeather() {
        return realWeather;
    }

    public void setRealWeather(RealWeather realWeather) {
        this.realWeather = realWeather;
    }

    public Aqi getAqi() {
        return aqi;
    }

    public void setAqi(Aqi aqi) {
        this.aqi = aqi;
    }


    public List<Zhishu> getZhishu() {
        return zhishu;
    }

    public void setZhishu(List<Zhishu> zhishu) {
        this.zhishu = zhishu;
    }

    public Alarms getAlarms() {
        return alarms;
    }

    public void setAlarms(Alarms alarms) {
        this.alarms = alarms;
    }
}
