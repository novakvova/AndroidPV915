package com.example.shop.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.shop.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout textFieldEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textFieldEmail = findViewById(R.id.textFieldEmail);
    }

    public void handleClick(View view) {
        textFieldEmail.setError("Вкажіть пошту");

//        RegisterDTO registerDTO = new RegisterDTO();
//        registerDTO.setEmail("ss@gmail.com");
//
//        AccountService.getInstance()
//                .jsonApi()
//                .register(registerDTO)
//                .enqueue(new Callback<AccountResponseDTO>() {
//                    @Override
//                    public void onResponse(Call<AccountResponseDTO> call, Response<AccountResponseDTO> response) {
//                        AccountResponseDTO data = response.body();
////                        tvInfo.setText("response is good");
//                    }
//
//                    @Override
//                    public void onFailure(Call<AccountResponseDTO> call, Throwable t) {
//                        String str = t.toString();
//                        int a =12;
//                    }
//                });
    }
}