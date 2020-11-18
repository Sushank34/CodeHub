package com.example.firebase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class suggestion extends AppCompatActivity implements View.OnClickListener {

    EditText et1;
    Button bt1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        et1=(EditText)findViewById(R.id.et1);
        bt1=(Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==bt1){
            String[] to = {"sreekar944 @gmail.com"};
            String[] cc = {""};

            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.setData(Uri.parse("mailto:"));
            mail.setType("text/plain");

            mail.putExtra(Intent.EXTRA_EMAIL, to);
            mail.putExtra(Intent.EXTRA_CC, cc);


            mail.putExtra(Intent.EXTRA_TEXT, et1.getText().toString() );
            mail.putExtra(Intent.EXTRA_SUBJECT, "Suggestion from User");

            startActivity(Intent.createChooser(mail, "mailto") );
        }
    }

}