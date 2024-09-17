package com.example.bookappoinment.screen.booking.bookingComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookappoinment.R
import com.example.bookappoinment.Time
import com.example.bookappoinment.calculateEndTime
import com.example.bookappoinment.formatted
import com.example.bookappoinment.getCurrentTime
import com.example.bookappoinment.showTimePickerDialog


@Composable
fun TimeCard() {
    var startTime by remember { mutableStateOf<Time?>(null) }
    var endTime by remember { mutableStateOf<Time?>(null) }
    val context = LocalContext.current

    TimeCardView(startTime, endTime) {
        showTimePickerDialog(context) { start, end ->
            startTime = start
            endTime = end
        }
    }


}

@Composable
fun TimeCardView(startTime: Time?, endTime: Time?, onClick: () -> Unit) {
    val robotoLight = FontFamily(
        Font(R.font.robotolight, FontWeight.Light),
        Font(R.font.robotomedium, FontWeight.Medium),

        )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(25),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.clock_time),
                contentDescription = "Booking image",
                modifier = Modifier.size(50.dp)
            )
            Column {

                val text = buildAnnotatedString {
                    append("Time")
                    pushStyle(SpanStyle(color = Color(0xFFFAA200)))
                    append("*")
                    pop()
                }
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontFamily = robotoLight,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xDF0E0E0E),
                    fontSize = 16.sp
                )
                Text(
                    text = "${startTime?.formatted() ?: getCurrentTime().formatted()} - ${
                        endTime?.formatted() ?: calculateEndTime(
                            startTime
                        ).formatted()
                    }",
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = robotoLight,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xDF858583),
                    fontSize = 16.sp
                )
            }
        }
    }
}