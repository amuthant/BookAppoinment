package com.example.bookappoinment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun Time?.formatted(): String = this?.let {
    val amPm = if (it.hour < 12) "am" else "pm"
    val formattedHour = if (it.hour % 12 == 0) "12" else (it.hour % 12).toString()
    val formattedMinute = if (it.minute < 10) "0${it.minute}" else it.minute.toString()
    "$formattedHour:$formattedMinute$amPm"
} ?: ""

fun getCurrentTime(): Time {
    val calendar = Calendar.getInstance()
    return Time(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))
}

fun calculateEndTime(startTime: Time?): Time {
    return startTime?.let {
        val endHour = (it.hour + 1 + (it.minute + 60) / 60) % 24
        val endMinute = (it.minute + 60) % 60
        Time(endHour, endMinute)
    } ?: run {
        val calendar = Calendar.getInstance()
        val endHour = (calendar.get(Calendar.HOUR_OF_DAY) + 1) % 24
        val endMinute = calendar.get(Calendar.MINUTE)
        Time(endHour, endMinute)
    }
}

fun showTimePickerDialog(context: Context, onTimeSelected: (start: Time, end: Time) -> Unit) {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val timePickerDialog = TimePickerDialog(
        context,
        { _, startHour, startMinute ->
            val startTime = Time(startHour, startMinute)
            val endTime = Time(startHour + 1, startMinute)
            onTimeSelected(startTime, endTime)
        },
        hour,
        minute,
        false
    )

    timePickerDialog.show()
}

data class Time(val hour: Int, val minute: Int)

fun formatDate(date: Date): String {
    val calendar = Calendar.getInstance()
    calendar.time = date
    return "${calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())} ${
        calendar.get(
            Calendar.DAY_OF_MONTH
        )
    }"
}

fun showDatePickerDialog(context: Context, onDateSelected: (Date) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val minDate = calendar.timeInMillis

    calendar.add(Calendar.DAY_OF_MONTH, 5)
    val maxDate = calendar.timeInMillis

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = Calendar.getInstance().apply {
                set(selectedYear, selectedMonth, selectedDay)
            }.time
            onDateSelected(selectedDate)
        },
        year,
        month,
        day
    )

    datePickerDialog.datePicker.minDate = minDate
    datePickerDialog.datePicker.maxDate = maxDate

    datePickerDialog.show()
}
