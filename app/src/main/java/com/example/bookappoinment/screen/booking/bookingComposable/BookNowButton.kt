package com.example.bookappoinment.screen.booking.bookingComposable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BookNowButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1D99BD),
            contentColor = Color(0xFFD6FAFB),

            ),
        shape = RectangleShape,
        enabled = true
    ) {
        Text(
            "Next",
            fontSize = 16.sp
        )
    }
}
