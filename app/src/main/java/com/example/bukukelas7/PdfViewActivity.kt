package com.example.bukukelas7

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bukukelas7.databinding.ActivityPdfViewBinding
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle


class PdfViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPdfViewBinding
    private var lastPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // set toolbar as support action bar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Kembali Ke Daftar Buku"

            // show back button on toolbar
            // on back button press, it will navigate to parent activity
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

        }
        binding.apply {
            toolbar.setNavigationOnClickListener {
                startActivity(Intent(applicationContext, Kelas7Activity::class.java))
                finish()
            }
        }

        checkPdfTitle(intent)

    }



    private fun checkPdfTitle(intent: Intent){
        when (intent.getStringExtra("TitleBook7")) {
            "informatika" -> {
                showPdfFromAssets(Utils.getBSInformatika7KM())
            }
            "pai" -> {
                showPdfFromAssets(Utils.getBSPAI7KM())
            }
            "bindo" -> {
                showPdfFromAssets(Utils.getBSBindo7KM())
            }
            "ipa" -> {
                showPdfFromAssets(Utils.getBSIPA7KM())
            }
            "ips" -> {
                showPdfFromAssets(Utils.getBSIPS7KM())
            }
            "bing" -> {
                showPdfFromAssets(Utils.getBSBingris7KM())
            }
            "mtk" -> {
                showPdfFromAssets(Utils.getBSMTK7KM())
            }
            "pkn" -> {
                showPdfFromAssets(Utils.getBSPKN7KM())
            }
            "penjas" -> {
                showPdfFromAssets(Utils.getBSPJOK7KM())
            }
            "prakarya" -> {
                showPdfFromAssets(Utils.getBSPrakarya7KM())
            }
        }


        when (intent.getStringExtra("Lainnya")){
            "OliMtk" -> {
                showPdfFromAssets(Utils.getBsOliMTK())
            }
            "ChanelYT" -> {
                showPdfFromAssets(Utils.getLinkYT())
            }
        }
    }

    private fun showPdfFromAssets(pdfName: String) {
        binding.pdfView.fromAsset(pdfName)
//            .pages(0, 2, 1, 3, 3, 3)
            .password(null)
            .defaultPage(0)
            .scrollHandle(DefaultScrollHandle(this))
            .onPageChange { page, _ ->
                if (page > lastPage) {
                    binding.appBar.setExpanded(false, true)
                    binding.toolbar.visibility = View.GONE
                } else {
                    binding.appBar.setExpanded(true, true)
                    binding.toolbar.visibility = View.VISIBLE
                }
                lastPage = page
            }
            .onPageError { page, _ ->
                Toast.makeText(
                    this@PdfViewActivity,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .load()

    }

}
