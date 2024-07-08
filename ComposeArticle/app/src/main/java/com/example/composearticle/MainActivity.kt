package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Container(modifier = Modifier, title = stringResource(R.string.title), intro = stringResource(R.string.intro), content = stringResource(R.string.content) )
                }
            }
        }
    }
}

@Composable
fun Container(modifier: Modifier, title: String, intro: String, content: String) {
    Column (modifier = modifier, verticalArrangement = Arrangement.Center) {
        BackgroundImage(modifier = modifier)
        ComposeText(modifier = modifier, title = title, intro = intro, content = content )
    }
}


@Composable
fun BackgroundImage(modifier: Modifier) {

        val image = painterResource(R.drawable.bg_compose_background)
        Box(modifier){
            Image(
                painter = image,
                contentDescription = null,

            )
        }
}

@Composable
fun ComposeText(modifier: Modifier, title: String, intro: String, content: String) {
    Column(modifier) {
        val defaultPadding = 16.dp
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(defaultPadding)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = intro,
            modifier = Modifier.padding(start = defaultPadding, end = defaultPadding)

        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = content,
            modifier = Modifier.padding(defaultPadding),
            textAlign = TextAlign.Justify
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
       Container(modifier = Modifier, title = stringResource(R.string.title), intro = stringResource(R.string.intro), content = stringResource(R.string.content) )
    }
}