package com.meadetechnologies.advanceddagger2example.di;

import androidx.lifecycle.ViewModelProvider;

import com.meadetechnologies.advanceddagger2example.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
