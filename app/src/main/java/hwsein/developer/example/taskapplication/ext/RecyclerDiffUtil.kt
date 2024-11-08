package hwsein.developer.example.taskapplication.ext

import androidx.recyclerview.widget.DiffUtil
import hwsein.developer.example.taskapplication.DataBase.TaskEntity

class RecyclerDiffUtil(
    private val oldList : ArrayList<TaskEntity> ,
    private val newList : ArrayList<TaskEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int):Boolean {
        if (oldItemPosition >= oldList.size || newItemPosition >= newList.size)
            return false

        return oldList[oldItemPosition].id == newList[newItemPosition].id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList == newList

}