package com.demo.zhangsongaodemo.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.List;

public class BinderPoolService extends Service {
    public BinderPoolService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new BinderCatch.Stub(){
            @Override
            public IBinder catchBinder(int type) throws RemoteException {
                switch (type) {
                    case 0:
                        return new IBookManager.Stub() {
                            @Override
                            public List<Book> getBookList() throws RemoteException {
                                return null;
                            }

                            @Override
                            public void addListener(BookArrivedListener bookArrivedListener) throws RemoteException {
                                Log.d("Pool","new Pool");
                            }

                            @Override
                            public void removeListener(BookArrivedListener bookArrivedListener) throws RemoteException {

                            }
                        };
                }
                return null;
            }
        };
    }
}
