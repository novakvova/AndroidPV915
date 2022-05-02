package com.example.shop.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shop.BaseActivity;
import com.example.shop.R;
import com.example.shop.account.network.AccountService;
import com.example.shop.account.userscard.UserDTO;
import com.example.shop.account.userscard.UsersAdapter;
import com.example.shop.application.HomeApplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends BaseActivity {

    private UsersAdapter adapter;
    private RecyclerView rcvUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        rcvUsers = findViewById(R.id.rcvUsers);
        rcvUsers.setHasFixedSize(true);
        rcvUsers.setLayoutManager(new GridLayoutManager(this, 2,
                LinearLayoutManager.VERTICAL, false));

        AccountService.getInstance()
                .jsonApi()
                .users()
                .enqueue(new Callback<List<UserDTO>>() {
                    @Override
                    public void onResponse(Call<List<UserDTO>> call, Response<List<UserDTO>> response) {
                        if(response.isSuccessful())
                        {
                            adapter=new UsersAdapter(response.body(),
                                    UsersActivity.this::onClickUserItem,
                                    UsersActivity.this::onClickUserEdit);
                            rcvUsers.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserDTO>> call, Throwable t) {

                    }
                });

    }

    private void onClickUserItem(UserDTO user) {
        //Toast.makeText(HomeApplication.getAppContext(), user.getEmail(), Toast.LENGTH_SHORT).show();
        Intent userIntent = new Intent(UsersActivity.this, UserActivity.class);
        Bundle b = new Bundle();
        b.putLong("id", user.getId());
        userIntent.putExtras(b);
        startActivity(userIntent);

    }

    private void onClickUserEdit(UserDTO user) {
        Toast.makeText(HomeApplication.getAppContext(), user.getEmail(), Toast.LENGTH_SHORT).show();
    }
}