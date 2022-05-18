package com.composedemo.splitequal.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.composedemo.splitequal.ui.widgets.CenterTextAppBar

@Composable
fun ThankYouScreen() {
    Scaffold(
        topBar = {
            CenterTextAppBar(text = "Thank You")
        }
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
           Text(text = "Thanks For Using Split Equally", style = MaterialTheme.typography.h5)
        }
    }
}