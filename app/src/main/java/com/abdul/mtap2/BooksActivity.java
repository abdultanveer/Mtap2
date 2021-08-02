package com.abdul.mtap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.abdul.mtap2.whowroteit.FetchBook;

public class BooksActivity extends AppCompatActivity {
    EditText mBookInput;
    TextView mTitleText,mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }


    public void searchBooksApi(View view) {
        String queryString = mBookInput.getText().toString();
        FetchBookTask fetchBookTask = new FetchBookTask(mTitleText,mAuthorText);
        fetchBookTask.execute(queryString);
    }
}