
package com.example.msharialsayari.flyapp.Retrofit.Model.Airlines;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Airline implements Serializable {

    @SerializedName("iata")
    @Expose
    private String iata;
    @SerializedName("icao")
    @Expose
    private String icao;
    @SerializedName("nvls")
    @Expose
    private long nvls;
    @SerializedName("publicName")
    @Expose
    private String publicName;
    @SerializedName("schemaVersion")
    @Expose
    private String schemaVersion;

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public long getNvls() {
        return nvls;
    }

    public void setNvls(long nvls) {
        this.nvls = nvls;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

}
