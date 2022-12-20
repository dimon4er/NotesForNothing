package to.boosty.cmit.notesfornothing.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {
    Scaffold() {

        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var isButtonEnabled by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Добавление новой записи", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            OutlinedTextField(value = title,
                onValueChange = {
                    title = it
                    isButtonEnabled = title.isNotEmpty() && description.isNotEmpty()
                },
                label = { Text(text = "Введите заголовок") },
            isError = title.isEmpty())
            OutlinedTextField(value = description,
                onValueChange = {
                    description = it
                    isButtonEnabled = title.isNotEmpty() && description.isNotEmpty()
                },
                label = { Text(text = "Введите описание") },
                isError = description.isEmpty())
            Button(enabled = isButtonEnabled,
                onClick = {
                    viewModel.addNote(note = Note(title = title, description = description)) {
                        navController.navigate(route = NavRoute.MainScreen.route)
                    }
                }) {
                Text(text = "Добавить запись")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PrevAddScreen() {
    NotesForNothingTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        AddScreen(rememberNavController(), mViewModel)
    }
}