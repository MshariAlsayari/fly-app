
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("destinations")
    @Expose
    private List<String> destinations = null;

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }

}
