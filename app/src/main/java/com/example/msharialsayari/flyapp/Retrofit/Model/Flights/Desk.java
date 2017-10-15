
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Desk {

    @SerializedName("checkinClass")
    @Expose
    private CheckinClass checkinClass;
    @SerializedName("position")
    @Expose
    private long position;

    public CheckinClass getCheckinClass() {
        return checkinClass;
    }

    public void setCheckinClass(CheckinClass checkinClass) {
        this.checkinClass = checkinClass;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

}
