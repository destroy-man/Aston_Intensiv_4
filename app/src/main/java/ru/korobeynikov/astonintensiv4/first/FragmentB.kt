package ru.korobeynikov.astonintensiv4.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.FragmentBBinding

class FragmentB : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        val binding=DataBindingUtil.inflate<FragmentBBinding>(inflater,R.layout.fragment_b,container,false)
        binding.view=this
        return binding.root
    }

    fun goToBack(){
        parentFragmentManager.popBackStack()
    }

    fun goToFragmentC(){
        val bundle=Bundle()
        bundle.putString("hello","Hello Fragment C")
        val fragC=FragmentC()
        fragC.arguments=bundle
        val fTrans=parentFragmentManager.beginTransaction()
        fTrans.replace(R.id.fragContainer,fragC)
        fTrans.addToBackStack("B")
        fTrans.commit()
    }
}