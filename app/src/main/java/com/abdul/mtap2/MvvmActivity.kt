package com.abdul.mtap2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdul.mtap2.model.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MvvmActivity : AppCompatActivity(), View.OnClickListener {
    var TAG = MvvmActivity::class.simpleName
    lateinit var fab: FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: WordzAdapter
    private val wordViewModel: WordViewModel1 by viewModels {
        WordViewModelFactory((application as WordsApplication).repository1)
    }

    var words = arrayOf("word1","word2","word3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        recyclerView = findViewById(R.id.recyclerView)
         adapter = WordzAdapter(words)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        fab = findViewById(R.id.floatingActionButton)

        fab.setOnClickListener(this)

        wordViewModel.allWords.observe(this){
            words-> words.let { adapter.submitList(it) }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        var newWord = intent?.getStringExtra("nw")
        Log.i(TAG,"new word is "+newWord)

        wordViewModel.insert(Word1(newWord.toString()))
    }

    override fun onClick(p0: View?) {
        var intent = Intent(this, NewWordActivity::class.java)
        startActivityForResult(intent,123)
    }
}