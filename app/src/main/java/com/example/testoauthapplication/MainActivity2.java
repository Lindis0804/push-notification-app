package com.example.testoauthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;

public class MainActivity2 extends AppCompatActivity {
    private TextView tvExternalId;
    private Button bLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        tvExternalId.setText(Const.externalId);
        bLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);
                OneSignal.initWithContext(getApplicationContext(), Const.ONESIGNAL_APP_ID);
                OneSignal.getUser().addTag("1","1");
                Log.v("TAG",OneSignal.getUser().getTags()+"");
                Toast.makeText(getApplicationContext(),"Log out successfully.",Toast.LENGTH_SHORT);
                Log.v("TAG","Log out successfully");
            }
        });
    }

    public void findId() {
        tvExternalId = findViewById(R.id.tvURL);
        bLogOut = findViewById(R.id.bLogOut);
    }
}