package com.example.businesscard


import androidx.compose.material3.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.LocalContentColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                val hexString = "#3280c4"
                val intHex = hexString.substring(1).toInt(16)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(intHex)
                ) {

                }
            }
        }
    }
}

@Composable
fun BusinessCardContainer(
    image: Painter,
    name: String,
    title: String,
    phoneNumber: String,
    shareSocial: String,
    email: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AboutComponent(image = image, name = name , title = title)
        ContactComponent(phoneNumber = phoneNumber, shareSocial = shareSocial , email = email )
    }
}

@Composable
private fun AboutComponent(
    image: Painter, name: String, title: String, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Android logo",
            modifier = modifier.fillMaxWidth()

        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun ContactComponent(
    phoneNumber: String,
    shareSocial: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        Row(modifier.fillMaxWidth()) {
            PhoneIcon(tint = Color.Black)
            Text(
                text = phoneNumber
            )
        }
        Row(modifier.fillMaxWidth()) {
            SocialIcon(tint = Color.Black)
            Text(
                text = shareSocial
            )
        }
        Row(modifier.fillMaxWidth()) {
            EmailIcon(tint = Color.Black)
            Text(
                text = email
            )
        }
    }


}

@Composable
fun PhoneIcon(tint: Color = LocalContentColor.current) {
    Icon(
        imageVector = Icons.Rounded.Phone,
        tint = tint,
        contentDescription = "Phone icon"
    )
}

@Composable
fun SocialIcon(tint: Color = LocalContentColor.current) {
    Icon(
        imageVector = Icons.Rounded.Share,
        tint = tint,
        contentDescription = "Social share"
    )
}

@Composable
fun EmailIcon(tint: Color = LocalContentColor.current) {
    Icon(
        imageVector = Icons.Rounded.Email,
        tint = tint,
        contentDescription = "Social share"
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        val image = painterResource(R.drawable.android_logo)
        BusinessCardContainer(
            image = image,
            name = stringResource(R.string.name) ,
            title = stringResource(R.string.title) ,
            phoneNumber = stringResource(R.string.phone) ,
            shareSocial = stringResource(R.string.social),
            email = stringResource(R.string.email)
        )
    }
}