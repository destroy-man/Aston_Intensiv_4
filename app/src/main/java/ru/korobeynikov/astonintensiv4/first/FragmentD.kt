package ru.korobeynikov.astonintensiv4.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.FragmentDBinding

class FragmentD : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?, ): View {
        val binding =
            DataBindingUtil.inflate<FragmentDBinding>(inflater, R.layout.fragment_d, container, false)
        binding.btnGoToB.setOnClickListener {
            parentFragmentManager.popBackStack("B", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        return binding.root
    }
}