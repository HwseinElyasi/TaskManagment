package hwsein.developer.example.taskapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import hwsein.developer.example.taskapplication.DataBase.TaskEntity
import hwsein.developer.example.taskapplication.databinding.ListItemBinding
import hwsein.developer.example.taskapplication.ext.RecyclerDiffUtil
import hwsein.developer.example.taskapplication.ext.Utils

class RecyclerTaskAdapter(
    private val allData: ArrayList<TaskEntity>,
    val utils: Utils,
    val context: Context,
) : RecyclerView.Adapter<RecyclerTaskAdapter.TaskViewHolder>() , Filterable {

    val task  = ArrayList<TaskEntity>()

    init {
        allData.addAll(task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = allData.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

        holder.setData(allData[position])

    }

    inner class TaskViewHolder(
        private val binding: ListItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(data: TaskEntity) {

            binding.textDate.text = data.date
            binding.textTitle.text = data.title
            binding.checkBox.isChecked = data.state == true

            binding.checkBox.setOnClickListener {

                if (data.state == true) {

                    utils.updateTask(TaskEntity(data.id, data.date, data.title, false))

                } else {

                    utils.updateTask(TaskEntity(data.id, data.date, data.title, true))

                }

            }

            binding.imgRecycleBin.setOnClickListener {

                utils.deleteTask(TaskEntity(data.id , data.date , data.title , data.state))

            }


        }

    }

    fun updateRecycler(newList: ArrayList<TaskEntity>) {

        val diffUtilCallBack = RecyclerDiffUtil(allData, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallBack)

        allData.clear()
        allData.addAll(newList)

        diffResult.dispatchUpdatesTo(this)

    }

    override fun getFilter() : android.widget.Filter = object : android.widget.Filter(){

        override fun performFiltering(constraint: CharSequence?): FilterResults {

            val filterList = ArrayList<TaskEntity>()

            if (constraint.isNullOrEmpty()){

                filterList.addAll(allData)

            }

            else {
                 val text = constraint.toString().trim()
                for (item in allData){

                    if (item.title.contains(text))
                        filterList.add(item)

                }


            }

            val result = FilterResults()
            result.values = filterList

            return result

        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

            task.clear()
            task.addAll(results?.values as ArrayList<TaskEntity>)
            notifyDataSetChanged()

        }


    }

}