package ru.korobeynikov.astonintensiv4.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.FragmentCBinding

class FragmentC : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        val binding=DataBindingUtil.inflate<FragmentCBinding>(inflater,R.layout.fragment_c,container,false)
        binding.view=this
        binding.textFromB.text=arguments?.getString("hello")
        return binding.root
    }

    fun goToFragmentA(){
        parentFragmentManager.popBackStack("A", FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun goToFragmentD(){
        val fTrans=parentFragmentManager.beginTransaction()
        fTrans.replace(R.id.fragContainer,FragmentD())
        fTrans.addToBackStack(null)
        fTrans.commit()
    }
}