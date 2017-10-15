
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Codeshares {

    @SerializedName("codeshares")
    @Expose
    private List<String> codeshares = null;

    public List<String> getCodeshares() {
        return codeshares;
    }

    public void setCodeshares(List<String> codeshares) {
        this.codeshares = codeshares;
    }

}
