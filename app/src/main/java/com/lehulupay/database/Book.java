package com.lehulupay.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    int bookId;

    @ColumnInfo(name="book_title")
    String bookTitile;

    @ColumnInfo(name="book_decription")
    String Description;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitile() {
        return bookTitile;
    }

    public void setBookTitile(String bookTitile) {
        this.bookTitile = bookTitile;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
