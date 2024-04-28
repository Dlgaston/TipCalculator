package com.example.tipcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.temporal.TemporalAmount
private const val TAG = "MainActivity"
private const val INIT_TIP = 0;
class MainActivity : AppCompatActivity() {
    private lateinit var baseCost: EditText
    private lateinit var tipPercentage: SeekBar
    private lateinit var percentVal: TextView
    private lateinit var tipAmount: TextView
    private lateinit var totalAmount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //Sets the variables to the components within the app
            baseCost = findViewById(R.id.baseCost)
            tipPercentage = findViewById(R.id.tipPercentage)
            percentVal = findViewById(R.id.percentVal)
            tipAmount = findViewById(R.id.tipAmount)
            totalAmount = findViewById(R.id.totalAmount)

            percentVal.text = "$INIT_TIP%"
            //Creates listener events for changes on app.
            //Implementing override methods for tracking.
            tipPercentage.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    //Log takes 2 params, string and string, second will be our log statement.
                    // .i represents info level logs.
                    //This Log tracks the SeekBars percentage progress as it is changed.
                    Log.i(TAG, "onProgressChanged $progress")
                    percentVal.text = "$progress%"
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }

            })
            insets

        }

    }
}