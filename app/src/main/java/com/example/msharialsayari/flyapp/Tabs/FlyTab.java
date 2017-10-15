package com.example.msharialsayari.flyapp.Tabs;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.msharialsayari.flyapp.Adapters.FlightsAdapter;
import com.example.msharialsayari.flyapp.Daggar.Components.DaggerFlyAppComponents;
import com.example.msharialsayari.flyapp.Daggar.Components.FlyAppComponents;
import com.example.msharialsayari.flyapp.Daggar.Module.FlyAppModule;
import com.example.msharialsayari.flyapp.R;
import com.example.msharialsayari.flyapp.Retrofit.Interface.NetworkApi;
import com.example.msharialsayari.flyapp.Retrofit.Model.Flights.Flight;
import com.example.msharialsayari.flyapp.Retrofit.Model.Flights.Flights;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by msharialsayari on 10/11/2017 AD.
 */

public class FlyTab extends Fragment {

    //Flight Direction Indicates whether the commercial flight is a departure flight (d) or an arrival flight (a).

    public static final String KEY_MY_FLIGHT_DIRECTION = "A";
    private String FlightDirection;
    private FlyAppComponents component;
    private ArrayList<Flight> flightList=new ArrayList<>();;
    private FlightsAdapter flightsAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    NetworkApi networkApi;


    public static FlyTab newInstance(String FlightDirection) {
        Bundle args = new Bundle();
        args.putString(KEY_MY_FLIGHT_DIRECTION, FlightDirection);
        FlyTab fragment = new FlyTab();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = DaggerFlyAppComponents.builder().flyAppModule(new FlyAppModule()).build();
        component.inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_flight, container, false);
        ButterKnife.bind(this, view);
        FlightDirection = getArguments().getString(KEY_MY_FLIGHT_DIRECTION);
        if (savedInstanceState != null) {
            flightList = savedInstanceState.getParcelableArrayList("FLIGHT_LIST");
            flightsAdapter = new FlightsAdapter(flightList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(flightsAdapter);
        }
        else
        retrieveData();

        return view;
    }



    private void retrieveData() {
        progressBar.setVisibility(View.VISIBLE);
        networkApi.getFlights().flatMap(new Func1<Flights, Observable<Flight>>() {
            @Override
            public Observable<Flight> call(Flights flights) {
                return Observable.from(flights.getFlights()).filter(new Func1<Flight, Boolean>() {
                    @Override
                    public Boolean call(Flight flight) {
                        return flight.getFlightDirection().equals(FlightDirection);
                    }
                });
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Flight>() {
            @Override
            public void onCompleted() {
                flightsAdapter = new FlightsAdapter(flightList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(flightsAdapter);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onError(Throwable e) {
                Log.d("ERROR" ,e.getMessage())  ;

            }

            @Override
            public void onNext(Flight flight) {
                flightList.add(flight);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("FLIGHT_LIST", flightList);
    }
}
