package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class contests extends AppCompatActivity {

    ListView mListView;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    int images[] = {R.drawable.pics,R.drawable.sphereonline,R.drawable.forcecode,R.drawable.euler,R.drawable.codeleet,R.drawable.skilldev,R.drawable.sittak,R.drawable.bytecode};
    String Names[] = {"CODE CHEF", "SPHERE ONLINE JUDGE", "CODE FORCES", "PROJECT EULER", "LEET CODE", "DEV SKILL", "KATTIS", "CODE BYTE"};
    String sd[] = {"14 NOV", "24DEC", "18 NOV", "02 DEC", "05 NOV", "12 DEC", "28 NOV", "16 DEC"};
    String ed[] = {"16 NOV", "30DEC", "26 NOV", "23 DEC", "16 NOV", "15 DEC", "29 NOV", "19 DEC"};
    String st[] = {"02:00 pm", "11:30 am", "04:20 pm", "12:00 pm", "02:40 pm", "09:00 am", "05:10 pm", "10:00 am"};
    String et[] = {"05:00 pm", "09:20 pm", "07:40 am", "01:00 am", "11:00 am", "02:20 pm", "04:20 am", "05:30 pm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contests);



        mListView = findViewById(R.id.listView);

        CustomAdaptor customAdaptor =new CustomAdaptor();
        mListView.setAdapter(customAdaptor);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    Toast.makeText(contests.this, "CODE CHEFx", Toast.LENGTH_SHORT).show();
                }
                if (i == 1) {
                    Toast.makeText(contests.this, "CODE FORCESx", Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Toast.makeText(contests.this, "PROJECT EULERx", Toast.LENGTH_SHORT).show();
                }
                if (i == 3) {
                    Toast.makeText(contests.this, "LEETCODEX", Toast.LENGTH_SHORT).show();
                }
                if (i == 4) {
                    Toast.makeText(contests.this, "CODER BYTEX", Toast.LENGTH_SHORT).show();
                }
                if (i == 5) {
                    Toast.makeText(contests.this, "KATTISX", Toast.LENGTH_SHORT).show();
                }
                if (i == 6) {
                    Toast.makeText(contests.this, "DEVSKILLX", Toast.LENGTH_SHORT).show();
                }
                if (i == 7) {
                    Toast.makeText(contests.this, "SPHEREONLINEJUDGEX", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    class CustomAdaptor extends BaseAdapter{
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertview, ViewGroup parent) {


            View view = getLayoutInflater().inflate(R.layout.contestslist, null);
            ImageView mImageView = view.findViewById(R.id.imagesView);
            TextView mTextView = view.findViewById(R.id.textView);
            TextView mTextView2 = view.findViewById(R.id.textView41);
            TextView mTextView3 = view.findViewById(R.id.textView51);
            TextView mTextView4 = view.findViewById(R.id.textView71);
            TextView mTextView5 = view.findViewById(R.id.textView81);

            Toast.makeText(contests.this, "CODE CHEFx", Toast.LENGTH_SHORT).show();

            mImageView.setImageResource(images[i]);
            mTextView.setText(Names[i]);
            mTextView2.setText(sd[i]);
            mTextView3.setText(ed[i]);
            mTextView4.setText(st[i]);
            mTextView5.setText(et[i]);



            return view;
        }
    }

}

