package com.meadetechnologies.advanceddagger2example.di.main;

import com.meadetechnologies.advanceddagger2example.di.auth.AuthScope;
import com.meadetechnologies.advanceddagger2example.network.main.MainApi;
import com.meadetechnologies.advanceddagger2example.ui.main.posts.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static PostsRecyclerAdapter provideAdapter(){
        return new PostsRecyclerAdapter();
    }

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }
}
