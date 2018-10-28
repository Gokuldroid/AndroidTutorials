package me.tuple.androidtutorials.logger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import me.tuple.androidtutorials.R
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    val TAG = "Demo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val items = arrayOf("Native", "Timber")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items)
        logger_options.adapter = adapter

        log.setOnClickListener {
            sampleLogTimber()
            TestClass.getName()
        }
    }


    private fun sampleLog() {
        Log.d(TAG, "Hello log")
    }

    private fun sampleLogTimber(){
        Timber.d("Hello world from %s", "Gokul")
    }
}
