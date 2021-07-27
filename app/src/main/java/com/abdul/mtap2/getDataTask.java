package com.abdul.mtap2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.lifecycle.LiveData;

import com.abdul.mtap2.model.Word;

import java.util.List;

public class getDataTask extends AsyncTask<Void, Void, LiveData<List<Word>>> {

    ListView mListView;
    WordDao mwordWordDao;
    Context mContext;
    public getDataTask(Context context,ListView mListView, WordDao mwordWordDao) {
        mContext = context;
        this.mListView = mListView;
        this.mwordWordDao = mwordWordDao;
    }

    @Override
    protected LiveData<List<Word>> doInBackground(Void... voids) {
       return mwordWordDao.getAllWords();
    }

    @Override
    protected void onPostExecute(LiveData<List<Word>> words) {
        super.onPostExecute(words);
        ArrayAdapter<String> adapter =
                new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, (List<Word>) words);
        mListView.setAdapter(adapter);
    }
}
