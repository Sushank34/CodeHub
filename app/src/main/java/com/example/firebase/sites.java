package com.example.firebase;

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

import androidx.appcompat.app.AppCompatActivity;

public class sites extends AppCompatActivity {

    ListView mListView;
    int images[] = {R.drawable.pics,R.drawable.forcecode,R.drawable.euler,R.drawable.codeleet,R.drawable.skilldev,R.drawable.sittak,R.drawable.bytecode,R.drawable.sphereonline};
    String Names[] = {"", "", "", "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);

        mListView = findViewById(R.id.listView);

        CustomAdaptor customAdaptor =new CustomAdaptor();
        mListView.setAdapter(customAdaptor);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent inte=new Intent(sites.this,websites.class);
                inte.putExtra("i",i);
                if (i == 0) {
                    Toast.makeText(sites.this, "CODE CHEF", Toast.LENGTH_SHORT).show();
                }
                if (i == 1) {
                    Toast.makeText(sites.this, "CODE FORCES", Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Toast.makeText(sites.this, "PROJECT EULER", Toast.LENGTH_SHORT).show();
                }
                if (i == 3) {
                    Toast.makeText(sites.this, "LEETCODE", Toast.LENGTH_SHORT).show();
                }
                if (i == 4) {
                    Toast.makeText(sites.this, "CODER BYTE", Toast.LENGTH_SHORT).show();
                }
                if (i == 5) {
                    Toast.makeText(sites.this, "KATTIS", Toast.LENGTH_SHORT).show();
                }
                if (i == 6) {
                    Toast.makeText(sites.this, "DEVSKILL", Toast.LENGTH_SHORT).show();
                }
                if (i == 7) {
                    Toast.makeText(sites.this, "SPHEREONLINEJUDGE", Toast.LENGTH_SHORT).show();
                }
                startActivity(inte);
            }
        });

    }

    class CustomAdaptor extends BaseAdapter {
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

            View view = getLayoutInflater().inflate(R.layout.siteslist, null);
            ImageView mImageView = view.findViewById(R.id.imageView);
            TextView mTextView = view.findViewById(R.id.textView);

            mImageView.setImageResource(images[i]);
            mTextView.setText(Names[i]);

            return view;
        }
    }


}