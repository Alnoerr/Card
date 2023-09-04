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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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

/**
 * Composable that displays android logo, name and occupation.
 */
@Composable
fun CardName(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_size))
                .aspectRatio(1f)
                .background(Color.DarkGray)
        )
        Text(
            text = stringResource(R.string.name),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.occupation),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

/**
 * Composable that contains single row of icon and text.
 */
@Composable
fun Contact(imageVector: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
        )
        Text(text = text)
    }
}

/**
 * Composable that displays list of contacts at the bottom of the app.
 */
@Composable
fun Contacts(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(vertical = dimensionResource(id = R.dimen.padding_large))
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Contact(
                imageVector = Icons.Filled.Phone,
                text = stringResource(R.string.phone_number)
            )
            Contact(
                imageVector = Icons.Filled.Share,
                text = stringResource(R.string.contact_me)
            )
            Contact(
                imageVector = Icons.Filled.Email,
                text = stringResource(R.string.email)
            )
        }
    }
}

/**
 * Main app composable that holds everything together.
 */
@Composable
fun CardApp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.weight(2.0f))
        CardName()
        Spacer(modifier = Modifier.weight(1.0f))
        Contacts()
    }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun CardPreview() {
    CardTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CardApp()
        }
    }
}

/**
 * Composable that displays what the UI of the app looks like in dark theme in the design tab.
 */
@Preview
@Composable
fun CardDarkThemePreview() {
    CardTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CardApp()
        }
    }
}