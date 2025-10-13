package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gvsu.cis357.finalproject.minipets.MiniPetsViewModel


@Composable
fun MainPage(modifier: Modifier, viewModel: MiniPetsViewModel, onBack:()-> Unit) {
    Text(modifier = Modifier.fillMaxSize(), text = "Main Page")
}