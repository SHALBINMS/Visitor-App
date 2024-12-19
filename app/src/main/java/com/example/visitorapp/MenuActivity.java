package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MenuActivity extends AppCompatActivity {

    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        bt1=(Button) findViewById(R.id.databtn);
        bt2=(Button) findViewById(R.id.viewbtn);


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ob = new Intent(getApplicationContext(), ViewActivity.class);
                startActivity(ob);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(obj);
            }
        });
    }
}