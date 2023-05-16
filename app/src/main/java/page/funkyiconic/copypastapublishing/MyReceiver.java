package page.funkyiconic.copypastapublishing;

import static page.funkyiconic.copypastapublishing.R.drawable.ic_notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {

    private Context context;
    private Intent intent;

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the text from the intent
        String text = intent.getStringExtra("text");

        // Create a notification channel.
        NotificationManager notificationManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("my_channel", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }

        // Create a notification builder.
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "my_channel");
        notificationBuilder.setContentTitle("New Message");
        notificationBuilder.setContentText("You have a new message from John Doe.");
        notificationBuilder.setSmallIcon(ic_notification);
        notificationBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Send the notification.
        notificationManager.notify(0, notificationBuilder.build());
    }

    private Object getSystemService(String notificationService) {
    }


}
