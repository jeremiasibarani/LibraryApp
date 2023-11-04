package com.example.digilibrevission.ui.component.penalty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.DigilibRevissionTheme
import com.example.digilibrevission.R
import com.example.digilibrevission.data.BookPenalty


@Composable
fun PenaltyCard(
    modifier : Modifier = Modifier,
    penalty : BookPenalty
){
    Surface {
        Card(
            modifier = modifier,
            shape = MaterialTheme.shapes.small,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = penalty.cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .width(100.dp)
                        .height(130.dp)
                        .clip(
                            MaterialTheme.shapes.small.copy(
                                topStart = CornerSize(5.dp),
                                bottomStart = CornerSize(5.dp),
                                topEnd = CornerSize(0.dp),
                                bottomEnd = CornerSize(0.dp)
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = penalty.title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.W700
                    )
                    Text(
                        text = "by ${penalty.author}",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 11.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = penalty.penaltyPrice,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 13.sp
                            ),
                            modifier = Modifier
                                .weight(1f),
                            fontWeight = FontWeight.W600
                        )
                        Text(
                            text = penalty.date,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 13.sp
                            ),
                            fontWeight = FontWeight.W600
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview(){
    DigilibRevissionTheme {
        PenaltyCard(
            modifier = Modifier
                .fillMaxWidth(),
            penalty = BookPenalty(
                title = "Modern Android Development",
                author = "Android Developer Team",
                date = "12 September 2022",
                penaltyPrice = "Rp. 2.000",
                cover = R.drawable.book_cover
            )
        )
    }
}