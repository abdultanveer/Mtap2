package com.abdul.mtap2.ui.words

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdul.mtap2.ui.addedit.NewWordActivity
import com.abdul.mtap2.R
import com.abdul.mtap2.WordsApplication
import com.abdul.mtap2.data.Word1
import com.abdul.mtap2.model.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class MvvmActivity : AppCompatActivity(), View.OnClickListener,CoroutineScope {
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

        //registering MvvmActivity as an observer
        wordViewModel.allWords.observe(this){
            listOfWords -> listOfWords.let {
            adapter.submitList(it)
            }
        }

        FirebaseMessaging.getInstance().setAutoInitEnabled(true);

    }


    override fun onStart() {
        super.onStart()

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token: String = task.getResult().toString()

                // Log and toast
                //val msg = getString(R.string.msg_token_fmt, token)
                Log.d(TAG, token)
                Toast.makeText(this, token, Toast.LENGTH_SHORT).show()
            })
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


    fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, message , duration).show()
    }

    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")

   fun Context.ansarisToast(message: String){
       Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
   }
}