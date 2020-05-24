package com.meadetechnologies.advanceddagger2example.di;

import com.meadetechnologies.advanceddagger2example.di.auth.AuthViewModelsModule;
import com.meadetechnologies.advanceddagger2example.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

}
