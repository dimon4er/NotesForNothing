package to.boosty.cmit.notesfornothing.database.room.repository

import androidx.lifecycle.LiveData
import to.boosty.cmit.notesfornothing.database.DatabaseRepository
import to.boosty.cmit.notesfornothing.database.room.dao.NoteRoomDao
import to.boosty.cmit.notesfornothing.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao): DatabaseRepository {
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
    }
}