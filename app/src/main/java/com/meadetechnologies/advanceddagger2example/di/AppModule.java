package com.meadetechnologies.advanceddagger2example.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static String someString(){
        return "This is a test string";
    }

    @Provides
    static boolean getApp(Application application){
        return application == null;
    }

    @Provides
    static int someInt(String string){
        if (string.equals("This is a test string")){
            return 1;
        }
            return 0;
    }
}
