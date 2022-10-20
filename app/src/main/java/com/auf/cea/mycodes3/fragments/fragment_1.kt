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
import com.auf.cea.mycodes3.databinding.Fragment1Binding


class fragment_1 : Fragment(), View.OnClickListener {
    private lateinit var binding: Fragment1Binding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var fragmentOneInterface : FragmentOneInterface

    interface FragmentOneInterface{
        fun editUserName()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentOneInterface = context as FragmentOneInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  Fragment1Binding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveUser.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val userlength = binding.txtUserName.text.length
        binding.txtUserName.hint = "USERNAME"

        if(binding.txtUserName.text.isEmpty()){
            binding.txtUserName.error = "Required"
            return
        }
        else if(userlength<6){
            binding.txtUserName.error = "6 or more characters only"
            return


        } else {
            val editor = sharedPreferences.edit()
            editor.putString(USERNAME, binding.txtUserName.text.toString())
            editor.apply()
            fragmentOneInterface.editUserName()
        }
    }
}
