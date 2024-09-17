package com.example.bookappoinment.screen.booking.bookingComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookappoinment.R


@Composable
fun BookingCard() {
    val booking = Booking("Booking", "$ 36", "Sheeba N.")
    val robotoLight = FontFamily(
        Font(R.font.robotolight, FontWeight.Light),
        Font(R.font.robotomedium, FontWeight.Medium),

        )
    val notoSansDeseretRegular = FontFamily(
        Font(R.font.notosansdeseretregular, FontWeight.Normal),


        )
    Spacer(modifier = Modifier.height(8.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(89.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(25),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.doctor),
                contentDescription = "Booking image",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = booking.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = robotoLight,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xBE0E0E0E),
                    fontSize = 16.sp
                )
                Text(
                    text = booking.provider,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF060202),
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFF6F3EC),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = booking.price,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                    fontFamily = notoSansDeseretRegular,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF060202),
                    fontSize = 16.sp
                )
            }
        }
    }

}

data class Booking(val name: String, val price: String, val provider: String)