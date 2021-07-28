package com.abdul.mtap2

import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class CProviderActivity : AppCompatActivity() {

    lateinit var cpListview: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cprovider)
        cpListview = findViewById(R.id.cpListView)
        val uriSms: Uri = Uri.parse("content://sms/inbox")
        var fromColumn = arrayOf("body")
        var toTextView = intArrayOf(android.R.id.text1)
        var rowLayout = android.R.layout.simple_list_item_1
        var dataCursor =
            contentResolver.query(uriSms,null,null,null,null,null)

        var adapter:SimpleCursorAdapter =
            SimpleCursorAdapter(this,rowLayout,dataCursor,fromColumn,toTextView,)
        cpListview.adapter =adapter
    }
}