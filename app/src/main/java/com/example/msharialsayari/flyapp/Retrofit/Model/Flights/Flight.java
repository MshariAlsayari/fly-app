
package com.example.msharialsayari.flyapp.Retrofit.Model.Flights;



import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flight implements Parcelable {

    @SerializedName("actualLandingTime")
    @Expose
    private String actualLandingTime;
    @SerializedName("actualOffBlockTime")
    @Expose
    private String actualOffBlockTime;
    @SerializedName("aircraftRegistration")
    @Expose
    private String aircraftRegistration;
    @SerializedName("aircraftType")
    @Expose
    private AircraftType aircraftType;
    @SerializedName("baggageClaim")
    @Expose
    private BaggageClaim baggageClaim;
    @SerializedName("checkinAllocations")
    @Expose
    private CheckinAllocations checkinAllocations;
    @SerializedName("codeshares")
    @Expose
    private Codeshares codeshares;
    @SerializedName("estimatedLandingTime")
    @Expose
    private String estimatedLandingTime;
    @SerializedName("expectedTimeBoarding")
    @Expose
    private String expectedTimeBoarding;
    @SerializedName("expectedTimeGateClosing")
    @Expose
    private String expectedTimeGateClosing;
    @SerializedName("expectedTimeGateOpen")
    @Expose
    private String expectedTimeGateOpen;
    @SerializedName("expectedTimeOnBelt")
    @Expose
    private String expectedTimeOnBelt;
    @SerializedName("flightDirection")
    @Expose
    private String flightDirection;
    @SerializedName("flightName")
    @Expose
    private String flightName;
    @SerializedName("flightNumber")
    @Expose
    private long flightNumber;
    @SerializedName("gate")
    @Expose
    private String gate;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("mainFlight")
    @Expose
    private String mainFlight;
    @SerializedName("prefixIATA")
    @Expose
    private String prefixIATA;
    @SerializedName("prefixICAO")
    @Expose
    private String prefixICAO;
    @SerializedName("publicEstimatedOffBlockTime")
    @Expose
    private String publicEstimatedOffBlockTime;
    @SerializedName("publicFlightState")
    @Expose
    private PublicFlightState publicFlightState;
    @SerializedName("route")
    @Expose
    private Route route;
    @SerializedName("scheduleDate")
    @Expose
    private String scheduleDate;
    @SerializedName("scheduleTime")
    @Expose
    private String scheduleTime;
    @SerializedName("schemaVersion")
    @Expose
    private String schemaVersion;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("terminal")
    @Expose
    private long terminal;
    @SerializedName("transferPositions")
    @Expose
    private TransferPositions transferPositions;

    protected Flight(Parcel in) {
        actualLandingTime = in.readString();
        actualOffBlockTime = in.readString();
        aircraftRegistration = in.readString();
        estimatedLandingTime = in.readString();
        expectedTimeBoarding = in.readString();
        expectedTimeGateClosing = in.readString();
        expectedTimeGateOpen = in.readString();
        expectedTimeOnBelt = in.readString();
        flightDirection = in.readString();
        flightName = in.readString();
        flightNumber = in.readLong();
        gate = in.readString();
        id = in.readLong();
        mainFlight = in.readString();
        prefixIATA = in.readString();
        prefixICAO = in.readString();
        publicEstimatedOffBlockTime = in.readString();
        scheduleDate = in.readString();
        scheduleTime = in.readString();
        schemaVersion = in.readString();
        serviceType = in.readString();
        terminal = in.readLong();
    }

    public static final Creator<Flight> CREATOR = new Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel in) {
            return new Flight(in);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };

    public String getActualLandingTime() {
        return actualLandingTime;
    }

    public void setActualLandingTime(String actualLandingTime) {
        this.actualLandingTime = actualLandingTime;
    }

    public String getActualOffBlockTime() {
        return actualOffBlockTime;
    }

    public void setActualOffBlockTime(String actualOffBlockTime) {
        this.actualOffBlockTime = actualOffBlockTime;
    }

    public String getAircraftRegistration() {
        return aircraftRegistration;
    }

    public void setAircraftRegistration(String aircraftRegistration) {
        this.aircraftRegistration = aircraftRegistration;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public BaggageClaim getBaggageClaim() {
        return baggageClaim;
    }

    public void setBaggageClaim(BaggageClaim baggageClaim) {
        this.baggageClaim = baggageClaim;
    }

    public CheckinAllocations getCheckinAllocations() {
        return checkinAllocations;
    }

    public void setCheckinAllocations(CheckinAllocations checkinAllocations) {
        this.checkinAllocations = checkinAllocations;
    }

    public Codeshares getCodeshares() {
        return codeshares;
    }

    public void setCodeshares(Codeshares codeshares) {
        this.codeshares = codeshares;
    }

    public String getEstimatedLandingTime() {
        return estimatedLandingTime;
    }

    public void setEstimatedLandingTime(String estimatedLandingTime) {
        this.estimatedLandingTime = estimatedLandingTime;
    }

    public String getExpectedTimeBoarding() {
        return expectedTimeBoarding;
    }

    public void setExpectedTimeBoarding(String expectedTimeBoarding) {
        this.expectedTimeBoarding = expectedTimeBoarding;
    }

    public String getExpectedTimeGateClosing() {
        return expectedTimeGateClosing;
    }

    public void setExpectedTimeGateClosing(String expectedTimeGateClosing) {
        this.expectedTimeGateClosing = expectedTimeGateClosing;
    }

    public String getExpectedTimeGateOpen() {
        return expectedTimeGateOpen;
    }

    public void setExpectedTimeGateOpen(String expectedTimeGateOpen) {
        this.expectedTimeGateOpen = expectedTimeGateOpen;
    }

    public String getExpectedTimeOnBelt() {
        return expectedTimeOnBelt;
    }

    public void setExpectedTimeOnBelt(String expectedTimeOnBelt) {
        this.expectedTimeOnBelt = expectedTimeOnBelt;
    }

    public String getFlightDirection() {
        return flightDirection;
    }

    public void setFlightDirection(String flightDirection) {
        this.flightDirection = flightDirection;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMainFlight() {
        return mainFlight;
    }

    public void setMainFlight(String mainFlight) {
        this.mainFlight = mainFlight;
    }

    public String getPrefixIATA() {
        return prefixIATA;
    }

    public void setPrefixIATA(String prefixIATA) {
        this.prefixIATA = prefixIATA;
    }

    public String getPrefixICAO() {
        return prefixICAO;
    }

    public void setPrefixICAO(String prefixICAO) {
        this.prefixICAO = prefixICAO;
    }

    public String getPublicEstimatedOffBlockTime() {
        return publicEstimatedOffBlockTime;
    }

    public void setPublicEstimatedOffBlockTime(String publicEstimatedOffBlockTime) {
        this.publicEstimatedOffBlockTime = publicEstimatedOffBlockTime;
    }

    public PublicFlightState getPublicFlightState() {
        return publicFlightState;
    }

    public void setPublicFlightState(PublicFlightState publicFlightState) {
        this.publicFlightState = publicFlightState;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public long getTerminal() {
        return terminal;
    }

    public void setTerminal(long terminal) {
        this.terminal = terminal;
    }

    public TransferPositions getTransferPositions() {
        return transferPositions;
    }

    public void setTransferPositions(TransferPositions transferPositions) {
        this.transferPositions = transferPositions;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(actualLandingTime);
        dest.writeString(actualOffBlockTime);
        dest.writeString(aircraftRegistration);
        dest.writeString(estimatedLandingTime);
        dest.writeString(expectedTimeBoarding);
        dest.writeString(expectedTimeGateClosing);
        dest.writeString(expectedTimeGateOpen);
        dest.writeString(expectedTimeOnBelt);
        dest.writeString(flightDirection);
        dest.writeString(flightName);
        dest.writeLong(flightNumber);
        dest.writeString(gate);
        dest.writeLong(id);
        dest.writeString(mainFlight);
        dest.writeString(prefixIATA);
        dest.writeString(prefixICAO);
        dest.writeString(publicEstimatedOffBlockTime);
        dest.writeString(scheduleDate);
        dest.writeString(scheduleTime);
        dest.writeString(schemaVersion);
        dest.writeString(serviceType);
        dest.writeLong(terminal);
    }
}
