package com.example.digilibrevission.ui.component.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.R

@Composable
fun ProfileBanner(
    modifier : Modifier = Modifier
){
    Row(
        modifier = modifier
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(15.dp)
                .size(90.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Jeremia Sibarani",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 18.sp
                ),
                fontWeight = FontWeight.W700,
                modifier = Modifier
                    .padding(bottom = 3.dp)
            )
            Text(
                text = "Fakultas MIPA",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 17.sp
                ),
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileBannerPreview(){
    DigilibRevissionTheme {
        ProfileBanner(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}