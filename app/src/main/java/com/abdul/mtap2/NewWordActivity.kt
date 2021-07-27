package com.abdul.mtap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class NewWordActivity : AppCompatActivity() {
    lateinit var wordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        wordEditText = findViewById(R.id.etNewWord)
    }

    fun saveHandler(view: View) {
        var newWord = wordEditText.text.toString()
        var intent = Intent()
        intent.putExtra("nw",newWord)
        setResult(RESULT_OK,intent)
        finish()
    }
}