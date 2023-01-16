package app.codinguyy.roomexample.util

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.codinguyy.roomexample.data.Text
import app.codinguyy.roomexample.data.TextDao

@Database(entities = [Text::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun textDao(): TextDao

    companion object {
        val tempInstance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                return Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                ).build()
            }
        }
    }
}
