package com.abdul.mtap2

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.abdul.mtap2.model.Word

class MainActivity : AppCompatActivity() {


    lateinit var etOne: EditText
   // lateinit var listview: ListView
    lateinit var adapter: ArrayAdapter<String>
    lateinit var wordTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etOne = findViewById(R.id.etOne)


        //listview = findViewById(R.id.dblist)
        wordTextView = findViewById(R.id.textViewNAme);


    }

    override fun onStart() {
        super.onStart()
        getDataAsync()



    }

    private fun getDataAsync() {
       // var task =   getDataTask(this, listview, wordDao)
            //getDataAsyncTask(this,listview,wordDao,adapter)
       // task.execute()
    }

    override fun onPause() {
        super.onPause()
       // saveData()
    }

    private fun saveData() {
        //get the data from edittext
        var data = etOne.text.toString()
        // create a file
        var sharedPreferences = getSharedPreferences("mtapfile", MODE_PRIVATE)
        //open the file
        var editor = sharedPreferences.edit()
        //write to the file
        editor.putString("name", data)
       // editor.putBoolean() --save the state of a check box
        //save the file
        editor.apply()

    }

    override fun onResume() {
        super.onResume()
      //  restoreData()
    }

    private fun restoreData() {
        //open file
        var sharedPreferences = getSharedPreferences("mtapfile", MODE_PRIVATE)
        //get data from file
        var data  = sharedPreferences.getString("name", "")
        //set the data into edittext
        etOne.setText(data)

    }

    fun dbHandler(view: View) {

        insertWordAsynchronously()
       // wordDao.insert()
    }

    private fun insertWordAsynchronously() {
        var data = etOne.text.toString()
        var word = Word(data)



    }

    class getDataAsyncTask(
        var context: Context,
        var mlistview: ListView,
       // var mWordDao: WordDao,
        var adapter: ArrayAdapter<String>
    ) : AsyncTask<Void, Void, List<Word>>(){

        override fun doInBackground(vararg p0: Void?): List<Word> {
           return List<Word>(4){Word("title")}
            //mWordDao.allWords
        }

        override fun onPostExecute(words: List<Word>?) {
            super.onPostExecute(words)


            adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1)
            adapter.add(words.toString())
            mlistview.adapter = adapter
        }
    }
}