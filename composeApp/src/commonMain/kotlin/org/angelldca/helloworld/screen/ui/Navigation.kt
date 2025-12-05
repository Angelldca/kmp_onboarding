@file:Suppress("EQUALITY_NOT_APPLICABLE_WARNING")

package org.angelldca.helloworld.screen.ui

import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.savedstate.read
import org.angelldca.helloworld.data.remote.movies
import org.angelldca.helloworld.screen.ui.dashboard.Dashboard
import org.angelldca.helloworld.screen.ui.detail.DetailScren
import org.angelldca.helloworld.screen.ui.home.HomeScren


@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "home",) {
       composable("home") {
           HomeScren(onMovieClick = { movie ->
              // navController.navigate("detail/${movie.id}")
               navController.navigate("dashboard")
           })
       }
        composable("dashboard") {
            Dashboard(
                back = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route= "detail/{movieId}",
            arguments = listOf(navArgument("movieId"){type = NavType.IntType})
            ) { backStackEntry ->
            val moviId = backStackEntry.arguments?.read{ getInt("movieId")}
            if (moviId != null){
                DetailScren(
                    movie = movies.first { it.id == moviId},
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

        }
    }
}