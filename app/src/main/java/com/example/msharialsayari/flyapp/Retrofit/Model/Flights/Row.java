
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("desks")
    @Expose
    private Desks desks;
    @SerializedName("position")
    @Expose
    private String position;

    public Desks getDesks() {
        return desks;
    }

    public void setDesks(Desks desks) {
        this.desks = desks;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
