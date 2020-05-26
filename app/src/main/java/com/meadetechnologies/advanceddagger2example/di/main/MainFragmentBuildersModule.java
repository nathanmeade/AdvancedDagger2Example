package com.meadetechnologies.advanceddagger2example.di.main;

import com.meadetechnologies.advanceddagger2example.ui.main.posts.PostsFragment;
import com.meadetechnologies.advanceddagger2example.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}
