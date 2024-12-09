package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //This number is Hardcoded
        val hardcodedNumber = 7


        val numberInput = findViewById<EditText>(R.id.number)
        //Converting numberInput to string and then to Int
        val guessedNo=numberInput.text.toString().toInt()
        // Find the Button by its ID
        val submitButton: Button = findViewById(R.id.submitButton)


        // Set a click listener for the button

        submitButton.setOnClickListener {
            if (guessedNo == null || guessedNo <1 || guessedNo >10) {
                Toast.makeText(this, "Please Enter a number between 1-10", Toast.LENGTH_SHORT).show()
            }
            else if (guessedNo != hardcodedNumber) {
                AlertDialog.Builder(this)
                    .setTitle("Wrong Message")
                    .setMessage("Wrong Message. Try again!")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss() // Close the dialog
                    }
                    .show()
                    }

            else {
                    val submitButton = findViewById<Button>(R.id.submitButton)
                    submitButton.setOnClickListener {
                        val intent = Intent(this, Secondpage::class.java)
                        startActivity(intent)
                    }

                }
            }
    }
}
