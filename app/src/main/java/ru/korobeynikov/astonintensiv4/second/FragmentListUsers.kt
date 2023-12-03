package ru.korobeynikov.astonintensiv4.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.FragmentListUsersBinding
import ru.korobeynikov.astonintensiv4.first.FragmentB

class FragmentListUsers : Fragment() {

    lateinit var adapter: UserAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        val binding=DataBindingUtil.inflate<FragmentListUsersBinding>(inflater,R.layout.fragment_list_users,container,false)
        val recyclerViewUsers = binding.recyclerViewUsers
        val listUsers = ArrayList<User>()

        listUsers.add(User(0, "Ivan", "Ivanov", "123-45-67",R.drawable.user1))
        listUsers.add(User(1, "Petr", "Petrov", "234-56-78",R.drawable.user2))
        listUsers.add(User(2, "Vasily", "Kozlov", "345-67-89",R.drawable.user3))
        listUsers.add(User(3, "Alexandr", "Stepanenko", "456-78-90",R.drawable.user4))

        adapter = UserAdapter(listUsers)
        recyclerViewUsers.layoutManager = LinearLayoutManager(activity)
        recyclerViewUsers.adapter = adapter

        activity?.let {
            recyclerViewUsers.addOnItemTouchListener(RecyclerTouchListener(it,object:RecyclerTouchListener.ClickListener{
                override fun onClick(view: View, position: Int) {
                    val bundle=Bundle()
                    bundle.putInt("position",position)
                    val fragmentUserEditing=FragmentUserEditing()
                    fragmentUserEditing.arguments=bundle
                    val fTrans=parentFragmentManager.beginTransaction()
                    fTrans.replace(R.id.fragContainer,fragmentUserEditing)
                    fTrans.addToBackStack(null)
                    fTrans.commit()
                }
            }))
        }

        setFragmentResultListener("users"){_, bundle ->

        }

        return binding.root
    }
}