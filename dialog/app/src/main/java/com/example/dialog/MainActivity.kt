package com.example.dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val eventHandler = DialogInterface.OnClickListener { dialog, which ->
            if (which == DialogInterface.BUTTON_POSITIVE) {
                Log.d("클릭1", "클릭했어요")
            } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                Log.d("클릭2", "클릭했어요2")
            }
        }

        binding.button1.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("다이얼로그 창")
                setIcon(R.drawable.ic_launcher_foreground)
                setMessage("정말 종료하시겠어요?")
                setPositiveButton("OK", null)
                setNegativeButton("Cancel", null)
                setNeutralButton("more", null)
                setPositiveButton("YES", eventHandler)
                setNegativeButton("NO", eventHandler)
                show()
            }
        }

        val items = arrayOf<String>("딸기", "바나나", "수박", "복숭아")
        binding.button2.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("아이템 목록")
                setIcon(R.drawable.ic_launcher_foreground)
                setItems(items, object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Log.d("클릭했어요", "선택한 과일 : ${items[which]}")
                    }

                })
                setPositiveButton("닫기", null)
                show()
            }
        }
    }
}