package com.meadetechnologies.advanceddagger2example.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.meadetechnologies.advanceddagger2example.SessionManager;
import com.meadetechnologies.advanceddagger2example.network.main.MainApi;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    private final SessionManager sessionManager;
    private final MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
        Log.d(TAG, "PostsViewModel: ViewModel is working...");
    }
}
