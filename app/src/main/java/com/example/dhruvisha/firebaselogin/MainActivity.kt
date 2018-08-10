package com.example.dhruvisha.firebaselogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fbAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logout.setOnClickListener { view ->
            Toast.makeText(this, " Logout!", Toast.LENGTH_SHORT).show()
            signOut()
        }
        fbAuth.addAuthStateListener {
            if (fbAuth.currentUser == null) {
                this.finish()
            }
        }
    }
    fun updatePhone(){

    }
    fun signOut() {
        fbAuth.signOut()

    }
}
