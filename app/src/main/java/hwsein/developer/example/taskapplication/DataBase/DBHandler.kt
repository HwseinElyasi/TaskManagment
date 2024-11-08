package hwsein.developer.example.taskapplication.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class],
    version = DBHandler.DATABASE_VERSION
)
abstract class DBHandler : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        private const val DATABASE_NAME = "Task.db"
        const val DATABASE_VERSION = 1

        const val TABLE_NAME = "Task"


        private var INSTANCE: DBHandler? = null

        fun getData(context: Context): DBHandler {

            if (INSTANCE == null)
                INSTANCE = Room.databaseBuilder(
                    context,
                    DBHandler::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigrationFrom()
                    .build()

            return INSTANCE!!
        }

    }


}