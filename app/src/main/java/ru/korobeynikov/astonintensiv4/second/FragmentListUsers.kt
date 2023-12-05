package ru.korobeynikov.astonintensiv4.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.FragmentListUsersBinding
import ru.korobeynikov.astonintensiv4.second.user.User
import ru.korobeynikov.astonintensiv4.second.user.UserAdapter
import ru.korobeynikov.astonintensiv4.second.user.UserDiffUtilCallback
import ru.korobeynikov.astonintensiv4.second.user.UserViewModel

class FragmentListUsers : Fragment() {

    private var listUsers = ArrayList<User>()
    private lateinit var userViewModel: UserViewModel

    init {
        listUsers.add(User(0, "Ivan", "Ivanov", "123-45-67", R.drawable.user1))
        listUsers.add(User(1, "Petr", "Petrov", "234-56-78", R.drawable.user2))
        listUsers.add(User(2, "Vasily", "Kozlov", "345-67-89", R.drawable.user3))
        listUsers.add(User(3, "Alexandr", "Stepanenko", "456-78-90",
            R.drawable.user4))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?, ): View {
        val binding = DataBindingUtil
            .inflate<FragmentListUsersBinding>(inflater, R.layout.fragment_list_users, container, false)

        val recyclerViewUsers = binding.recyclerViewUsers
        val adapter = UserAdapter(listUsers)
        recyclerViewUsers.layoutManager = LinearLayoutManager(activity)
        recyclerViewUsers.adapter = adapter

        activity?.let { activity ->
            userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
            userViewModel.liveData.observe(activity) {
                listUsers = it
                adapter.dataSet = listUsers
            }
            recyclerViewUsers.addOnItemTouchListener(RecyclerTouchListener(activity,
                object : RecyclerTouchListener.ClickListener {
                    override fun onClick(view: View, position: Int) {
                        val bundle = Bundle()
                        bundle.putInt("position", position)
                        val fragmentUserEditing = FragmentUserEditing()
                        fragmentUserEditing.arguments = bundle
                        val fTrans = parentFragmentManager.beginTransaction()
                        fTrans.replace(R.id.fragContainer, fragmentUserEditing)
                        fTrans.addToBackStack(null)
                        fTrans.commit()
                    }
                }))
        }

        setFragmentResultListener("user") { _, bundle ->
            val position = bundle.getInt("position")
            val name = bundle.getString("name")
            val surname = bundle.getString("surname")
            val phoneNumber = bundle.getString("phoneNumber")
            val photo = bundle.getInt("photo")
            val newListUsers = ArrayList<User>()
            for (user in listUsers)
                newListUsers.add(User(user.id, user.name, user.surname, user.phoneNumber, user.photo))
            val user = newListUsers[position]
            if (!name.isNullOrEmpty())
                user.name = name
            if (!surname.isNullOrEmpty())
                user.surname = surname
            if (!phoneNumber.isNullOrEmpty())
                user.phoneNumber = phoneNumber
            when (photo) {
                1 -> user.photo = R.drawable.user1
                2 -> user.photo = R.drawable.user2
                3 -> user.photo = R.drawable.user3
                4 -> user.photo = R.drawable.user4
            }
            newListUsers[position] = user
            val userDiffUtilCallback = UserDiffUtilCallback(adapter.dataSet, newListUsers)
            val userDiffResult = DiffUtil.calculateDiff(userDiffUtilCallback)
            adapter.dataSet = newListUsers
            userDiffResult.dispatchUpdatesTo(adapter)
            listUsers = newListUsers
        }

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        userViewModel.loadData(listUsers)
    }
}