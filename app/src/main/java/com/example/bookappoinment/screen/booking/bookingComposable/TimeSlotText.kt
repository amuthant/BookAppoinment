package com.example.bookappoinment.screen.booking.bookingComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookappoinment.R


@Composable
fun TimeSlotText() {
    val robotoLight = FontFamily(
        Font(R.font.robotolight, FontWeight.Light),
        Font(R.font.robotomedium, FontWeight.Medium),

        )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        val text = buildAnnotatedString {
            append("When would you like the shift?")
            pushStyle(SpanStyle(color = Color(0xFFFAA200)))
            append("*")
            pop()
        }

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp),
            fontFamily = robotoLight,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color(0xFF84817A),
        )
        Text(
            text = "Trial shifts are 1 hour",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontFamily = robotoLight,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color(0xFF3F3E3D)
        )

    }


}
