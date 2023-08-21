package com.example.bukukelas7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bukukelas7.databinding.ActivityPanduanBinding

class PanduanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPanduanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPanduanBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply{
            btnBackPanduantoHome.setOnClickListener{
                val intent = Intent(this@PanduanActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}