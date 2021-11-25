package how.to.get.data.from.wheellog.example;


import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    private WheelLogReceiver Receiver;

    public static final String ACTION_WHEEL_DATA_AVAILABLE = "com.cooper.wheellog.wheelDataAvailable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        // Receive broadcast from External App
        IntentFilter intentFilter = new IntentFilter(ACTION_WHEEL_DATA_AVAILABLE);
        Receiver = new WheelLogReceiver();
        if(intentFilter != null)
        {
            registerReceiver(Receiver, intentFilter);
        }
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public void set_tv(String s){
        TextView tvText = (TextView) findViewById (R.id.Tv1);
        tvText.setText(s);
        //Toast.makeText(MainActivity.this, "Data Received from External App", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(Receiver != null)
            unregisterReceiver(Receiver);
    }
}