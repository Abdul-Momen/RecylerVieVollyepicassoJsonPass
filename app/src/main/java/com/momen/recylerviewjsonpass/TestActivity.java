package com.momen.recylerviewjsonpass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestActivity extends AppCompatActivity {

    EditText name,age,company;
    Button addServer;
    String username,userage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        name=findViewById(R.id.nameEt_id);
        age=findViewById(R.id.ageEt_age_id);
        company=findViewById(R.id.et_company);
        addServer=findViewById(R.id.add_btn_id);





        addServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = name.getText().toString();
                userage = age.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://demo.olivineltd.com/primary_attendance/api/school/login",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                if(response.equals("Invalid Credentials"))
                                {
                                    Toast.makeText(TestActivity.this, "MOira ja", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {

                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String name = jsonObject.getString("school_name_en");
                                        Toast.makeText(TestActivity.this, name, Toast.LENGTH_SHORT).show();








                                        //prefs.edit().putString("total_student", "").apply();

                                        //Toast.makeText(LoginActivity.this,school_id,Toast.LENGTH_LONG).show();


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }








                                //



               /*Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);*/

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String , String> params = new HashMap<>();
                        params.put("mobile_no",username);
                        params.put("password",userage);
                        return params;
                    }
                };

                Volley.newRequestQueue(TestActivity.this).add(stringRequest);



            }
        });




    }
}
