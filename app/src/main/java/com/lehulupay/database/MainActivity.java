package com.lehulupay.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView bookListView;
    EditText bookTitle;
    EditText bookDescription;
    Button addBook;
    AppDatabase adb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bookListView =findViewById(R.id.book_list);
        bookTitle =findViewById(R.id.bookTitle);
        bookDescription =findViewById(R.id.bookDescription);


        addBook =findViewById(R.id.add_book);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addBook(bookTitle.getText().toString(),bookDescription.getText().toString());
//                bookTitle.setText(" ");
//                bookDescription.setText(" ");
            }
        });

        adb= Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"book_list")
                .allowMainThreadQueries()
                .build();
    }

    private void addBook(String title, String description) {

        Book book=new Book();
        book.setBookTitile(title);
        book.setDescription(description);
        adb.bookDao().registerBook(book);

        List<Book> booklist=adb.bookDao().getAllBook();
        bookListView.setText(" ");
        for (Book one_book:booklist) {
            bookListView.append(""+one_book.getBookId()+"\t"+one_book.getBookTitile()+"\t"+one_book.getDescription()+"\n");
        }

    }

}
