
package com.example.msharialsayari.flyapp.Retrofit.Model.Destinations;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Destinations {

    @SerializedName("destinations")
    @Expose
    private List<Destination> destinations = null;
    @SerializedName("schemaVersion")
    @Expose
    private String schemaVersion;

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

}
