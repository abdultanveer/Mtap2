package com.abdul.mtap2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.abdul.mtap2.model.Word

class MainActivity : AppCompatActivity() {

    lateinit var  roomDb: WordRoomDb
    lateinit var wordDao: WordDao
    lateinit var etOne: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etOne = findViewById(R.id.etOne)

        roomDb = WordRoomDb.getDatabase(this)
        wordDao = roomDb.wordDao()
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
        editor.putString("name",data)
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
        var data  = sharedPreferences.getString("name","")
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
        var insertTask = InsertTask(wordDao,word)
        insertTask.execute()


    }
}