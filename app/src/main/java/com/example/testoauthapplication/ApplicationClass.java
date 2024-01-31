package com.example.testoauthapplication;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.onesignal.Continue;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;
import java.util.Map;

public class ApplicationClass extends Application {
    // NOTE: Replace the below with your own ONESIGNAL_APP_ID

    @Override
    public void onCreate() {
        super.onCreate();

        // Verbose Logging set to help debug issues, remove before releasing your app.
        OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);

        // OneSignal Initialization
        OneSignal.initWithContext(this, Const.ONESIGNAL_APP_ID);

        // requestPermission will show the native Android notification permission prompt.
        // NOTE: It's recommended to use a OneSignal In-App Message to prompt instead.
        OneSignal.getNotifications().requestPermission(true, Continue.with(r -> {
            if (r.isSuccess()) {
                if (r.getData()) {
                    // `requestPermission` completed successfully and the user has accepted permission
                    Log.v("TAG","data: "+r.getData());
                    String externalId = "ed0e57dc-42f7-4e8a-a494-c748ce34099b";
                    OneSignal.login(externalId);
//                    OneSignal.logout();
                    Log.v("TAG","Log out successfully.");
                    OneSignal.getUser().addEmail("hieuld3@smartosc.com");
                    OneSignal.getUser().addSms("+61489921018");
                    OneSignal.getUser().addTag("Kamen Rider","Geats");
                }
                else {
                    // `requestPermission` completed successfully but the user has rejected permission
                }
            }
            else {
                // `requestPermission` completed unsuccessfully, check `r.getThrowable()` for more info on the failure reason
            }
        }));
    }
}
