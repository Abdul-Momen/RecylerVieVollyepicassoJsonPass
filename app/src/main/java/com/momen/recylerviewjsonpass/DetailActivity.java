package com.momen.recylerviewjsonpass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.momen.recylerviewjsonpass.MainActivity.EXTRA_ADRESS;
import static com.momen.recylerviewjsonpass.MainActivity.EXTRA_COMPANY;
import static com.momen.recylerviewjsonpass.MainActivity.EXTRA_CREATOR;
import static com.momen.recylerviewjsonpass.MainActivity.EXTRA_EMAIL;
import static com.momen.recylerviewjsonpass.MainActivity.EXTRA_LIKES;
import static com.momen.recylerviewjsonpass.MainActivity.EXTRA_PHONE;
import static com.momen.recylerviewjsonpass.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DetailActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });

        //recived intent
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        String email = intent.getStringExtra(EXTRA_EMAIL);
        String phone = intent.getStringExtra(EXTRA_PHONE);
        String adress = intent.getStringExtra(EXTRA_ADRESS);
        String companyName = intent.getStringExtra(EXTRA_COMPANY);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);
        ImageView imageView = findViewById(R.id.image_view_detail);


////find id
        TextView textViewCreator = findViewById(R.id.textView_name_id_detail);
        TextView textViewEmail = findViewById(R.id.textView_email_id_detail);
        TextView textViewPhone = findViewById(R.id.textView_phone_id_detail);
        TextView textViewAdress = findViewById(R.id.textView_adress_id_detail);
        TextView textViewCompany = findViewById(R.id.textView_company_name_id_detail);
        TextView textViewLikes = findViewById(R.id.textView_Like_id_detail);


        //picasso image load
        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);

        textViewCreator.setText("Name: "+creatorName);
        textViewEmail.setText("Email: "+email);
        textViewPhone.setText("Phone: "+phone);
        textViewAdress.setText("Adress: "+adress);
        textViewCompany.setText("Company: "+companyName);
        textViewLikes.setText("Likes: " + likeCount);

    }
}
