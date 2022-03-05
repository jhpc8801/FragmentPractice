package com.example.fragmentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnA : Button = findViewById(R.id.btnA)
        val btnB : Button = findViewById(R.id.btnB)
        val btnAssign : Button = findViewById(R.id.btnAssign)
        val tvResult : TextView = findViewById(R.id.tvResult)

        val fragmentManager = supportFragmentManager

        btnA.setOnClickListener() {
            val fragmentA = AFragment()

            val fragmentTrans = fragmentManager.beginTransaction()
            fragmentTrans.replace(R.id.fragmentContainerView, fragmentA)
            fragmentTrans.addToBackStack(null)
            fragmentTrans.commit()

        }

        btnB.setOnClickListener() {
            val fragmentB = BFragment()

            val fragmentTrans = fragmentManager.beginTransaction()
            fragmentTrans.replace(R.id.fragmentContainerView, fragmentB)
            fragmentTrans.addToBackStack(null)
            fragmentTrans.commit()

        }

        btnAssign.setOnClickListener() {
            val fragmentA = fragmentManager.findFragmentById(R.id.fragmentContainerView) as AFragment

            fragmentA.requireView().findViewById<TextView>(R.id.tvMessage).text = "Hello"
        }
    }
}