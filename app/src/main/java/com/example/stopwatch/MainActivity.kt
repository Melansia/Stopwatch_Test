package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var tvTimer: TextView

    private var seconds = 0
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTimer = findViewById(R.id.tvTimer)

//        if (savedInstanceState != null) {
//            seconds = savedInstanceState.getInt("seconds")
//            isRunning = savedInstanceState.getBoolean("isRunning")
//            runTimer()
//        }
        runTimer()
    }

//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        outState.putInt("seconds", seconds)
//        outState.putBoolean("isRunning", isRunning)
//        super.onSaveInstanceState(outState, outPersistentState)
//    }

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

    private fun runTimer() {
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val second = seconds

                val time =
                    String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, second)
                tvTimer.text = time
                if (isRunning) seconds++

                handler.postDelayed(this, 1000)
            }
        })
    }
}