package com.rasel.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            int id = bundle.getInt("id");
            Toast.makeText(this, "ID is: "+id, Toast.LENGTH_SHORT).show();
        }
    }
}
