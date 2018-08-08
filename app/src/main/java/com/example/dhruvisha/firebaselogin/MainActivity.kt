package com.example.dhruvisha.firebaselogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    var fbAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnLogOut = findViewById<Button>(R.id.logout)
        btnLogOut.setOnClickListener { view ->
            Toast.makeText(this, " Logout!", Toast.LENGTH_SHORT).show()
            signOut()
        }
        fbAuth.addAuthStateListener {
            if (fbAuth.currentUser == null) {
                this.finish()
            }
        }
    }

    fun signOut() {
        fbAuth.signOut()

    }
}
