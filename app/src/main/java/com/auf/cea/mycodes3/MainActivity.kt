package com.auf.cea.mycodes3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auf.cea.mycodes3.databinding.ActivityMainBinding
import com.auf.cea.mycodes3.fragments.fragment_1
import com.auf.cea.mycodes3.fragments.fragment_2

class MainActivity : AppCompatActivity(), fragment_1.FragmentOneInterface {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragmentTop.id, fragment_1())
        fragmentManager.commit()}

    override fun editUserName() {
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragmentBottom.id, fragment_2())
        fragmentManager.commit() }
    }