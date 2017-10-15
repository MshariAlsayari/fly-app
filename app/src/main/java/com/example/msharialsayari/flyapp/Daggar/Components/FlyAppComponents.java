package com.example.msharialsayari.flyapp.Daggar.Components;

import com.example.msharialsayari.flyapp.Daggar.Module.FlyAppModule;
import com.example.msharialsayari.flyapp.FlightDetailsActivity;
import com.example.msharialsayari.flyapp.MainActivity;
import com.example.msharialsayari.flyapp.Tabs.FlyTab;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by msharialsayari on 10/10/2017 AD.
 */

@Singleton
@Component(modules = FlyAppModule.class)
public interface FlyAppComponents {

    void inject(FlyTab target);
    void inject(FlightDetailsActivity target);

}
