package com.example.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.shop.constants.Urls;
import com.example.shop.dto.LoginDTO;
import com.example.shop.network.ImageRequester;
import com.example.shop.service.NetworkService;
import com.example.shop.service.Post;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;
    private TextInputLayout txtFieldEmail;

    private ImageRequester imageRequester;
    private NetworkImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo=findViewById(R.id.tvInfo);
        txtFieldEmail=findViewById(R.id.txtFieldEmail);

        imageRequester = ImageRequester.getInstance();
        myImage = findViewById(R.id.myimg);
        String urlImg = Urls.BASE+"/images/1.jpg";
        imageRequester.setImageFromUrl(myImage, urlImg);
    }

    public void handleLogin(View view) {
        txtFieldEmail.setError("Маємо проблему");
    }

    public void onClickRequest(View view) {
        LoginDTO model = new LoginDTO();
        model.setEmail("semen@gmail.com");
//        tvInfo.setText("Сало");
        NetworkService.getInstance()
                .getJSONApi()
                .login(model)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
//                        Post post = response.body();
//
//                        tvInfo.append(post.getId() + "\n");
//                        tvInfo.append(post.getUserId() + "\n");
//                        tvInfo.append(post.getTitle() + "\n");
//                        tvInfo.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {

                        tvInfo.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}