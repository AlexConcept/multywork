package com.example.offzmi.utils

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.*
import android.content.Context


object Utils {

    fun openWebPage(url: String, context: Context) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(context, intent, null)
    }
}

