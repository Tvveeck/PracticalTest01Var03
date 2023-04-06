package ro.pub.cs.systems.eim.PracticalTest01Var03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class PracticalTest01Var03Service extends Service{
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        int left= intent.getIntExtra("leftText", 0);
//        int right = intent.getIntExtra("rightText", 0);
//        int sum = intent.getIntExtra("sum", 0);

        int nr1 = intent.getIntExtra("nr1", 0);
        int nr2 = intent.getIntExtra("nr2", 0);

        ProcessingThread processingThread = new ProcessingThread(this, nr1, nr2);
        processingThread.start();

        return Service.START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
