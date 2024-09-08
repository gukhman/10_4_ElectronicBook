package com.example.electronicbook

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var bookTextView: TextView
    private lateinit var loadButton: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bookTextView = findViewById(R.id.bookTextView)
        loadButton = findViewById(R.id.loadButton)

    }

    private fun loadBook(text: String): List<String> {
        return text.split("\\s+".toRegex())
    }

    fun onToggleClicked(view: View) {
        if (loadButton.isChecked) {
            val bookText = loadBook(text)
            bookTextView.text = bookText.joinToString(" ")
        } else {
            bookTextView.text = ""
        }
    }

}
