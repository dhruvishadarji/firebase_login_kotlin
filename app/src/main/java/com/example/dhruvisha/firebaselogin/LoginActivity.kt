package com.example.dhruvisha.firebaselogin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login?.setOnClickListener { view -> loginUsingFirebase() }
    }

    fun loginUsingFirebase() {
        var sEmail = email.text.toString().trim();
        var sPassword = password.text.toString().trim()
        auth.createUserWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
            if (task.isSuccessful) {
                var intent = Intent(this, MultiFabActivity::class.java)
                intent.putExtra("id", auth.currentUser?.email)
                startActivity(intent)
            } else {
                Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
