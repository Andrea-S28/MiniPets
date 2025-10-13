package gvsu.cis357.finalproject.minipets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gvsu.cis357.finalproject.minipets.ui.MainPage
import gvsu.cis357.finalproject.minipets.ui.theme.MiniPetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val myVM by viewModels<MiniPetsViewModel>()
        setContent {
            MiniPetsTheme {
                val nc = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = nc, startDestination = Route.MainPage) {
                        composable<Route.MainPage> {
                            MainPage(
                                modifier = Modifier,
                                viewModel = myVM,
                                onBack = { nc.popBackStack() }
                            )
                        }
                        composable<Route.InfoPage> {
                            MainPage(
                                modifier = Modifier,
                                viewModel = myVM,
                                onBack = { nc.popBackStack() }
                            )
                        }
                        composable<Route.ProfilePage> {
                            MainPage(
                                modifier = Modifier,
                                viewModel = myVM,
                                onBack = { nc.popBackStack() }
                            )
                        }
                        composable<Route.StorePage> {
                            MainPage(
                                modifier = Modifier,
                                viewModel = myVM,
                                onBack = { nc.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
