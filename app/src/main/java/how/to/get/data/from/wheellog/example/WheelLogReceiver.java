package how.to.get.data.from.wheellog.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Locale;

public class WheelLogReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity.getInstance().set_tv("intent received");
        if (intent.getAction().equals(MainActivity.ACTION_WHEEL_DATA_AVAILABLE)) {
            MainActivity.getInstance().set_tv("new data received");
            if (intent.hasExtra("Speed")) {
                int speed = intent.getIntExtra("Speed", 0);
                String s = String.format(Locale.US, "Speed: %.2f",speed/100.0);
                MainActivity.getInstance().set_tv(s);
            }
        }

    }
}