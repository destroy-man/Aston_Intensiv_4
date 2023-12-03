package ru.korobeynikov.astonintensiv4.second

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.korobeynikov.astonintensiv4.R

class UserAdapter(var dataSet: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textName: TextView
        private val textSurname: TextView
        private val textPhone: TextView
        private val photoUser: ImageView

        init {
            textName = view.findViewById(R.id.textNameUser)
            textSurname = view.findViewById(R.id.textSurnameUser)
            textPhone = view.findViewById(R.id.textPhoneUser)
            photoUser = view.findViewById(R.id.photoUser)
        }

        fun bind(user: User) {
            textName.text = user.name
            textSurname.text = user.surname
            textPhone.text = user.phoneNumber
            photoUser.setImageResource(user.photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}