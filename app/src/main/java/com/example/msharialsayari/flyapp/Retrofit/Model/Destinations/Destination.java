
package com.example.msharialsayari.flyapp.Retrofit.Model.Destinations;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Destination implements Parcelable {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("iata")
    @Expose
    private String iata;
    @SerializedName("publicName")
    @Expose
    private PublicName publicName;
    @SerializedName("schemaVersion")
    @Expose
    private String schemaVersion;

    protected Destination(Parcel in) {
        city = in.readString();
        country = in.readString();
        iata = in.readString();
        schemaVersion = in.readString();
    }

    public static final Creator<Destination> CREATOR = new Creator<Destination>() {
        @Override
        public Destination createFromParcel(Parcel in) {
            return new Destination(in);
        }

        @Override
        public Destination[] newArray(int size) {
            return new Destination[size];
        }
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public PublicName getPublicName() {
        return publicName;
    }

    public void setPublicName(PublicName publicName) {
        this.publicName = publicName;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(country);
        dest.writeString(iata);
        dest.writeString(schemaVersion);
    }
}
