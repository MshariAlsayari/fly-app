
package com.example.msharialsayari.flyapp.Retrofit.Model.Destinations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicName {

    @SerializedName("dutch")
    @Expose
    private String dutch;
    @SerializedName("english")
    @Expose
    private String english;

    public String getDutch() {
        return dutch;
    }

    public void setDutch(String dutch) {
        this.dutch = dutch;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

}
