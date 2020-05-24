package com.meadetechnologies.advanceddagger2example.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.meadetechnologies.advanceddagger2example.models.User;
import com.meadetechnologies.advanceddagger2example.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

        authApi.getUser(3).toObservable().subscribeOn(Schedulers.io()).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(User user) {
                Log.d(TAG, "onNext: Username: " + user.getUsername());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
