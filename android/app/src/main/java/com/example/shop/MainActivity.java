package com.example.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shop.service.NetworkService;
import com.example.shop.service.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo=findViewById(R.id.tvInfo);
    }

    public void onClickRequest(View view) {
//        tvInfo.setText("Сало");
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        tvInfo.append(post.getId() + "\n");
                        tvInfo.append(post.getUserId() + "\n");
                        tvInfo.append(post.getTitle() + "\n");
                        tvInfo.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        tvInfo.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}