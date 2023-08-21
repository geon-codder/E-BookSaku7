package com.example.bukukelas7

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bukukelas7.databinding.ActivityBiodataDeveloperBinding

class BiodataDeveloperActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBiodataDeveloperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiodataDeveloperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnBioDevtoHome.setOnClickListener {
                val intent = Intent(this@BiodataDeveloperActivity, MainActivity::class.java)
                startActivity(intent)
            }
            ivWa.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(
                            "https://api.whatsapp.com/send?phone=+6285163667327&text=Hai, saya ingin bertanya mengenai aplikasi E-Book Saku"
                        )
                    )
                )
            }
            ivInsta.setOnClickListener {
                val uri = Uri.parse("http://instagram.com/_u/abdmalikia")
                val instagram = Intent(Intent.ACTION_VIEW, uri)
                instagram.setPackage("com.instagram.android")
                try{
                    startActivity(instagram)
                } catch (e: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/abdmalikia")))
                }
            }
        }

    }
}