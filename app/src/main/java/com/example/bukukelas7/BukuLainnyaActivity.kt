package com.example.bukukelas7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bukukelas7.databinding.ActivityBukuLainnyaBinding

class BukuLainnyaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBukuLainnyaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBukuLainnyaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply{
            btnBacklaintoHome.setOnClickListener{
                val intent = Intent(this@BukuLainnyaActivity, MainActivity::class.java)
                startActivity(intent)
            }

            btnOliMTK.setOnClickListener {
                val intent = Intent(this@BukuLainnyaActivity, PdfViewActivity::class.java)
                intent.putExtra("Lainnya", "OliMtk")
                startActivity(intent)
            }

            btnChanelYT.setOnClickListener {
                val intent = Intent(this@BukuLainnyaActivity, PdfViewActivity::class.java)
                intent.putExtra("Lainnya", "ChanelYT")
                startActivity(intent)
            }


        }
    }
}