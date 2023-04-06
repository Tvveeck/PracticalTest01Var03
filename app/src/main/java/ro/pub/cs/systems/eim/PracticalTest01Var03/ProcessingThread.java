package ro.pub.cs.systems.eim.PracticalTest01Var03;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private int nr1;
    private int nr2;

    public ProcessingThread(Context context, int nr1, int nr2) {
        this.context = context;

        this.nr1 = nr1;
        this.nr2 = nr2;
    }

    @Override
    public void run() {
        Log.d("[Processing Thread]", "Thread has started! PID: " + Process.myPid() + " TID: " + Process.myTid());

        sendMessage("sum");

        sleep();

        sendMessage("dif");

        Log.d("[Processing Thread]", "Thread has stopped!");
    }

    private void sendMessage(String type) {
        Intent intent = new Intent();

        if (type.equals("sum")) {
            intent.setAction("ro.pub.cs.systems.eim.PracticalTest01Var03.sum");
            intent.putExtra("message",
                    new Date(System.currentTimeMillis()) + " sum is " + (nr1 + nr2));
        }
        else if (type.equals("dif")) {
            intent.setAction("ro.pub.cs.systems.eim.PracticalTest01Var03.dif");
            intent.putExtra("message",
                    new Date(System.currentTimeMillis()) + " dif is " + (nr1 - nr2));
        }

        Log.d("[Processing Thread]", "Message sent: " + intent.getStringExtra("message"));
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}