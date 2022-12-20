package to.boosty.cmit.notesfornothing.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import to.boosty.cmit.notesfornothing.ui.theme.NotesForNothingTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NoteScreen(navController: NavHostController, viewModel: MainViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Card(modifier = Modifier
                .fillMaxSize()
                .padding(24.dp))
            {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text(text = "Title", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Description", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PrevNoteScreen() {
    NotesForNothingTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        NoteScreen(rememberNavController(), mViewModel)
    }
}