package to.boosty.cmit.notesfornothing.database

import androidx.lifecycle.LiveData
import to.boosty.cmit.notesfornothing.model.Note

interface DatabaseRepository {

    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess:() -> Unit)

    suspend fun update(note: Note, onSuccess:() -> Unit)

    suspend fun delete(note: Note, onSuccess:() -> Unit)

}