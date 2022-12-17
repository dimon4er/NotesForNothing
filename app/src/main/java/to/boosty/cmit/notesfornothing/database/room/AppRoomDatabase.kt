package to.boosty.cmit.notesfornothing.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import to.boosty.cmit.notesfornothing.database.room.dao.NoteRoomDao
import to.boosty.cmit.notesfornothing.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun getRoomDao(): NoteRoomDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return if (INSTANCE == null) {
                Room.databaseBuilder(context, AppRoomDatabase::class.java, "notes_database"). build()
                INSTANCE as AppRoomDatabase
            } else INSTANCE as AppRoomDatabase
        }
    }
}