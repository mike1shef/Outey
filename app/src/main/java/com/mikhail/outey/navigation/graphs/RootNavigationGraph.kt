package com.mikhail.outey.navigation.graphs
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.mikhail.outey.presentation.homeScreen.HomeScreen
//import com.mikhail.outey.presentation.linksScreen.LinksScreen
//
//@Composable
//fun RootNavigationGraph (navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        route = Graph.ROOT,
//        startDestination = Graph.HOME,
//        ) {
//
//        composable(route = Graph.HOME){
//            HomeScreen()
//        }
//    }
//
//
//
//}
//
//object Graph {
//    const val ROOT = "root_graph"
//    const val AUTHENTICATION = "auth_graph"
//    const val HOME = "home_graph"
//}