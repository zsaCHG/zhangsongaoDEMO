package com.demo.zhangsongaodemo.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService extends Service {

    private boolean serviceIsOver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new SocketServer()).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private class SocketServer implements Runnable{
        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8688);

            } catch (IOException e) {
                e.printStackTrace();
                return;
            }


            while (!serviceIsOver) {
                try {
                    Socket client=serverSocket.accept();

                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
                    while (!serviceIsOver) {
                        String data = in.readLine();
                        Log.d("Socket", data);
                        out.println("copy that");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
