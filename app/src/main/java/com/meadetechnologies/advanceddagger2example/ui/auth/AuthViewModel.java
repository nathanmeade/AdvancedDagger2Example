package com.meadetechnologies.advanceddagger2example.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.meadetechnologies.advanceddagger2example.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: AuthApi is working");
        if (this.authApi == null){
            Log.d(TAG, "AuthViewModel: AuthApi is null");
        } else {
            Log.d(TAG, "AuthViewModel: AuthApi is not null");
        }
        Log.d(TAG, "AuthViewModel: viewmodel is working...");
    }
}
