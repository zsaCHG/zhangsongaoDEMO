package com.demo.zhangsongaodemo.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.demo.zhangsongaodemo.R;
import com.demo.zhangsongaodemo.ipc.aidl.AIDLService;
import com.demo.zhangsongaodemo.ipc.messager.MessengerServerService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class IPCActivity extends AppCompatActivity implements IBinder.DeathRecipient {

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                Messenger messenger = new Messenger(service);
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data", "hello");
                message.what = 0;
                message.setData(bundle);

                message.replyTo = clientMessenger;
                messenger.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private Messenger clientMessenger = new Messenger(new ClientMessengerHandle());


    private ServiceConnection serviceConnectionAIDL = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                IBookManager iBookManager = IBookManager.Stub.asInterface(service);
                Log.d("AIDL",iBookManager.getBookList().get(0).bookName);
                iBookManager.addListener(new BookArrivedListener.Stub() {
                    @Override
                    public void onBookArrived(Book book) throws RemoteException {
                        Log.d("AIDL","DAO LE XIN SHU"+book.bookName);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private ServiceConnection serviceConnectionBinderPool = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                BinderCatch binder = BinderCatch.Stub.asInterface(service);
                IBookManager binder1 = IBookManager.Stub.asInterface(binder.catchBinder(0));

                binder1.asBinder().linkToDeath(IPCActivity.this,0);
                binder1.addListener(null);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };



    private Socket clientSocket;

    private PrintWriter printWriter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                connectUseSocket();
//            }
//        }).start();

        connectUseBinderPool();
    }

    private void connectUseMessenger() {
        Intent intent = new Intent(this, MessengerServerService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void connectUserAidl(){
        Intent intent=new Intent(this, AIDLService.class);
        bindService(intent,serviceConnectionAIDL,Context.BIND_AUTO_CREATE);
    }

    private void connectUseSocket(){

        startService(new Intent(this,SocketService.class));

        Socket socket = null;
        while (socket == null) {
            try {
                socket  = new Socket("localhost",8688);
                clientSocket = socket;
                printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                sendToSocket();
                while (!this.isFinishing()) {
                    String data = bufferedReader.readLine();
                    Log.d("Socket", data);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void connectUseBinderPool(){
        Intent intent=new Intent(this, BinderPoolService.class);
        bindService(intent,serviceConnectionBinderPool,Context.BIND_AUTO_CREATE);
    }

    private void sendToSocket(){
        String msg = "0";
        printWriter.println(msg);
    }

    @Override
    public void binderDied() {

    }

    private static class ClientMessengerHandle extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Log.d("Messenger", msg.getData().getString("data"));
                    break;
            }
        }
    }



    @Override
    protected void onDestroy() {

        super.onDestroy();

        if (clientSocket != null) {
            try {
                clientSocket.shutdownInput();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

