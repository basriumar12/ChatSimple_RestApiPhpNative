package com.blogbasbas.chatsimple.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 10/08/2018.
 */

public class IniRetrofit {
    private static Retrofit retrofit = null;
    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl("https://wisata-smg-basri.000webhostapp.com/chat/chat/")
                //.baseUrl("http://192.168.95.120/chat/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }

}
