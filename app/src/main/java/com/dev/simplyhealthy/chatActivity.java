package com.dev.simplyhealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class chatActivity extends AppCompatActivity {

    private Button moveToAnotherActivityButton;
    private EditText etUsename;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

      moveToAnotherActivityButton = findViewById(R.id.moveToanotherActivityButton);
      etUsename = findViewById(R.id.usernameEditText);

      moveToAnotherActivityButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              String username = etUsename.getText().toString();
              long currentTimeMillis = System.currentTimeMillis();
              String uniqueId = UUID.randomUUID().toString();

              DatabaseReference databaseRef= FirebaseDatabase.getInstance().getReference("users");


              databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot snapshot) {
                      if(snapshot.exists()){
                          for (DataSnapshot childdata : snapshot.getChildren()){
                              if(childdata.getChildrenCount() <2){
                                  String currentTimestanmp = childdata.getKey();

                                  DatabaseReference userRef = databaseRef.child(currentTimestanmp).child(uniqueId);

                                  userRef.setValue(username);

                                  Intent intent = new Intent(chatActivity.this,typeActivity.class);
                                  startActivity(intent);
                              }else{
                                  DatabaseReference userRef = databaseRef.child(String.valueOf(currentTimeMillis)).child(uniqueId);

                                  userRef.setValue(username);

                                  Intent intent = new Intent(chatActivity.this,typeActivity.class);
                                  startActivity(intent);
                              }
                          }
                      } else {
                          DatabaseReference userRef = databaseRef.child(String.valueOf(currentTimeMillis)).child(uniqueId);

                          userRef.setValue(username);

                          Intent intent = new Intent(chatActivity.this,typeActivity.class);
                          startActivity(intent);



                      }
                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError error) {

                  }
              });

          }
      });
    }
}