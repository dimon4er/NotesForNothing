package to.boosty.cmit.notesfornothing.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import to.boosty.cmit.notesfornothing.screens.AddScreen
import to.boosty.cmit.notesfornothing.screens.MainScreen
import to.boosty.cmit.notesfornothing.screens.NoteScreen
import to.boosty.cmit.notesfornothing.screens.StartScreen

sealed class NavRoute(val route: String) {
    object StartScreen: NavRoute("start_screen")
    object MainScreen: NavRoute("main_screen")
    object AddScreen: NavRoute("add_screen")
    object NoteScreen: NavRoute("note_screen")
}

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route) { StartScreen(navController = navController)}
        composable(NavRoute.MainScreen.route) { MainScreen(navController = navController) }
        composable(NavRoute.AddScreen.route) { AddScreen(navController = navController) }
        composable(NavRoute.NoteScreen.route) { NoteScreen(navController = navController) }
    }
}