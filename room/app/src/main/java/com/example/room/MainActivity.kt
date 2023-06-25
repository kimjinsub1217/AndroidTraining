package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.room.db.TextDatabase
import com.example.room.entity.TextEntity
import com.example.room.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var textEntity: TextEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = TextDatabase.getDataBase(this)

        val editText = findViewById<EditText>(R.id.editText)
        val insert = findViewById<Button>(R.id.insertButton)
        val getData = findViewById<Button>(R.id.getDataButton)
        val delete = findViewById<Button>(R.id.deleteButton)

        insert.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(TextEntity(0, editText.text.toString()))
                db.wordDao().insert(WordEntity(0, editText.text.toString()))
                editText.setText("")

            }
        }
        getData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.i("김진섭", db.textDao().getAllData().toString())
                Log.i("김진섭2", db.wordDao().getAllData().toString())
            }
        }

        delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
                db.wordDao().deleteAllData()
            }
        }
    }
}