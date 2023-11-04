package com.example.digilibrevission.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.ui.component.profile.ProfileBanner
import com.example.digilibrevission.ui.component.profile.ProfileMenuCard

@Composable
fun ProfileScreen(
    modifier : Modifier = Modifier
){
    Surface {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            ProfileBanner(
                modifier = Modifier
                    .padding(bottom = 40.dp)
            )
            ProfileMenuCard(
                title = "Password",
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            ProfileMenuCard(
                title = "Review Aplikasi",
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            ProfileMenuCard(
                title = "Keluar"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    DigilibRevissionTheme {
        ProfileScreen()
    }
}