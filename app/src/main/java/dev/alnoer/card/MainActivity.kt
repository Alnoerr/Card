package dev.alnoer.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alnoer.card.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardApp()
                }
            }
        }
    }
}


@Composable
fun CardName(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(vertical = 32.dp)
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.logo_content_description),
            modifier = Modifier
                .background(Color.DarkGray)
                .size(height = 120.dp, width = 120.dp)
                .aspectRatio(1f)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = stringResource(R.string.occupation),
            color = Color(0xff006c39),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Contact(imageVector: ImageVector, contentDescription: String, text: String, modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = Color(0xff006c39),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = text,
            color = Color.Black
        )
    }
}

@Composable
fun CardContacts(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(vertical = 32.dp)
    ) {
        Contact(
            imageVector = Icons.Filled.Phone,
            contentDescription = stringResource(R.string.phone_content_description),
            text = stringResource(R.string.phone_number)
        )
        Contact(
            imageVector = Icons.Filled.Share,
            contentDescription = stringResource(R.string.share_content_description),
            text = stringResource(R.string.contact_me)
        )
        Contact(
            imageVector = Icons.Filled.Email,
            contentDescription = stringResource(R.string.email_content_description),
            text = stringResource(R.string.email)
        )
    }
}

@Composable
fun CardApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xffd2e8d4))
    ) {
        Spacer(modifier = Modifier.weight(2.0f))
        CardName()
        Spacer(modifier = Modifier.weight(1.0f))
        CardContacts()
    }
}


@Preview
@Composable
fun CardPreview() {
    CardTheme {
        CardApp()
    }
}