package com.example.digilibrevission.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.R

private const val brightness = -60f
private val colorMatrix = floatArrayOf(
    1f, 0f, 0f, 0f, brightness,
    0f, 1f, 0f, 0f, brightness,
    0f, 0f, 1f, 0f, brightness,
    0f, 0f, 0f, 1f, 0f
)

@Composable
fun BookFactBanner(
    modifier : Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Tahukah kamu?",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.W600
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 10.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.books),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
            )
            Text(
                text = stringResource(id = R.string.books_fact),
                maxLines = 4,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.White
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookFactBannerPreview(){
    DigilibRevissionTheme {
        BookFactBanner(
            modifier = Modifier
                .padding(10.dp)
        )
    }
}