package ru.korobeynikov.astonintensiv4.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.FragmentABinding

class FragmentA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?, ): View {
        val binding =
            DataBindingUtil.inflate<FragmentABinding>(inflater, R.layout.fragment_a, container, false)
        binding.btnGoToB.setOnClickListener {
            val fTrans = parentFragmentManager.beginTransaction()
            fTrans.replace(R.id.fragContainer, FragmentB())
            fTrans.addToBackStack("A")
            fTrans.commit()
        }
        return binding.root
    }
}