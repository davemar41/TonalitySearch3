package com.example.tonalitysearch2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tonalitysearch2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //tres botones para cada actividad
        bind.boton1.setOnClickListener {
            val intent= Intent(this, Calculador::class.java)
            startActivity(intent)
        }
        bind.boton3.setOnClickListener {
            val intent2= Intent(this, Basedatos::class.java)
            startActivity(intent2)
        }
        bind.boton2.setOnClickListener {
            val intent3= Intent(this, Metronomo::class.java)
            startActivity(intent3)
        }
        bind.button.setOnClickListener {
            finish()
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }


    }
}