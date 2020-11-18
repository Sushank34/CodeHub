package com.example.firebase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView mListView;
    Button mbtn;
    int images[] = {R.drawable.spec,R.drawable.lap,R.drawable.sugg,R.drawable.ccc,R.drawable.cre};
    String Names[] = {"", "", "", "",""};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);

        Intent intent = new Intent("s.aj.action.DISPLAY_NOTIFICATION");
        PendingIntent broadcast = PendingIntent.getBroadcast(this,100,new Intent(""),PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),broadcast );

        mListView = findViewById(R.id.listView);
        mbtn = (Button)findViewById(R.id.button);

        mbtn.setOnClickListener(this);

        CustomAdaptor customAdaptor =new CustomAdaptor();
        mListView.setAdapter(customAdaptor);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    Toast.makeText(MainActivity.this, "CONTESTS", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),contests.class));
                }
                if (i == 1) {
                    Toast.makeText(MainActivity.this, "SITES", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),sites.class));
                }
                if (i == 2) {
                    Toast.makeText(MainActivity.this, "SUGGESTION", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),suggestion.class));
                }
                if (i == 3) {
                    startActivity(new Intent(getApplicationContext(),AddContest.class));
                }
                if (i == 4) {
                    Toast.makeText(MainActivity.this, "CREDITS", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),credit.class));
                }

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view==mbtn){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),Login.class));
            Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
            finish();
        }

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

            View view = getLayoutInflater().inflate(R.layout.mainlist, null);
            ImageView mImageView = view.findViewById(R.id.image);
            TextView mTextView = view.findViewById(R.id.textView);

            mImageView.setImageResource(images[i]);
            mTextView.setText(Names[i]);

            return view;
        }
    }


}