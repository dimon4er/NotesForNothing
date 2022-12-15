package to.boosty.cmit.notesfornothing.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import to.boosty.cmit.notesfornothing.navigation.NavRoute
import to.boosty.cmit.notesfornothing.ui.theme.NotesForNothingTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(route = NavRoute.AddScreen.route) }) {
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = "Добавить новую запись",
                    tint = Color.White)
            }
        }) {
        Column(modifier = Modifier.padding(vertical = 8.dp))
        {
            NoteItem(navController = navController, title = "Title 1", description = "Description")
            NoteItem(navController = navController, title = "Title 2", description = "Description")
            NoteItem(navController = navController, title = "Title 3", description = "Description")
            NoteItem(navController = navController, title = "Title 4", description = "Description")
        }
    }

}

@Composable
fun NoteItem(navController: NavHostController, title: String, description: String) {
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
            Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = description)
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