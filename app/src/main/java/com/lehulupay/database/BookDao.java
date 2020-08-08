package com.lehulupay.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * from Book")
   List<Book> getAllBook();

    @Insert
    void registerBook(Book... books);
}
