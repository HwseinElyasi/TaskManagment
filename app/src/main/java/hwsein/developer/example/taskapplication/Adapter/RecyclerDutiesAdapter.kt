package hwsein.developer.example.taskapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import hwsein.developer.example.taskapplication.DataBase.TaskEntity
import hwsein.developer.example.taskapplication.databinding.ListItemDutiesBinding
import hwsein.developer.example.taskapplication.ext.RecyclerDiffUtil
import hwsein.developer.example.taskapplication.ext.Utils

class RecyclerDutiesAdapter(
    private val allDuties: ArrayList<TaskEntity> ,
    private val utils: Utils
) : RecyclerView.Adapter<RecyclerDutiesAdapter.DutiesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =

        DutiesViewHolder(
            ListItemDutiesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = allDuties.size

    override fun onBindViewHolder(holder: DutiesViewHolder, position: Int) {
        holder.setData(allDuties[position])
    }


    inner class DutiesViewHolder(
        private val binding: ListItemDutiesBinding
    ) : ViewHolder(binding.root) {


        fun setData(data: TaskEntity) {

            binding.textTitle.text = data.title
            binding.textDate.text = data.date

            binding.imgRecycleBin.setOnClickListener {

                utils.deleteTask(data)

            }


        }

    }

    fun updateRecycler(newList : ArrayList<TaskEntity>){

        val diffUtils = RecyclerDiffUtil(allDuties , newList)
        val diffResult = DiffUtil.calculateDiff(diffUtils)

        allDuties.clear()
        allDuties.addAll(newList)

        diffResult.dispatchUpdatesTo(this)

    }

}