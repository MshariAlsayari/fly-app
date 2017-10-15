
package com.example.msharialsayari.flyapp.Retrofit.Model.Aircrafts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AircraftType {

    @SerializedName("iatamain")
    @Expose
    private String iatamain;
    @SerializedName("iatasub")
    @Expose
    private String iatasub;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("schemaVersion")
    @Expose
    private String schemaVersion;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;

    public String getIatamain() {
        return iatamain;
    }

    public void setIatamain(String iatamain) {
        this.iatamain = iatamain;
    }

    public String getIatasub() {
        return iatasub;
    }

    public void setIatasub(String iatasub) {
        this.iatasub = iatasub;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

}
