package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center

                    ) {
                        MainContainer(modifier = Modifier.padding(innerPadding), text1 = stringResource(R.string.completed)  , text2 = stringResource(R.string.message))
                    }


                }
            }
        }
    }
}

@Composable
fun TaskImage(modifier: Modifier) {
   val image = painterResource(R.drawable.ic_task_completed)
    Box(modifier){
        Image(
            painter = image,
            contentDescription = null
        )
    }
}

@Composable
fun ContentText(modifier: Modifier, text1: String, text2: String) {
    Column(modifier) {
        Text(
            text = text1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Spacer(modifier.width(16.dp))
        Text(
            text = text2,
            fontSize = 16.sp
        )
    }
}
@Composable
fun MainContainer(modifier: Modifier, text1: String, text2: String) {
    Column(modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        TaskImage(modifier)
        ContentText(modifier, text1 = text1, text2 = text2)


    }
}
@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
        MainContainer(modifier = Modifier, text1 = stringResource(R.string.completed)  , text2 = stringResource(R.string.message))
    }
}