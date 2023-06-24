package com.example.android42_activityforresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android42_activityforresult.databinding.ActivitySecondBinding
import com.example.android42_activityforresult.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            thirdActivityButton.run {
                setOnClickListener {
                    // Activity 종료
                    finish()
                }
            }
        }
    }
}