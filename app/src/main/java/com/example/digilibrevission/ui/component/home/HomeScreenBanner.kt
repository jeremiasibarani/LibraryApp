package com.example.digilibrevission.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.R

@Composable
fun HomeScreenBanner(
    modifier : Modifier = Modifier,
    onClickScanQr : () -> Unit
){
    Card(
        modifier = modifier
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.extraSmall,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp)
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 15.dp)
            ) {
                Text(
                    text = "Masuk \nperpustakaan?"
                )
                ScanQr(
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.scan_qr_banner),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
        }

    }
}

@Composable
fun ScanQr(
    modifier: Modifier = Modifier
){
    Card(
        shape = MaterialTheme.shapes.extraSmall,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_scan_qr),
                contentDescription = null
            )
            Text(
                text = "Scan QR",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.W500
            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    DigilibRevissionTheme {
        HomeScreenBanner(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

        }
    }
}