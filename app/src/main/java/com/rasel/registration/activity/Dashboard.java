package com.rasel.registration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.rasel.registration.R;
import com.rasel.registration.activity.All_User;
import com.rasel.registration.activity.Registration;

import java.util.Objects;

public class Dashboard extends AppCompatActivity {


    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Dashboard");
    }

    public void btnRegistrationClicked(View view) {
        startActivity(new Intent(getApplicationContext(), Registration.class));
    }

    public void btnAllUserClicked(View view) {
        startActivity(new Intent(getApplicationContext(), All_User.class));
    }
    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click Back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
