package to.boosty.cmit.notesfornothing.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import to.boosty.cmit.notesfornothing.navigation.NavRoute
import to.boosty.cmit.notesfornothing.ui.theme.NotesForNothingTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Какую базу будем использовать?")
            Button(modifier = Modifier
                .padding(vertical = 8.dp)
                .width(200.dp),
                onClick = {
                    navController.navigate(route = NavRoute.MainScreen.route)
                }) {
                    Text(text = "Room database")
            }
            Button(modifier = Modifier
                .padding(vertical = 8.dp)
                .width(200.dp),
                onClick = {
                    navController.navigate(route = NavRoute.MainScreen.route)
                }) {
                    Text(text = "Firebase database")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun prevStartScreen() {
    NotesForNothingTheme {
        StartScreen(rememberNavController())
    }
}