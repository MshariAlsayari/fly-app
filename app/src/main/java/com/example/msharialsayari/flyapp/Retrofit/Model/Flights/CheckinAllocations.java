
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckinAllocations {

    @SerializedName("checkinAllocations")
    @Expose
    private List<CheckinAllocation> checkinAllocations = null;
    @SerializedName("remarks")
    @Expose
    private Remarks remarks;

    public List<CheckinAllocation> getCheckinAllocations() {
        return checkinAllocations;
    }

    public void setCheckinAllocations(List<CheckinAllocation> checkinAllocations) {
        this.checkinAllocations = checkinAllocations;
    }

    public Remarks getRemarks() {
        return remarks;
    }

    public void setRemarks(Remarks remarks) {
        this.remarks = remarks;
    }

}
