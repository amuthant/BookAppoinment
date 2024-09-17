package com.example.bookappoinment.screen.booking.bookingComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DesignLine() {
    Row(
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(4.dp)
                .background(
                    color = Color(0xFF1998BB),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                )
        )
        Spacer(modifier = Modifier.width(6.dp))
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(4.dp)
                .background(
                    color = Color(0xFFD9D5CB),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                )
        )
    }
}