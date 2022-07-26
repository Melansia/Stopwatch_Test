package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var seconds = 0
    private var isRunning = false
    private lateinit var tvTimer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTimer = findViewById(R.id.tvTimer)

    }

    fun onClickStartTimer(view: View) {
        isRunning = true
    }
    fun onClickPauseTimer(view: View) {
        isRunning = false
    }
    fun onClickResetTimer(view: View) {
        isRunning = false
        seconds = 0
    }

    fun runTimer() {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val second = seconds

        val time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, second)

        tvTimer.text = time

        if (isRunning) seconds++

    }
}