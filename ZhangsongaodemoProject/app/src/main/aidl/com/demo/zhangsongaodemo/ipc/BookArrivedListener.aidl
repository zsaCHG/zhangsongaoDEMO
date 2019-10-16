// BookArrivedListener.aidl
package com.demo.zhangsongaodemo.ipc;
import com.demo.zhangsongaodemo.ipc.Book;

// Declare any non-default types here with import statements

interface BookArrivedListener {
    void onBookArrived(in Book book);
}
