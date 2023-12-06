package ru.korobeynikov.astonintensiv4.second.user

import androidx.recyclerview.widget.DiffUtil

class UserDiffUtilCallback(private val oldList: List<User>,
                           private val newList: List<User>, ) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}