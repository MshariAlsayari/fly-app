
package com.example.msharialsayari.flyapp.Retrofit.Model.Aircrafts;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AircraftTypes {

    @SerializedName("aircraftTypes")
    @Expose
    private List<AircraftType> aircraftTypes = null;
    @SerializedName("schemaVersion")
    @Expose
    private String schemaVersion;

    public List<AircraftType> getAircraftTypes() {
        return aircraftTypes;
    }

    public void setAircraftTypes(List<AircraftType> aircraftTypes) {
        this.aircraftTypes = aircraftTypes;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

}
