package com.example.bukukelas7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.bukukelas7.databinding.ActivityKelas7Binding

class Kelas7Activity : AppCompatActivity() {

    private lateinit var binding: ActivityKelas7Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelas7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnBack7toHome.setOnClickListener{
                val intent = Intent(this@Kelas7Activity, MainActivity::class.java)
                startActivity(intent)
            }
            btnIT713.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "informatika")
                startActivity(intent)
            }
            btnAgama713.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "pai")
                startActivity(intent)
            }
            btnBhsIndo713.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "bindo")
                startActivity(intent)
            }
            btnIPA7S113.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "ipa")
                startActivity(intent)
            }
            btnIPS713.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "ips")
                startActivity(intent)
            }
            btnBhsIng713.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "bing")
                startActivity(intent)
            }
            btnMTK7S113.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "mtk")
                startActivity(intent)
            }
            btnPKN713.setOnClickListener {
                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
                intent.putExtra("TitleBook7", "pkn")
                startActivity(intent)
            }
            btnPenjaskes713.setOnClickListener {
//                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
//                intent.putExtra("TitleBook7", "penjas")
//                startActivity(intent)
                Toast.makeText(this@Kelas7Activity, "Buku Belum Tersedia", Toast.LENGTH_SHORT).show()
            }
            btnPrakarya7S113.setOnClickListener {
//                val intent = Intent(this@Kelas7Activity, PdfViewActivity::class.java)
//                intent.putExtra("TitleBook7", "prakarya")
//                startActivity(intent)
                Toast.makeText(this@Kelas7Activity, "Buku Belum Tersedia", Toast.LENGTH_SHORT).show()
            }

        }
    }
}