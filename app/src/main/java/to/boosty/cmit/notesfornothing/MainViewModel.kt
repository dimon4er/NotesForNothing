package to.boosty.cmit.notesfornothing

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import to.boosty.cmit.notesfornothing.model.Note
import to.boosty.cmit.notesfornothing.utils.TYPE_FIREBASE
import to.boosty.cmit.notesfornothing.utils.TYPE_ROOM

class MainViewModel(application: Application): AndroidViewModel(application) {

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    init {
        readTest.value = when(dbType.value) {
            TYPE_ROOM -> {
                listOf<Note>(Note(title = "Запись 1", description = "Описание для записи 1"))
                listOf<Note>(Note(title = "Запись 2", description = "Описание для записи 2"))
                listOf<Note>(Note(title = "Запись 3", description = "Описание для записи 3"))
                listOf<Note>(Note(title = "Запись 4", description = "Описание для записи 4"))
            }
            TYPE_FIREBASE -> listOf()
            else -> listOf()
        }
    }

    fun initDatabase(type: String) {
        dbType.value = type
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
    }
}

class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}