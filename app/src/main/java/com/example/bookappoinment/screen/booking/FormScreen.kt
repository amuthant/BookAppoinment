package com.example.bookappoinment.screen.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookappoinment.R
import com.example.bookappoinment.screen.booking.bookingComposable.BookNowButton
import com.example.bookappoinment.screen.booking.bookingComposable.BookingCard
import com.example.bookappoinment.screen.booking.bookingComposable.DateCard
import com.example.bookappoinment.screen.booking.bookingComposable.ServiceSelection
import com.example.bookappoinment.screen.booking.bookingComposable.TimeCard
import com.example.bookappoinment.screen.booking.bookingComposable.TimeSlotText
import com.example.bookappoinment.screen.booking.bookingComposable.HeaderSection

@Composable
fun FormScreen() {
    var userInput by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFBFAF5))
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Booking image",
                modifier = Modifier.size(42.dp)
            )
            HeaderSection()

            BookingCard()
            TimeSlotText()
            DateCard()
            TimeCard()
            ServiceSelection(userInput) { userInput = it }

        }

        BookNowButton(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

