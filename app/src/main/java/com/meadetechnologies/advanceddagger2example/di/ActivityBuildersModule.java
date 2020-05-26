package com.meadetechnologies.advanceddagger2example.di;

import com.meadetechnologies.advanceddagger2example.di.auth.AuthModule;
import com.meadetechnologies.advanceddagger2example.di.auth.AuthScope;
import com.meadetechnologies.advanceddagger2example.di.auth.AuthViewModelsModule;
import com.meadetechnologies.advanceddagger2example.di.main.MainFragmentBuildersModule;
import com.meadetechnologies.advanceddagger2example.di.main.MainModule;
import com.meadetechnologies.advanceddagger2example.di.main.MainScope;
import com.meadetechnologies.advanceddagger2example.di.main.MainViewModelsModule;
import com.meadetechnologies.advanceddagger2example.ui.auth.AuthActivity;
import com.meadetechnologies.advanceddagger2example.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
