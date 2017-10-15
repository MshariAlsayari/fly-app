
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaggageClaim {

    @SerializedName("belts")
    @Expose
    private List<String> belts = null;

    public List<String> getBelts() {
        return belts;
    }

    public void setBelts(List<String> belts) {
        this.belts = belts;
    }

}
