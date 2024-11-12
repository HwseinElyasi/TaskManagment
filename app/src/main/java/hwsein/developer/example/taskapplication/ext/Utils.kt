package hwsein.developer.example.taskapplication.ext

import androidx.fragment.app.Fragment
import hwsein.developer.example.taskapplication.DataBase.TaskEntity

interface Utils {

    fun setFragment(fragment: Fragment) {}

    fun insertTask(data: TaskEntity) {}

    fun updateTask(task: TaskEntity) {}

    fun getNullStateTask(task: List<TaskEntity>) {}

    fun requestData(state: Boolean) {}

    fun deleteTask(task: TaskEntity) {}

    fun getTask(tasks: List<TaskEntity>) {}


}