package com.rasel.registration.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rasel.registration.R;
import com.rasel.registration.model.UserInfo;

import java.util.Objects;

public class Profile extends AppCompatActivity {
    private static final String TAG = "Profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tvNameValue = findViewById(R.id.tvNameValue);
        TextView tvEmailValue = findViewById(R.id.tvEmailValue);
        TextView tvAddressValue = findViewById(R.id.tvAddressValue);
        TextView tvPhoneValue = findViewById(R.id.tvPhoneValue);
        TextView tvGenderValue = findViewById(R.id.tvGenderValue);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Profile");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            UserInfo userInfo = bundle.getParcelable("userInfo");

            if (userInfo != null) {

                String name = userInfo.getName();
                String email = userInfo.getEmail();
                String address = userInfo.getAddress();
                String phone = userInfo.getPhone();
                String gender = userInfo.getGender();
                if(name !=null && !name.isEmpty()){
                    tvNameValue.setText(userInfo.getName());
                }
                if(email != null && !email.isEmpty()){
                    tvEmailValue.setText(userInfo.getEmail());
                }
                if(address != null && !address.isEmpty()){
                    tvAddressValue.setText(userInfo.getAddress());
                }
                if(phone !=null && !phone.isEmpty()){
                    tvPhoneValue.setText(userInfo.getPhone());
                }
                if(gender!=null && !gender.isEmpty()){
                    tvGenderValue.setText(userInfo.getGender());
                }
            }
        }
    }
}
