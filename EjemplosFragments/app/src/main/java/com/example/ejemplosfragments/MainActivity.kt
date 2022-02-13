package com.example.ejemplosfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MyFragment()
        replaceFragment(fragment)

    }

    private fun replaceFragment(fragment: MyFragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.lyFragment, fragment)
        fragmentTransaction.commit()
    }
}