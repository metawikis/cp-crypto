package page.funkyiconic.copypastapublishing;

import android.app.Service;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {

    private static final String TAG = "SocialMediaService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()");

        // Get the social media messages from the intent.
        String[] messages = intent.getStringArrayExtra("messages");

        // Loop through the messages and display them to the user.
        for (String message : messages) {
            Log.d(TAG, message);
        }

        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
