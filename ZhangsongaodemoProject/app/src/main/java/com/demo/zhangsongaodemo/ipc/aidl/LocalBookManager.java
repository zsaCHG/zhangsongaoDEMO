package com.demo.zhangsongaodemo.ipc.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.demo.zhangsongaodemo.ipc.Book;
import com.demo.zhangsongaodemo.ipc.BookArrivedListener;

import java.util.List;

/**
 * 手写的binder
 */
public interface LocalBookManager extends IInterface {

    public List<Book> getBookList() throws RemoteException;

    public void addListener(BookArrivedListener bookArrivedListener) throws RemoteException;

    public static final String des="com.demo.zhangsongaodemo.ipc.aidl.LocalBookManager";


    public static abstract class Stub extends Binder implements LocalBookManager {

        public static final int firstMethod = Binder.FIRST_CALL_TRANSACTION+1;
        public static final int secondMethod = Binder.FIRST_CALL_TRANSACTION+2;


        public static LocalBookManager asInterface(IBinder iBinder){
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(des);
            if (iInterface != null && iInterface instanceof LocalBookManager) {
                return (LocalBookManager)iInterface;
            }
            return new Proxy(iBinder);
        }

        //具体执行
        @Override
        protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case firstMethod:
                    List<Book> books=this.getBookList();
                    reply.writeNoException();
                    reply.writeTypedList(books);
                    return true;
                case secondMethod:
                    BookArrivedListener bookArrivedListener = BookArrivedListener.Stub.asInterface(data.readStrongBinder());
                    addListener(bookArrivedListener);
                    Log.d("AIDL","add It");
                    return true;
            }

            return super.onTransact(code, data, reply, flags);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }


    }

    public static class Proxy implements LocalBookManager{
        private android.os.IBinder mRemote;

        Proxy(android.os.IBinder remote) {
            mRemote = remote;
        }

        @Override
        public List<Book> getBookList() throws android.os.RemoteException{
            android.os.Parcel _data = android.os.Parcel.obtain();
            android.os.Parcel _reply = android.os.Parcel.obtain();
            List<Book> books;
            mRemote.transact(Stub.firstMethod,_data,_reply,0);
            _reply.readException();
            return _reply.createTypedArrayList(Book.CREATOR);
        }

        @Override
        public void addListener(BookArrivedListener bookArrivedListener) throws android.os.RemoteException{
            android.os.Parcel _data = android.os.Parcel.obtain();
            android.os.Parcel _reply = android.os.Parcel.obtain();
            _data.writeStrongBinder((((bookArrivedListener != null)) ? (bookArrivedListener.asBinder()) : (null)));
            mRemote.transact(Stub.secondMethod,_data,_reply,0);
            Log.d("AIDL","add It");
        }

        @Override
        public IBinder asBinder() {
            return mRemote;
        }
    }
}
