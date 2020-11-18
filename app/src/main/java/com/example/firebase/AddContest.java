package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddContest extends AppCompatActivity {

    public static final String TAG = "TAG";
    public static final String TAG1 = "TAG";
    EditText cname,fdate,todate,ftime,ttime;
    Button addBtn;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contest);

        cname = findViewById(R.id.fullName);
        fdate = findViewById(R.id.Email);
        todate = findViewById(R.id.password);
        ftime= findViewById(R.id.phone);
        ttime = findViewById(R.id.dat);
        addBtn = findViewById(R.id.sub);

        fStore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = cname.getText().toString().trim();
                final String fromd = fdate.getText().toString();
                final String tod = todate.getText().toString();
                final String fromt = ftime.getText().toString();
                final String tot = ttime.getText().toString();



                if(TextUtils.isEmpty(name)){
                    cname.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(fromd)){
                    cname.setError("From date is Required");
                    return;
                }
                if(TextUtils.isEmpty(tod)){
                    cname.setError("To date is Required");
                    return;
                }
                if(TextUtils.isEmpty(fromt)){
                    cname.setError("From time is Required");
                    return;
                }
                if(TextUtils.isEmpty(tot)){
                    cname.setError("to time is Required");
                    return;
                }

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String , Object> cname = new HashMap<>();
                cname.put("contestname",name);
                cname.put("fromdate",fromd);
                cname.put("todate",fromd);
                cname.put("fromtime",fromt);
                cname.put("totime",tot);

                db.collection("add").document("Add Contests").set(cname).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(AddContest.this, "Contest Added", Toast.LENGTH_SHORT).show();
                        } }
                });

            }
        });



    }
}