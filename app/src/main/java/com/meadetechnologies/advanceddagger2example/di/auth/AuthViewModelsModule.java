package com.meadetechnologies.advanceddagger2example.di.auth;

import androidx.lifecycle.ViewModel;

import com.meadetechnologies.advanceddagger2example.di.ViewModelKey;
import com.meadetechnologies.advanceddagger2example.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
