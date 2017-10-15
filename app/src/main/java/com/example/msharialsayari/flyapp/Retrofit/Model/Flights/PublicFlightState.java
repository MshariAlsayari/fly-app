
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicFlightState {

    @SerializedName("flightStates")
    @Expose
    private List<String> flightStates = null;

    public List<String> getFlightStates() {
        return flightStates;
    }

    public void setFlightStates(List<String> flightStates) {
        this.flightStates = flightStates;
    }

}
