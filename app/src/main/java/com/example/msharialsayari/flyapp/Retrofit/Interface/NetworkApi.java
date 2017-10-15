package com.example.msharialsayari.flyapp.Retrofit.Interface;

import com.example.msharialsayari.flyapp.Retrofit.Model.Aircrafts.AircraftTypes;
import com.example.msharialsayari.flyapp.Retrofit.Model.Airlines.Airline;
import com.example.msharialsayari.flyapp.Retrofit.Model.Airlines.Airlines;
import com.example.msharialsayari.flyapp.Retrofit.Model.Destinations.Destination;
import com.example.msharialsayari.flyapp.Retrofit.Model.Destinations.Destinations;
import com.example.msharialsayari.flyapp.Retrofit.Model.Flights.Flights;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by msharialsayari on 10/10/2017 AD.
 */

public interface NetworkApi {

    //app_id=c6a22d86
    //app_key=d223f58fb940d910071d1b710f81833f

    /* Flights Api

     type C (/flights)
     https://api.schiphol.nl/public-flights/flights?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&includedelays=false&page=0&sort=%2Bscheduletime

     type B (/flights/{id}/codeshares/{flightName})
     https://api.schiphol.nl/public-flights/flights/122824381577020270/codeshares/HV740?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f

     type A
     https://api.schiphol.nl/public-flights/flights/122824382740007992?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f
    */
    @Headers("ResourceVersion: v3")
    @GET("flights?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&includedelays=false&page=0&sort=%2Bscheduletime")
    Observable<Flights> getFlights();

    @GET("flights?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&includedelays=false&page=0&sort=%2Bscheduletime")
    Call<Flights> getFlightsByCall();
    @GET("flights/{id}?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f")
    Observable<Flights> getFlightsById(@Path(value = "id") String id);

    @GET("flights/{id}/codeshares/{flightName}?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f")
    Observable<Flights> getFlightsByIdAndFlightName(@Path(value = "id") String id, @Path(value = "flightName") String flightName);


     /* Destinations Api
     type A (/destinations)
     https://api.schiphol.nl/public-flights/destinations?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&page=0&sort=%2BpublicName

     type B (/destinations/{iata})
     https://api.schiphol.nl/public-flights/destinations/WPA?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f
    */

    @GET("destinations?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&page=0&sort=%2BpublicName")
    Observable<Destinations> getDestinations();
    @Headers("ResourceVersion: v1")
    @GET("destinations/{iata}?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f")
    Observable<Destination> getDestinationsByIata(@Path(value = "iata") String iata);

    @GET("destinations/{iata}?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f")
    Call<Destination> getDestinationsByIataByCall(@Path(value = "iata") String iata);


     /* Aircrafts Api
     type A (/aircrafttypes)
     https://api.schiphol.nl/public-flights/aircrafttypes?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&page=0&sort=%2Biatamain
    */

    @GET("aircrafttypes?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&page=0&sort=%2Biatamain")
    Observable<AircraftTypes> getAircraftTypes();


     /* Airlines Api
     type A (/airlines)
     https://api.schiphol.nl/public-flights/airlines?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&page=0&sort=%2Bpublicname

     type B (/airlines/{airlineCode})
     https://api.schiphol.nl/public-flights/airlines/JP?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f
    */

    @GET("airlines?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f&page=0&sort=%2Bpublicname")
    Observable<Airlines> getAirlines();


    @Headers("ResourceVersion: v1")
    @GET("airlines/{airlineCode}?app_id=c6a22d86&app_key=d223f58fb940d910071d1b710f81833f")
    Observable<Airline> getAirlinesByAirlineCode(@Path(value = "airlineCode") String airlineCode);





}
