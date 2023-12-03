package ru.korobeynikov.astonintensiv4.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.FragmentUserEditingBinding

class FragmentUserEditing : Fragment() {

    lateinit var binding: FragmentUserEditingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_user_editing,container,false)
        binding.view=this
        return binding.root
    }

    fun save(){
        arguments?.let {
            val position=it.getInt("position")
            val listUsers=(parentFragment as FragmentListUsers).adapter.dataSet
            val user=listUsers[position]
            if(binding.textNameUser.text.isNotEmpty())
                user.name=binding.textNameUser.text.toString()
            if(binding.textSurnameUser.text.isNotEmpty())
                user.surname=binding.textSurnameUser.text.toString()
            if(binding.textPhoneUser.text.isNotEmpty())
                user.phoneNumber=binding.textPhoneUser.text.toString()
            if(binding.textPhotoUser.text.isNotEmpty())
                user.photo=binding.textPhotoUser.text.toString().toInt()
            listUsers[position]=user
            //setFragmentResult("users", bundleOf("listUsers" to newListUsers))
        }
    }

    fun cancel(){
        parentFragmentManager.popBackStack()
    }
}