package hwsein.developer.example.taskapplication.ext

import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.DataBase.TaskEntity

interface Utils {

    fun setFragment(fragment : Fragment){}

    fun insertTask(data : TaskEntity) {}

    fun updateTask(task : TaskEntity){}

    fun updateTask2(task : TaskEntity){}

    fun requestData(state : Boolean){}

    fun deleteTask(task:TaskEntity){}

    fun getTask(tasks : List<TaskEntity>){}

    fun onSearchQueryChanged(query : String){}


}