package com.livelucky.lebenindeutschland.ui.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import java.io.IOException

@Composable
fun AssetImageLoad(name: String) {
    val context = LocalContext.current
    var imageBitmap by remember {
        mutableStateOf<ImageBitmap?>(null)
    }

    try {
        with(context.assets.open("jpeg/${name}.jpg")) {
            imageBitmap = BitmapFactory.decodeStream(this).asImageBitmap()
        }
    } catch (e: IOException) {
        imageBitmap = null
    }
    imageBitmap?.apply {
        Image(
            bitmap = this, contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}