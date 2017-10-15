
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckinAllocation {

    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("rows")
    @Expose
    private Rows rows;
    @SerializedName("startTime")
    @Expose
    private String startTime;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Rows getRows() {
        return rows;
    }

    public void setRows(Rows rows) {
        this.rows = rows;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

}
