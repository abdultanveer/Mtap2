package com.abdul.mtap2.ui.addedit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.abdul.mtap2.R
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


class NewWordActivity : AppCompatActivity() {
    companion object{
        val TAG = NewWordActivity::class.java.simpleName
    }
    private lateinit var db: FirebaseFirestore
    lateinit var wordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        
        wordEditText = findViewById(R.id.etNewWord)
        db = FirebaseFirestore.getInstance()
    }

    fun saveHandler(view: View) {
        //sendDataActivity()
        sendDataFirestore()
    }

    private fun sendDataFirestore() {
        // Create a new user with a first and last name
        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "pritam"
        user["last"] = "shobit"
        user["born"] = 2021

// Add a new document with a generated ID

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->
                Log.d(
                    TAG,
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            })
            .addOnFailureListener(OnFailureListener { e -> Log.w(TAG, "Error adding document", e) })
    }

    private fun sendDataActivity() {
        var newWord = wordEditText.text.toString()
        var intent = Intent()
        intent.putExtra("nw", newWord)
        setResult(RESULT_OK, intent)
        finish()
    }
}