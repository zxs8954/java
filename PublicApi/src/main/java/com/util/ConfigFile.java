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
        if (tableName == TableName.COLUMN) {
            uri = bundle.getString("column");
        }
        testUrl = url + uri;
        return testUrl;
    }
}
