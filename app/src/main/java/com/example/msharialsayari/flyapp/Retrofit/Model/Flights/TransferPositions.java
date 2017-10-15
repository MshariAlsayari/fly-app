
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransferPositions {

    @SerializedName("transferPositions")
    @Expose
    private List<Long> transferPositions = null;

    public List<Long> getTransferPositions() {
        return transferPositions;
    }

    public void setTransferPositions(List<Long> transferPositions) {
        this.transferPositions = transferPositions;
    }

}
