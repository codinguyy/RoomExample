package app.codinguyy.roomexample.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TextDao {
    @Insert
    fun addText(text: Text)
}
