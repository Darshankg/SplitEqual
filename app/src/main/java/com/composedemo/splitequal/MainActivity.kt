package com.composedemo.splitequal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.composedemo.splitequal.ui.navigation.SplitEqualNavigation
import com.composedemo.splitequal.ui.screens.SplashScreen
import com.composedemo.splitequal.ui.theme.SplitEqualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplitEqualTheme {
                LaunchSplashScreen()
            }
        }
    }
}


@Composable
fun LaunchSplashScreen(){
    SplitEqualNavigation()
}