package com.meadetechnologies.advanceddagger2example;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.meadetechnologies.advanceddagger2example.models.User;
import com.meadetechnologies.advanceddagger2example.ui.auth.AuthActivity;
import com.meadetechnologies.advanceddagger2example.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        subscribeObservers();
    }

    private void subscribeObservers(){
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null){
                    switch (userAuthResource.status){
                        case LOADING:{
                            Log.d(TAG, "onChanged: LOADING ");
                            break;}
                        case AUTHENTICATED:{
                            Log.d(TAG, "onChanged: LOGIN SUCCESS: " + userAuthResource.data.getEmail());
                            break;}
                        case ERROR:{
                            Log.d(TAG, "onChanged: " + userAuthResource.message);
                            Toast.makeText(BaseActivity.this, userAuthResource.message + "\nDid you enter a number between 1 and 10?", Toast.LENGTH_SHORT).show();
                            break;}
                        case NOT_AUTHENTICATED:{
                            navLoginScreen();
                            break;}
                    }
                }
            }
        });
    }

    private void navLoginScreen(){
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
