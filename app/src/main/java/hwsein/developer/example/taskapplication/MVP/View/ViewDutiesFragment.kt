package hwsein.developer.example.taskapplication.MVP.View

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Editable
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hwsein.developer.example.taskapplication.Adapter.RecyclerDutiesAdapter
import hwsein.developer.example.taskapplication.DataBase.DBHandler
import hwsein.developer.example.taskapplication.DataBase.TaskEntity
import hwsein.developer.example.taskapplication.databinding.DialogBoxBinding
import hwsein.developer.example.taskapplication.databinding.DutiesFragmentBinding
import hwsein.developer.example.taskapplication.ext.Utils
import ir.amozeshgam.persiandate.PersianDate

class ViewDutiesFragment(
    private val context: Context?
) {

    private var dialog = Dialog(context!!)
    val binding = DutiesFragmentBinding.inflate(LayoutInflater.from(context))
    private lateinit var adapter : RecyclerDutiesAdapter

    fun showDialog(utils : Utils , date : String){

        val view = DialogBoxBinding.inflate(LayoutInflater.from(context))


        binding.floatingActionButton2.setOnClickListener {

            view.edtTitle.text = null
            dialog.setContentView(view.root)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

        }

        view.btnAddTask.getVIew().setOnClickListener {

            val title = view.edtTitle.text.toString()

            if (title.isNotEmpty()){

                utils.insertTask(TaskEntity(date = date , title = title , state = null))
                showToast("وظیفه شما با موفقیت ذخیره شد.")
                dialog.dismiss()

            }
            else
                showToast("عنوان نمیتواند خالی باشد!")

        }

        view.btnCancel.getVIew().setOnClickListener { dialog.dismiss() }

        view.imgClose.setOnClickListener { dialog.dismiss() }


    }

    fun initRecycler(data : ArrayList<TaskEntity> , utils: Utils){

        binding.recycler.layoutManager = LinearLayoutManager(
            context ,
            RecyclerView.VERTICAL ,
            false
        )

        adapter = RecyclerDutiesAdapter(data , utils)

        binding.recycler.adapter = adapter

    }

    fun showDuties(duties : List<TaskEntity>){

        val data = ArrayList<TaskEntity>()

        duties.forEach { data.add(it) }

        adapter.updateRecycler(data)

    }

    private fun showToast(text : String){

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

    }
}
