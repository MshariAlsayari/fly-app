
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AircraftType {

    @SerializedName("iatamain")
    @Expose
    private String iatamain;
    @SerializedName("iatasub")
    @Expose
    private String iatasub;

    public String getIatamain() {
        return iatamain;
    }

    public void setIatamain(String iatamain) {
        this.iatamain = iatamain;
    }

    public String getIatasub() {
        return iatasub;
    }

    public void setIatasub(String iatasub) {
        this.iatasub = iatasub;
    }

}
