package com.dev.simplyhealthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LaTestBookAppointment extends AppCompatActivity {

    EditText edname,edaddress,edcontact,edpincode;
    Button btnBooking;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_la_test_book_appointment);

        edname = findViewById(R.id.editTextLTBFullName);
        edaddress = findViewById(R.id.editTextLTBAddress);
        edpincode = findViewById(R.id.editTextLTBPincode);
        edcontact = findViewById(R.id.editTextLTBContact);
        btnBooking = findViewById(R.id.buttonLTBBooking);


        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edname.length() == 0 || edaddress.length() == 0 || edcontact.length() <10 )
                {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }


                String username = edname.getText().toString();
                String address = edaddress.getText().toString();
                String contact = edcontact.getText().toString();
                String pincode = edpincode.getText().toString();


                Database db =  new Database(getApplicationContext(),"simplyhealthy",null,1);
                db.cart(username,address,contact,pincode);


                    Toast.makeText(getApplicationContext(), "done ✅", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Your booking is done successfully ✅", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LaTestBookAppointment.this, HomeActivity.class));

            }
        });
    }
}