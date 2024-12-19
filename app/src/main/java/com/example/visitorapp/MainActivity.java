package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2,e3,e4;

    String getFname,getLname,getPurpose,getWhomto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.submitbtn);
        b2=(Button) findViewById(R.id.gotobtn);
        e1=(EditText) findViewById(R.id.name1);
        e2=(EditText) findViewById(R.id.name2);
        e3=(EditText) findViewById(R.id.purpose);
        e4=(EditText) findViewById(R.id.whom);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFname=e1.getText().toString();
                getLname=e2.getText().toString();
                getPurpose=e3.getText().toString();
                getWhomto=e4.getText().toString();

                if(getFname.isEmpty()||getLname.isEmpty()||getPurpose.isEmpty()||getWhomto.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Input all fields",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Data Submited",Toast.LENGTH_LONG).show();
                    callApi();
                }

            }

            private void callApi() {
                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data = new JSONObject();
                try {
                    data.put("firstname",getFname);
                    data.put("lastname",getLname);
                    data.put("purpose",getPurpose);
                    data.put("whomToMeet",getWhomto);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"Succcess !",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show()
                );

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(request);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ob = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(ob);
            }
        });

    }
}