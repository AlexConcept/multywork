package com.example.multywork.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.util.Base64
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.ContextCompat.startActivity
import java.io.ByteArrayInputStream


object Utils {

    fun openWebPage(url: String, context: Context) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(context, intent, null)
    }

    fun copyToClipboard(textCopied: String, context: Context) {
        val clipboardManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clipboardManager.setPrimaryClip(ClipData.newPlainText("", textCopied))
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2)
            Toast.makeText(context, "Посилання було скопійовано до буфера обміну", LENGTH_SHORT)
                .show()
    }

    fun base64ToBitmap(base64String: String, context: Context): Bitmap? {
        val decodedString = Base64.decode(base64String, Base64.DEFAULT)
        val inputStream = ByteArrayInputStream(decodedString)
        val decodedBitmap = BitmapFactory.decodeStream(inputStream)
        return decodedBitmap ?: run {
            Log.e("Utils", "Error decoding base64 string")
            null
        }
    }
}


