package com.aldoj.yournewsapp.ui.commons

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri

@SuppressLint("QueryPermissionsNeeded")
fun openWebsite(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}