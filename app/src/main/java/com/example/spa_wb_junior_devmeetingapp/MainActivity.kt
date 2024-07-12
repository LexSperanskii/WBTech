package com.example.spa_wb_junior_devmeetingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.spa_wb_junior_devmeetingapp.ui.DevMeetingAppScreen
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SpA_WB_Junior_DevMeetingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpA_WB_Junior_DevMeetingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DevMeetingAppScreen()
                }
            }
        }
    }
}


