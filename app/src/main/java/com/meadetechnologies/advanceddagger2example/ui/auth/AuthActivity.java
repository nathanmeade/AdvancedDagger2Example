package com.meadetechnologies.advanceddagger2example.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.meadetechnologies.advanceddagger2example.R;
import com.meadetechnologies.advanceddagger2example.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    private AuthViewModel authViewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    RequestOptions requestOptions;

    @Inject
    RequestManager glideInstance;

    @Inject
    Drawable appDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        authViewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);

        setLogo();
    }

    private void setLogo(){
        ImageView imageView = findViewById(R.id.login_logo);
        glideInstance.load(appDrawable).into(imageView);
    }
}
