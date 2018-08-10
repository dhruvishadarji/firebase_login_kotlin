package com.example.dhruvisha.firebaselogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.widget.Toast
import com.example.dhruvisha.firebaselogin.R.id.fab_logout
import com.google.firebase.auth.FirebaseAuth
import io.github.yavski.fabspeeddial.FabSpeedDial
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter
import kotlinx.android.synthetic.main.activity_multi_fab.*

class MultiFabActivity : AppCompatActivity() {
    var auth=FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_fab)
        switchFragment(AddDataFragment())
        auth.addAuthStateListener {
            if (auth.currentUser==null){
                this.finish()
            }
        }
        mini_fab.setMenuListener(object : SimpleMenuListenerAdapter() {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.fab_add ->
                        switchFragment(AddDataFragment())
                    R.id.fab_update ->
                        switchFragment(UpdateUserFragment())
                    R.id.fab_logout -> {
                        userLogout()
                    }
                    else -> {
                    }
                }
                return false
            }


        })

    }
    fun switchFragment(fragment: Fragment){
        var transation=supportFragmentManager.beginTransaction()
        transation .replace(R.id.frame,fragment)
        transation.commit()
    }
    fun userLogout(){
        Toast.makeText(this, " Logout!", Toast.LENGTH_SHORT).show()
        auth.signOut()
    }

}
