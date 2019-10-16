package com.demo.zhangsongaodemo.ipc.messager;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerServerService extends Service {
    public MessengerServerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    private static class MessengerHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    try {
                        Log.d("Messenger",msg.getData().getString("data"));
                        Message message=new Message();
                        Bundle bundle=new Bundle();
                        bundle.putString("data","SHOU DAO LE THANKS");
                        message.setData(bundle);
                        msg.replyTo.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    break;
            }
        }

    }

    private Messenger messenger = new Messenger(new MessengerHandler());



}
