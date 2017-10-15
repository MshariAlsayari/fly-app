
package com.example.msharialsayari.flyapp.Retrofit.Model.Airlines;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airlines {

    @SerializedName("airlines")
    @Expose
    private List<Airline> airlines = null;
    @SerializedName("schemaVersion")
    @Expose
    private String schemaVersion;

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

}
