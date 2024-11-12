package hwsein.developer.example.taskapplication.MVP.Model

import android.content.Context
import hwsein.developer.example.taskapplication.DataBase.DBHandler
import hwsein.developer.example.taskapplication.DataBase.TaskEntity
import hwsein.developer.example.taskapplication.ext.Utils
import ir.amozeshgam.persiandate.PersianDate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ModelHomeFragment(
    private val context: Context?
) {

    private val db = DBHandler.getData(context!!)

    fun getDate() : String{

        val persianDate = PersianDate()

        val clock = "${persianDate.hour}:${persianDate.min}"
        val date = "${persianDate.year}/${persianDate.month}/${persianDate.day}"

        return "$clock | $date"
    }
    
    fun insertUser(task : TaskEntity){

        CoroutineScope(Dispatchers.IO).launch {

            db.taskDao().insertTask(task)

            }

    }

    fun editTask(task : TaskEntity){

        CoroutineScope(Dispatchers.IO).launch{

            db.taskDao().updateTask(task)

        }

    }

    fun deleteTask(task: TaskEntity){

        CoroutineScope(Dispatchers.IO).launch {

            db.taskDao().deleteTask(task)

        }


    }

    fun getTaskInDataBase(state : Boolean , utils: Utils){

        CoroutineScope(Dispatchers.IO).launch {

          val data =  db.taskDao().getTaskByState(state)

            launch(Dispatchers.Main) {

              data.collect{

                  utils.getTask(it)

              }

            }

        }


    }

    fun getNullStateTaskInDataBase(utils: Utils){

        CoroutineScope(Dispatchers.IO).launch {

            val data = db.taskDao().getTaskWithNullState()

            launch(Dispatchers.Main) {

                data.collect{

                    utils.getNullStateTask(it)

                }

            }

        }


    }

    fun closeDataBase() = db.close()

}