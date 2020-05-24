package com.meadetechnologies.advanceddagger2example.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.meadetechnologies.advanceddagger2example.R;
import com.meadetechnologies.advanceddagger2example.models.User;
import com.meadetechnologies.advanceddagger2example.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

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

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        editText = findViewById(R.id.user_id_input);

        findViewById(R.id.login_button).setOnClickListener(this);

        authViewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);

        setLogo();

        subscribeObservers();
    }

    private void subscribeObservers(){
        authViewModel.observeUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null){
                    Log.d(TAG, "onChanged: user is authenticated" + user.getEmail());
                }
            }
        });
    }

    private void setLogo(){
        ImageView imageView = findViewById(R.id.login_logo);
        glideInstance.load(appDrawable).into(imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:{
                attemptLogin();
                break;
            }
        }
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(editText.getText().toString())){
            return;
        }
        authViewModel.authenticateWithId(Integer.parseInt(editText.getText().toString()));
    }
}
