package com.demo.zhangsongaodemo.ipc;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public String bookName;
    public int bookId;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bookName);
        dest.writeInt(this.bookId);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.bookName = in.readString();
        this.bookId = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
