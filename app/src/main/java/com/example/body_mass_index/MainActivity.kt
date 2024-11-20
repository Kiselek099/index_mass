package com.example.body_mass_index

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var hightET:EditText
    lateinit var weightET:EditText
    lateinit var nextBTN:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        hightET=findViewById(R.id.hightET)
        weightET=findViewById(R.id.weightET)
        nextBTN=findViewById(R.id.nextBTN)
        nextBTN.setOnClickListener{
            var hight=hightET.text.toString()
            var weight=weightET.text.toString()
            if (hight.isNotEmpty()&&weight.isNotEmpty()){
                var hei=hight.toDouble()/100
                var wei=weight.toDouble()
                val bmi=wei/(hei*hei)
                val intent=Intent(this,Activity2::class.java)
                intent.putExtra("BMI",bmi)
                startActivity(intent)
            }else Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
        }
    }

}

