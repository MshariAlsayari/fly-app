package com.example.msharialsayari.flyapp;

import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.msharialsayari.flyapp.Daggar.Components.DaggerFlyAppComponents;
import com.example.msharialsayari.flyapp.Daggar.Components.FlyAppComponents;
import com.example.msharialsayari.flyapp.Daggar.Module.FlyAppModule;
import com.example.msharialsayari.flyapp.Retrofit.Interface.NetworkApi;
import com.example.msharialsayari.flyapp.Retrofit.Model.Airlines.Airline;
import com.example.msharialsayari.flyapp.Retrofit.Model.Destinations.Destination;
import com.example.msharialsayari.flyapp.Retrofit.Model.Destinations.Destinations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class FlightDetailsActivity extends AppCompatActivity {

    private String flightName;
    private long flightId;
    private String flightDirection;
    private long flightTerminal;
    private String flightGate;
    private String flightSchedualDate;
    private String flightSchedualTime;
    private String flightAirline;
    private ArrayList<String> flightRouteList = new ArrayList<>();
    private ArrayList<Destination> destinationsList = new ArrayList<>();
    private Airline airline;
    private String test;


    @BindView(R.id.textViewFlightName)
    TextView TextViewFlightName;

    @BindView(R.id.textViewIdValue)
    TextView textViewId;

    @BindView(R.id.textViewFlightDirectionValue)
    TextView textViewflughtDirectionValue;

    @BindView(R.id.textViewTerminalValue)
    TextView textViewTerminalValue;

    @BindView(R.id.textViewGate)
    TextView textViewGateValue;

    @BindView(R.id.textViewFlightClassValue)
    TextView textViewFlightClassValue;

    @BindView(R.id.textViewAirlinesValue)
    TextView textViewAirlinesValue;

    @BindView(R.id.cardViewFlightClass)
    CardView cardViewRoute;

    @BindView(R.id.cardViewAirlines)
    CardView cardViewAirline;

    @BindView(R.id.textViewDateValue)
    TextView dateValue;

    @BindView(R.id.textViewTimeValue)
    TextView timeValue;

    @OnClick(R.id.toolbar)
    void backTopreviousActivity(){
        finish();
    }




    @Inject
    NetworkApi networkApi;
    private FlyAppComponents component;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        ButterKnife.bind(this);

        component = DaggerFlyAppComponents.builder().flyAppModule(new FlyAppModule()).build();
        component.inject(this);


            flightName = getIntent().getStringExtra("flightName");
            flightId = getIntent().getLongExtra("flightId", 0);
            flightDirection = getIntent().getStringExtra("flightType");
            flightTerminal = getIntent().getLongExtra("flightTerminal", 0);
            flightGate = getIntent().getStringExtra("flightGate");
            flightSchedualDate = getIntent().getStringExtra("flightDate");
            flightSchedualTime = getIntent().getStringExtra("flightTime");
            flightAirline = getIntent().getStringExtra("flightAirlines");
            flightRouteList = getIntent().getStringArrayListExtra("flightRouteList");


            TextViewFlightName.setText(flightName);
            textViewId.setText(String.valueOf(flightId));
            if (flightDirection.equals("A"))
                textViewflughtDirectionValue.setText(getString(R.string.arrival));
            else textViewflughtDirectionValue.setText(getString(R.string.departure));

            textViewTerminalValue.setText(String.valueOf(flightTerminal));
            if (flightGate != null)
                textViewGateValue.setText(flightGate);
            else
                textViewGateValue.setText(getString(R.string.gateAvailability));


            if (flightRouteList.size() == 1)
                textViewFlightClassValue.setText(flightRouteList.get(0));
            else
                textViewFlightClassValue.setText(getString(R.string.ClickToKnow));

            textViewAirlinesValue.setText(flightAirline);

            dateValue.setText(flightSchedualDate);
            timeValue.setText(flightSchedualTime.substring(0, 5));

            retrieveDestinationsDate();
            retrieveAirlinesData();

            cardViewRoute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(FlightDetailsActivity.this);
                    View listViewInDialog = getLayoutInflater().inflate(R.layout.route_list_view_in_dialog, null);
                    ListView routeListView = (ListView) listViewInDialog.findViewById(R.id.myList);
                    Button doneButton = (Button) listViewInDialog.findViewById(R.id.buttoncancelDialog);
                    CustomAdapter customAdapter = new CustomAdapter(destinationsList);
                    routeListView.setAdapter(customAdapter);
                    mBuilder.setView(listViewInDialog);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();

                    doneButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                }

            });

            cardViewAirline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Snackbar snackBar = Snackbar.make(v, "Airlines : " + airline.getPublicName(), Snackbar.LENGTH_LONG);

                    snackBar.setAction("Dismiss", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackBar.dismiss();
                        }
                    });
                    snackBar.show();
                }
            });


    }

    private void retrieveDestinationsDate() {

        for (counter = 0; counter < flightRouteList.size(); counter++) {
            networkApi.getDestinationsByIata(flightRouteList.get(counter)).map(new Func1<Destination, Destination>() {
                @Override
                public Destination call(Destination destination) {
                    return destination;
                }
            }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Destination>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Destination destination) {
                    destinationsList.add(destination);
                }
            });

        }


    }


    private void retrieveAirlinesData() {
        networkApi.getAirlinesByAirlineCode(flightAirline).map(new Func1<Airline, Airline>() {
            @Override
            public Airline call(Airline airline) {
                return airline;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Airline>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Airline rerieveAirline) {
                airline = rerieveAirline;

            }
        });
    }


    public class CustomAdapter extends BaseAdapter {
        List<Destination> DestinationsList;


        public CustomAdapter(List<Destination> DestinationsList) {
            this.DestinationsList = DestinationsList;

        }


        @Override
        public int getCount() {
            return DestinationsList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_layout, null);

            TextView iataValue = (TextView) convertView.findViewById(R.id.textViewIataValue);
            TextView countryValue = (TextView) convertView.findViewById(R.id.textViewCountryValue);
            TextView cityValue = (TextView) convertView.findViewById(R.id.textViewCityValue);

            iataValue.setText(DestinationsList.get(position).getIata());
            countryValue.setText(DestinationsList.get(position).getCountry());
            cityValue.setText(DestinationsList.get(position).getCity());
            return convertView;
        }
    }




}
