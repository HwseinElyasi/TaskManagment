package hwsein.developer.example.taskapplication.MVP.View

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hwsein.developer.example.taskapplication.Adapter.RecyclerTaskAdapter
import hwsein.developer.example.taskapplication.DataBase.TaskEntity
import hwsein.developer.example.taskapplication.databinding.DialogBoxBinding
import hwsein.developer.example.taskapplication.databinding.HomeFragmentBinding
import hwsein.developer.example.taskapplication.ext.Utils

class ViewHomeFragment(
    private val contextInstance: Context?,
)  {

    val binding = HomeFragmentBinding.inflate(LayoutInflater.from(contextInstance))

    private var dialog = Dialog(contextInstance!!)
    private lateinit var adapter: RecyclerTaskAdapter
    val view = DialogBoxBinding.inflate(LayoutInflater.from(contextInstance))



    fun initRecycler(data: ArrayList<TaskEntity>, utils: Utils) {

        binding.recyclerView.layoutManager = LinearLayoutManager(
            contextInstance,
            RecyclerView.VERTICAL,
            false
        )


        adapter = RecyclerTaskAdapter(data, utils, contextInstance!!)

        binding.recyclerView.adapter = adapter


    }

    fun showTask(task: List<TaskEntity>) {

        val data = ArrayList<TaskEntity>()
        task.forEach {
            data.add(it)
        }

        adapter.updateRecycler(data)
    }

    fun getTaskByState(utils: Utils) {

        utils.requestData(false)

        binding.txtNoDone.setOnClickListener {

            binding.textTitle2.text = "کارهای انجام نشده"
            binding.txtNoDone.setTextColor(Color.WHITE)
            binding.txtDone.setTextColor(Color.parseColor("#A8A8A8"))
            binding.viewBottomNoDoneTask.visibility = View.VISIBLE
            binding.viewBottomDoneTask.visibility = View.INVISIBLE

            utils.requestData(false)

        }

        binding.txtDone.setOnClickListener {

            binding.textTitle2.text = "کارهای انجام شده"
            binding.txtDone.setTextColor(Color.WHITE)
            binding.txtNoDone.setTextColor(Color.parseColor("#A8A8A8"))
            binding.viewBottomDoneTask.visibility = View.VISIBLE
            binding.viewBottomNoDoneTask.visibility = View.INVISIBLE

            utils.requestData(true)

        }

    }

    fun addTask(task: Utils, date: String) {


        binding.floatingActionButton.setOnClickListener {

            if (view.edtTitle.text != null)
                view.edtTitle.text = Editable.Factory().newEditable("")

            dialogBox()

        }

        view.btnCancel.getVIew().setOnClickListener {

            dialog.dismiss()

        }

        view.imgClose.setOnClickListener {

            dialog.dismiss()

        }


        view.btnAddTask.getVIew().setOnClickListener {

            try {

                val title = view.edtTitle.text.toString()

                if (title.isNotEmpty()) {

                    task.insertTask(TaskEntity(date = date, title = title, state = false))
                    showToast("وظیفه شما با موفقیت ذخیره شد.")
                    dialog.dismiss()
                    view.edtTitle.text = Editable.Factory().newEditable(null)

                    task.requestData(false)


                } else {

                    showToast("عنوان نمیتواند خالی باشد")

                }
            } catch (e: Exception) {
                Log.i("ERROR", e.message.toString())
            }

        }

    }

    private fun dialogBox() {

        dialog.setContentView(view.root)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

    }


    private fun showToast(text: String) =
        Toast.makeText(contextInstance, text, Toast.LENGTH_SHORT).show()


}