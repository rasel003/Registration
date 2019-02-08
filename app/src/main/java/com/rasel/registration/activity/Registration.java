package com.rasel.registration.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.rasel.registration.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Registration extends AppCompatActivity {

    private static final String TAG = "Registration";
    private static final int CAMERA_REQUEST_CODE = 303;

    private EditText etName, etEmail, etPhone, etAddress;
    private String name, email, phone, address, gender;
    private Spinner spGender;
    private CircleImageView imgProfilePic;
    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        imgProfilePic = findViewById(R.id.imgProfilePic);
        spGender = findViewById(R.id.spGender);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spGender.setAdapter(adapter);

        //Method to hide keyboard when outside of Edittext is clicked
        findViewById(R.id.mainLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                View view = getCurrentFocus();
                if (view != null) {
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                findViewById(R.id.mainLayout).requestFocus();
                return false;
            }
        });
    }

    public void btnSignUpClicked(View view) {

        if(validate()){
            if(imageBitmap!=null){
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
                Log.d(TAG, "btnSignUpClicked: Successful");
                startActivity(new Intent(this, All_User.class));
            }else {
                Toast.makeText(this, "Please capture a picture of you", Toast.LENGTH_SHORT).show();
            }

        }else{
            Log.d(TAG, "btnSignUpClicked: validation failed");
        }
    }
    public boolean validate() {
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        phone = etPhone.getText().toString();
        address = etAddress.getText().toString();
        gender = spGender.getSelectedItem().toString();

        boolean valid = true;

        if (name.isEmpty()) {
            etName.setError("Name required");
            valid = false;
        } else {
            etName.setError(null);
        }
        if (email.isEmpty()) {
            etEmail.setError("Email address required");
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email address format");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        if (phone.isEmpty()) {
            etPhone.setError("Mobile number required");
            valid = false;
        } else if (phone.length() < 5) {
            etPhone.setError("Mobile number length must be greater than 5 digits");
            valid = false;
        } else {
            etPhone.setError(null);
        }
        if (address.isEmpty()) {
            etAddress.setError("Password required");
            valid = false;
        } else {
            etAddress.setError(null);
        }

        return valid;
    }

    public void btnCaptureClicked(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST_CODE && resultCode==RESULT_OK){
            imageBitmap = (Bitmap) data.getExtras().get("data");

            imgProfilePic.setImageBitmap(imageBitmap);

        }
    }
}
