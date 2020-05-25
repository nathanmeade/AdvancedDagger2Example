package com.meadetechnologies.advanceddagger2example.di.main;

import androidx.lifecycle.ViewModel;

import com.meadetechnologies.advanceddagger2example.di.ViewModelKey;
import com.meadetechnologies.advanceddagger2example.ui.auth.AuthViewModel;
import com.meadetechnologies.advanceddagger2example.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);
}
