// IBookManager.aidl
package com.demo.zhangsongaodemo.ipc;
import com.demo.zhangsongaodemo.ipc.Book;
import com.demo.zhangsongaodemo.ipc.BookArrivedListener;


// Declare any non-default types here with import statements

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     List<Book> getBookList();

     void addListener(BookArrivedListener bookArrivedListener);

     void removeListener(BookArrivedListener bookArrivedListener);
}
