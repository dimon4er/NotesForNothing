package to.boosty.cmit.notesfornothing.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import to.boosty.cmit.notesfornothing.MainViewModel
import to.boosty.cmit.notesfornothing.MainViewModelFactory
import to.boosty.cmit.notesfornothing.model.Note
import to.boosty.cmit.notesfornothing.navigation.NavRoute
import to.boosty.cmit.notesfornothing.ui.theme.NotesForNothingTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))


    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(route = NavRoute.AddScreen.route) }) {
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = "Добавить новую запись",
                    tint = Color.White)
            }
        }) {
//        Column(modifier = Modifier.padding(vertical = 8.dp))
//        {
//            NoteItem(navController = navController, title = "Title 1", description = "Description")
//            NoteItem(navController = navController, title = "Title 2", description = "Description")
//            NoteItem(navController = navController, title = "Title 3", description = "Description")
//            NoteItem(navController = navController, title = "Title 4", description = "Description")
//        }
//        LazyColumn{
//            items(notes) {
//                note -> NoteItem(navController = navController, note = note)
//            }
//        }
    }

}

@Composable
fun NoteItem(navController: NavHostController, note: Note) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable {
                navController.navigate(route = NavRoute.NoteScreen.route)
            },
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = note.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = note.description)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun prevMainScreen() {
    NotesForNothingTheme {
        MainScreen(rememberNavController())
    }
}