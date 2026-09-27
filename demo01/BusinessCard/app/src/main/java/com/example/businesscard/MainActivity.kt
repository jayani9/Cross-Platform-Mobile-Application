package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard(
        imagePainter=painterResource(R.drawable.android_logo),
        fullName= stringResource(R.string.full_name),
        title= stringResource(R.string.title),
    )
    BusinessContact(
        phone= stringResource(R.string.phone_number),
        link = stringResource(R.string.sharing_link),
        email = stringResource(R.string.email)
    )
}

@Composable
private fun BusinessCard(
    imagePainter: Painter,
    fullName:String,
    title:String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box (
            modifier = Modifier
                .padding(end = 16.dp)
                .size(105.dp)
                .background(
                    color = Color(0xFF071611)
                )
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp),

                )
        }
        Text(
            text = fullName,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
        Text(
            text = title,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            lineHeight = 20.sp,
            color = Color(0xFF3ddc84)
        )
    }

}
@Composable
fun BusinessContact(
    phone:String,
    link:String,
    email:String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.Bottom)
            .wrapContentWidth()
            .padding(bottom = 60.dp),
    ) {

        // Row for Phone
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Phone Icon",
                tint = Color(0xFF071611),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = phone,
                color = Color(0xFF071611),
                fontSize = 14.sp, // Adjust font size
                lineHeight = 24.sp // Adjust line height
            )
        }

        // Row for Share link
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Share, // Icon for share
                contentDescription = "Share Icon",
                tint = Color(0xFF071611),
                modifier = Modifier.size(20.dp) // Adjust icon size
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = link,
                color = Color(0xFF071611),
                fontSize = 14.sp, // Adjust font size
                lineHeight = 24.sp // Adjust line height
            )
        }

        // Row for Email
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Email, // Icon for email
                contentDescription = "Email Icon",
                tint = Color(0xFF071611),
                modifier = Modifier.size(20.dp) // Adjust icon size
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = email,
                color = Color(0xFF071611),
                fontSize = 14.sp, // Adjust font size
                lineHeight = 24.sp // Adjust line height
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}