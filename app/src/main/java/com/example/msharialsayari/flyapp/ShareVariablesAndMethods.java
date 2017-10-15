package com.example.msharialsayari.flyapp;

/**
 * Created by msharialsayari on 10/11/2017 AD.
 */

public class ShareVariablesAndMethods {

    public static String substringDataAndTime (String dataAndTime){
        if (dataAndTime != null)
        return dataAndTime.substring(0,10) + "    " + dataAndTime.substring(11,16) ;
        else return "the time is not available";
    }
}
