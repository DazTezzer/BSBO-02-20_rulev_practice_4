package ru.mirea.rulev.looper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.TimeUnit;


public class MyLooper extends Thread{
    public Handler mHandler;
    private Handler mainHandler;
    public MyLooper(Handler mainThreadHandler) {
        mainHandler =mainThreadHandler;
    }
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        mHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message msg) {
                String Prof = msg.getData().getString("KEY1");
                String age = msg.getData().getString("KEY");
                Integer sl = Integer.parseInt(age);
                Message message = new Message();
                Bundle bundle = new Bundle();
                try {
                    TimeUnit.SECONDS.sleep(sl);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                bundle.putString("result", String.format("Возраст - %s Профессия - %s",age , Prof));
                message.setData(bundle);
                mainHandler.sendMessage(message);

            }
        };
        Looper.loop();
    }
}
