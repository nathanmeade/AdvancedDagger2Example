package com.meadetechnologies.advanceddagger2example.di;

import com.meadetechnologies.advanceddagger2example.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Provides
    static String someString(){
        return "This is a test string";
    }
}
