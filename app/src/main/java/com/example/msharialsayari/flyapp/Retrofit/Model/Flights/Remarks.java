
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Remarks {

    @SerializedName("remarks")
    @Expose
    private List<String> remarks = null;

    public List<String> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }

}
