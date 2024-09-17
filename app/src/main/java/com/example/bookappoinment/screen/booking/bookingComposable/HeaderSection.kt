package com.example.bookappoinment.screen.booking.bookingComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookappoinment.R
import com.example.bookappoinment.screen.booking.bookingComposable.DesignLine

@Composable
fun HeaderSection() {
    val typography = MaterialTheme.typography
    val robotoLight = FontFamily(
        Font(R.font.robotolight, FontWeight.Light),
        Font(R.font.robotomedium, FontWeight.Medium),

        )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Book Trial Shift",
            style = typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp),
            fontFamily = FontFamily.Serif,

            )
        Spacer(modifier = Modifier.height(16.dp))
        DesignLine()
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Please complete all required fields",
            style = typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontFamily = robotoLight,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF595651),
            fontSize = 16.sp,
            )
    }
}
