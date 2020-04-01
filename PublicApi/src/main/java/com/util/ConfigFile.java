package com.util;

import com.model.TableName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(TableName tableName) {
        String url = bundle.getString("url");
        String uri = "";
        String testUrl;
        if (tableName == TableName.GETPOETRY) {
            uri = bundle.getString("getPoetry");
        }
        if (tableName == TableName.GETWEATHERDATA) {
            uri = bundle.getString("getWeatherData");
        }
        if (tableName == TableName.GETLUNAR) {
            uri = bundle.getString("getLunar");
        }
        if (tableName == TableName.GETOLDALMANAC) {
            uri = bundle.getString("getOldAlmanac");
        }
        if (tableName == TableName.GETBINGDAYPIC) {
            uri = bundle.getString("getBingDayPic");
        }
        if (tableName == TableName.GETHITOKOTO) {
            uri = bundle.getString("getHitokoto");
        }
        if (tableName == TableName.GETSOLTERMS) {
            uri = bundle.getString("getSolarTerms");
        }
        testUrl = url + uri;
        return testUrl;
    }
}
