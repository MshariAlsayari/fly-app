package com.example.msharialsayari.flyapp.Adapters;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.msharialsayari.flyapp.FlightDetailsActivity;
import com.example.msharialsayari.flyapp.R;
import com.example.msharialsayari.flyapp.Retrofit.Model.Flights.Flight;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.msharialsayari.flyapp.ShareVariablesAndMethods.substringDataAndTime;

/**
 * Created by msharialsayari on 10/11/2017 AD.
 */

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.FlightsHolder> {

    List<Flight> flightList;


    public FlightsAdapter(List<Flight> flightList) {
        this.flightList = flightList;
    }




    @Override
    public FlightsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_of_arrival_departure, parent, false);
        FlightsHolder holder = new FlightsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(FlightsHolder holder, int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.mycard);
        Flight flight = flightList.get(position);
        holder.bind(flight);

    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    class FlightsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewFlightName)
        TextView flightName;

        @BindView(R.id.textView1)
        TextView textView1;

        @BindView(R.id.textViewLandingAndOffTime)
        TextView landingAndOffTime;

        @BindView(R.id.textView2)
        TextView textView2;

        @BindView(R.id.textViewGate)
        TextView gate;

        @BindView(R.id.cardView)
        CardView mycard;

        private String flightType;  // is it an arrival or departure flight?

        public FlightsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Flight flight) {
            flightType=flight.getFlightDirection();
            flightName.setText(flight.getFlightName());
            if (flightType.equals("A")) textView1.setText(itemView.getResources().getString(R.string.landingTime)); else textView1.setText(itemView.getResources().getString(R.string.departure));
            if (flightType.equals("A")) landingAndOffTime.setText(substringDataAndTime(flight.getActualLandingTime())); else landingAndOffTime.setText(substringDataAndTime(flight.getActualOffBlockTime()));
            textView2.setText(itemView.getResources().getString(R.string.gate));
            if (flight.getGate() != null)
            gate.setText(flight.getGate());
            else
                gate.setText(itemView.getResources().getString(R.string.nullGate));

            mycard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i  = new Intent(itemView.getContext(), FlightDetailsActivity.class);
                    i.putExtra("flightType",flightType);
                    i.putExtra("flightName",flight.getFlightName());
                    i.putExtra("flightId",flight.getId());
                    i.putExtra("flightTerminal",flight.getTerminal());
                    i.putExtra("flightGate",flight.getGate());
                    i.putExtra("flightDate",flight.getScheduleDate());
                    i.putExtra("flightTime",flight.getScheduleTime());
                    i.putStringArrayListExtra("flightRouteList", (ArrayList<String>) flight.getRoute().getDestinations());
                    i.putExtra("flightAirlines",flight.getPrefixICAO());
                    v.getContext().startActivity(i);
                }
            });




        }
    }
}
