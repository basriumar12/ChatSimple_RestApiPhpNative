package com.blogbasbas.chatsimple.network;

import com.blogbasbas.chatsimple.model.ResponseInsert;
import com.blogbasbas.chatsimple.model.ResponsePesan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by User on 10/08/2018.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("tampil_pesan.php")
    Call<ResponsePesan> tampilPesan(@Field("message_sender") String pengirim,
                                    @Field("message_to") String penerima,
                                    @Field("message_sender1") String penerima1,
                                    @Field("message_to1") String pengirim1);
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseInsert> insertPesan(@Field("message_body") String body,
                                     @Field("message_sender") String sender,
                                     @Field("message_to") String to,
                                     @Field("message_unread") String undread);
}
