package com.example.bookappoinment.screen.booking.bookingComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
fun ServiceSelection(userInput: String, onUserInputChange: (String) -> Unit) {
    val robotoLight = FontFamily(
        Font(R.font.robotolight, FontWeight.Light),
        Font(R.font.robotomedium, FontWeight.Medium),

        )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        val text = buildAnnotatedString {
            append("What do you need help with?")
            pushStyle(SpanStyle(color = Color(0xFFFAA200)))
            append("*")
            pop()
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp),
            fontFamily = robotoLight,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF84817A),
            fontSize = 16.sp
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(Color(0xFFDBF8FE)),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(25),
        ) {
            TextField(
                value = userInput,
                onValueChange = onUserInputChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Green, shape = RoundedCornerShape(8.dp)),
                isError = false,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color(0xFF256D7C),
                    cursorColor = Color(0xFF2091BB),
                    focusedContainerColor = Color(0xFFDBF8FE),
                    unfocusedContainerColor = Color(0xFFDBF8FE),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent

                )
            )
        }
    }
}
