package com.example.topplacesinindia

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var currentval=0
    lateinit var image : ImageView
    var array1= arrayOf("waterfalls","India Gate","Mountain")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var prevbtn = findViewById<ImageButton>(R.id.prevbtn)
        var frwdbtn = findViewById<ImageButton>(R.id.frwdbtn)
        var textval = findViewById<TextView>(R.id.textarea)
        prevbtn.setOnClickListener {
            var idCurrentImageString = "pic$currentval"
            var idCurrentImageId = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image= findViewById<ImageView>(idCurrentImageId)
            image.alpha=0f

            currentval = (3+currentval-1)%3
            var idCurrentImagetoshowString = "pic$currentval"
            var idCurrentImagetoshowId = this.resources.getIdentifier(idCurrentImagetoshowString,"id",packageName)
            image= findViewById<ImageView>(idCurrentImagetoshowId)
            image.alpha=1f
            textval.text = array1[currentval]
        }
        frwdbtn.setOnClickListener {
            var idCurrentImageString = "pic$currentval"
            var idCurrentImageId = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image= findViewById<ImageView>(idCurrentImageId)
            image.alpha=0f

            currentval = (3+currentval+1)%3
            var idCurrentImagetoshowString = "pic$currentval"
            var idCurrentImagetoshowId = this.resources.getIdentifier(idCurrentImagetoshowString,"id",packageName)
            image= findViewById<ImageView>(idCurrentImagetoshowId)
            image.alpha=1f
            textval.text = array1[currentval]
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}