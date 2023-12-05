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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?, ): View {
        val binding = DataBindingUtil
            .inflate<FragmentUserEditingBinding>(inflater, R.layout.fragment_user_editing, container, false)
        binding.btnSave.setOnClickListener {
            arguments?.let {
                val position = it.getInt("position")
                var name = ""
                var surname = ""
                var phoneNumber = ""
                var photo = 0
                if (binding.textNameUser.text.isNotEmpty())
                    name = binding.textNameUser.text.toString()
                if (binding.textSurnameUser.text.isNotEmpty())
                    surname = binding.textSurnameUser.text.toString()
                if (binding.textPhoneUser.text.isNotEmpty())
                    phoneNumber = binding.textPhoneUser.text.toString()
                if (binding.textPhotoUser.text.isNotEmpty())
                    photo = binding.textPhotoUser.text.toString().toInt()
                setFragmentResult(
                    "user", bundleOf(
                        "position" to position, "name" to name, "surname" to surname,
                        "phoneNumber" to phoneNumber, "photo" to photo
                    )
                )
                parentFragmentManager.popBackStack()
            }
        }
        binding.btnCancel.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }
}