package hwsein.developer.example.taskapplication.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DBHandler.TABLE_NAME)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0 ,
    @ColumnInfo val date : String ,
    @ColumnInfo val title : String ,
    @ColumnInfo val state : Boolean
)
