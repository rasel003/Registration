package com.rasel.registration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rasel.registration.R;
import com.rasel.registration.adapter.All_User_Adapter;
import com.rasel.registration.api.RetrofitClient;
import com.rasel.registration.model.AllUserResponse;
import com.rasel.registration.model.UserInfo;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class All_User extends AppCompatActivity {

   private RecyclerView recyclerView;
   private ProgressBar progressBar;
   private TextView no_data;

    private static final String TAG = "All_User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);

        Objects.requireNonNull(getSupportActionBar()).setTitle("User Info");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progressBar);
        no_data = findViewById(R.id.no_data);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAllUser();

    }
    private void getAllUser() {

        Call<AllUserResponse> call = RetrofitClient.getInstance().getApi().getUserList();
        call.enqueue(new Callback<AllUserResponse>() {
            @Override
            public void onResponse(Call<AllUserResponse> call, Response<AllUserResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Code: " + response.code());
                    return;
                }
                AllUserResponse allUserResponse = response.body();

                if (allUserResponse != null) {
                    List<UserInfo> userList = allUserResponse.getData();

                    if(userList.size()>0){
                        All_User_Adapter adapter = new All_User_Adapter(All_User.this, userList);
                        recyclerView.setAdapter(adapter);

                        adapter.setOnItemClickListener(new All_User_Adapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(UserInfo userInfo) {
                                Intent intent = new Intent(All_User.this, Profile.class);
                                intent.putExtra("userInfo", userInfo);
                                startActivity(intent);
                            }
                        });
                    }
                }else {
                    Log.d(TAG, "onResponse: All User Response is Null");
                }
            }

            @Override
            public void onFailure(Call<AllUserResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                no_data.setVisibility(View.VISIBLE);
                Log.d(TAG, "onFailure: Item Response" + t.getMessage());
            }
        });
    }
}
