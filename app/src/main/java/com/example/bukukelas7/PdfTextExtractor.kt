package com.example.bukukelas7

import android.content.Context
import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import com.googlecode.tesseract.android.TessBaseAPI
import java.io.File

class PdfTextExtractor(private val context: Context, private val tessDataPath: String) {

    fun searchForText(filePath: String, searchText: String): Boolean {
        val file = File(filePath)
        val parcelFileDescriptor: ParcelFileDescriptor? = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
        val pdfRenderer = PdfRenderer(parcelFileDescriptor!!)
        val pageCount = pdfRenderer.pageCount

        for (pageIndex in 0 until pageCount) {
            val page = pdfRenderer.openPage(pageIndex)
            val bitmap = renderPageToBitmap(page)
            val text = extractTextFromBitmap(bitmap)

            if (text.contains(searchText, ignoreCase = true)) {
                page.close()
                pdfRenderer.close()
                parcelFileDescriptor.close()
                return true
            }

            page.close()
        }

        pdfRenderer.close()
        parcelFileDescriptor.close()

        return false
    }

    private fun renderPageToBitmap(page: PdfRenderer.Page): Bitmap {
        val width = page.width
        val height = page.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        return bitmap
    }

    private fun extractTextFromBitmap(bitmap: Bitmap): String {
        val tessBaseAPI = TessBaseAPI()

        tessBaseAPI.init(tessDataPath, "eng")
        tessBaseAPI.setImage(bitmap)

        val extractedText = tessBaseAPI.utF8Text
        tessBaseAPI.end()

        return extractedText
    }
}
