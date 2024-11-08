package hwsein.developer.example.taskapplication.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    fun insertTask(vararg task : TaskEntity)

    @get:Query("SELECT * FROM ${DBHandler.TABLE_NAME}")
    val getTask : Flow<List<TaskEntity>>

    @Query("SELECT * FROM ${DBHandler.TABLE_NAME} WHERE state = :type")
    fun getTaskByState(type : Boolean) : Flow<List<TaskEntity>>


    @Update
    fun updateTask(vararg task : TaskEntity) : Int

    @Delete
    fun deleteTask(vararg task : TaskEntity) : Int

}