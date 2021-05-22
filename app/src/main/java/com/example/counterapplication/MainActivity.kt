package com.example.counterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var counter : TextView
    lateinit var start : Button
    lateinit var stop : Button

    var timer = mycounter(500000,1000)
    var counter_value : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter = findViewById(R.id.counter_val)
        start = findViewById(R.id.btn_strt)
        stop = findViewById(R.id.btn_stp)

        stop.isEnabled = false

        start.setOnClickListener(){
            timer.start()
            start.isEnabled = false
            stop.isEnabled = true
        }

        stop.setOnClickListener(){
            timer.cancel()
            start.isEnabled = true
            stop.isEnabled = false
        }

    }

    inner class mycounter(x : Long, y : Long) : CountDownTimer(x,y){

        override fun onTick(millisUntilFinished: Long) {
            counter_value++
            counter.text = counter_value.toString()
        }

        override fun onFinish() {
            counter.text = "Done"
        }

    }
}