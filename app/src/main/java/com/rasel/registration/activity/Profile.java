package com.rasel.registration.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rasel.registration.R;
import com.rasel.registration.model.UserInfo;

import java.util.Objects;

public class Profile extends AppCompatActivity {
    private static final String TAG = "Profile";
    private TextView tvNameValue, tvEmailValue, tvAddressValue, tvPhoneValue, tvGenderValue;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvNameValue = findViewById(R.id.tvNameValue);
        tvEmailValue = findViewById(R.id.tvEmailValue);
        tvAddressValue = findViewById(R.id.tvAddressValue);
        tvPhoneValue = findViewById(R.id.tvPhoneValue);
        tvGenderValue = findViewById(R.id.tvGenderValue);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Profile");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            UserInfo userInfo = bundle.getParcelable("userInfo");

            if (userInfo != null) {
                tvNameValue.setText(userInfo.getName());
                tvEmailValue.setText(userInfo.getEmail());
                tvAddressValue.setText(userInfo.getAddress());
                tvPhoneValue.setText(userInfo.getPhone());
                tvGenderValue.setText(userInfo.getGender());
            }
        }
    }
}
