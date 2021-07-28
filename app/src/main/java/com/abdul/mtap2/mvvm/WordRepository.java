package com.abdul.mtap2.mvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.abdul.mtap2.model.Word;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDb db = WordRoomDb.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    // Must insert data off the main thread
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }


    private static class insertAsyncTask extends AsyncTask
            <Word, Void, Void> {
        private WordDao mAsyncTaskDao;
        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }



}