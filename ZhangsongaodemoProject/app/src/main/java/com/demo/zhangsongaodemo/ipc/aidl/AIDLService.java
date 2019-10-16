package com.demo.zhangsongaodemo.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.demo.zhangsongaodemo.ipc.Book;
import com.demo.zhangsongaodemo.ipc.BookArrivedListener;
import com.demo.zhangsongaodemo.ipc.IBookManager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 流程：客户端拿到服务端的服务对象{@link IBookManager.Stub} 如果是一个进程的就返回本身的{@link IBookManager.Stub} 不是的话 就返回{@link IBookManager.Stub}代理对象
 * 方法调用 不是一个进程 调用代理的方法 调用transact 到 onTransact中
 */
public class AIDLService extends Service {

    private CopyOnWriteArrayList<Book> bookList;

    private RemoteCallbackList<BookArrivedListener> remoteCallbackList;

    public AIDLService() {
        bookList = new CopyOnWriteArrayList<>();
        remoteCallbackList = new RemoteCallbackList<>();

        Book book = new Book();
        book.bookName = "BOOK ONE";
        bookList.add(book);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return new IBookManager.Stub() {
            @Override
            public List<Book> getBookList() throws RemoteException {
                return bookList;
            }

            @Override
            public void addListener(BookArrivedListener bookArrivedListener) throws RemoteException {
                remoteCallbackList.register(bookArrivedListener);


                Book book = new Book();
                book.bookName = "BOOK TWO";
                remoteCallbackList.beginBroadcast();
                remoteCallbackList.getBroadcastItem(0).onBookArrived(book);
            }

            @Override
            public void removeListener(BookArrivedListener bookArrivedListener) throws RemoteException {
                remoteCallbackList.unregister(bookArrivedListener);
            }
        };
    }


}
