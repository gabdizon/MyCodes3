package com.auf.cea.mycodes3.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.auf.cea.mycodes3.MY_PREFERENCE
import com.auf.cea.mycodes3.R
import com.auf.cea.mycodes3.USERNAME
import com.auf.cea.mycodes3.databinding.Fragment2Binding


class fragment_2 : Fragment() {
    private lateinit var binding : Fragment2Binding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  Fragment2Binding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE)
        return binding.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtUsername.text = String.format("USERNAME: %s",sharedPreferences.getString(
            USERNAME,"")) }
}