package com.blogbasbas.chatsimple;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogbasbas.chatsimple.model.MessageItem;
import com.blogbasbas.chatsimple.model.ResponseInsert;
import com.blogbasbas.chatsimple.model.ResponsePesan;
import com.blogbasbas.chatsimple.network.ApiService;
import com.blogbasbas.chatsimple.network.IniRetrofit;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_pesan)
    RecyclerView rvPesan;
    @BindView(R.id.edt_message)
    EditText edtMessage;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.swipe_main)
    RefreshLayout swipeMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        rvPesan.setLayoutManager(layoutManager);
        getPesan();
       /* swipeMain.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                getPesan();
            }
        });
*/
        swipeMain.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getPesan();
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        swipeMain.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                getPesan();
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    private void getPesan() {
        ApiService apiService = IniRetrofit.getInstance();
        Call<ResponsePesan> call = apiService.tampilPesan("1", "2", "2", "1");
        call.enqueue(new Callback<ResponsePesan>() {
            @Override
            public void onResponse(Call<ResponsePesan> call, Response<ResponsePesan> response) {
                List<MessageItem> hasilPesan = response.body().getMessage();
                Log.e("Tag", "Hasil List :" + new Gson().toJson(hasilPesan));
                if (response.body().isStatus() == true) {
                    AdapterPesan adapterPesan = new AdapterPesan(hasilPesan);
                    //  swipeMain.setRefreshing(false);
                    rvPesan.setAdapter(adapterPesan);


                } else {
                    Log.e("Tag", "Gagal req data ");
                }
            }

            @Override
            public void onFailure(Call<ResponsePesan> call, Throwable t) {
                Log.e("Tag", "Gagal jaringan " + t.getMessage());

            }
        });
    }

    @OnClick(R.id.btn_send)
    public void onViewClicked1() {
        String pesan = edtMessage.getText().toString();

        if (pesan.isEmpty()) {
            edtMessage.setError("Field TIdak Bisa Kosong");
        } else {
            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Send Pesan");
            progressDialog.show();

            ApiService apiService = IniRetrofit.getInstance();
            Call<ResponseInsert> call = apiService.insertPesan(pesan, "1", "2", "1");
            call.enqueue(new Callback<ResponseInsert>() {
                @Override
                public void onResponse(Call<ResponseInsert> call, Response<ResponseInsert> response) {
                    if (response.body().isStatus() == true) {
                        progressDialog.dismiss();
                        edtMessage.setText("");
                        getPesan();
                    } else {
                        Toast.makeText(MainActivity.this, "Gagal Kirim Data", Toast.LENGTH_SHORT).show();
                    }
                }

                //
                @Override
                public void onFailure(Call<ResponseInsert> call, Throwable t) {
                    Log.e("Tag", "Error jaringan saat insert :" + t.getMessage());
                    Toast.makeText(MainActivity.this, "Error jaringan saat insert", Toast.LENGTH_SHORT).show();


                }
            });

        }
    }


}
