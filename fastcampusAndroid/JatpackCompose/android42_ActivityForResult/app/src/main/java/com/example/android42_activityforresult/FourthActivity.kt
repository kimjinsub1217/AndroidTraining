package com.example.android42_activityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.android42_activityforresult.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            FourthActivityTextView.run {
                val data1 = intent.getIntExtra("data1", 0)
                val data2 = intent.getDoubleExtra("data2", 0.0)

                text = "data1 : ${data1}\n"
                append("data2: ${data2}\n")
            }

            FourthActivityButton.run {
                setOnClickListener {
                    val resultIntent = Intent()
                    resultIntent.putExtra("value1", 200)
                    resultIntent.putExtra("value2", 22.22)
                }
            }
        }
    }
}