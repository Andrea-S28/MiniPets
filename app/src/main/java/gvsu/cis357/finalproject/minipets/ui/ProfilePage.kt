package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gvsu.cis357.finalproject.minipets.MiniPetsViewModel


@Composable
fun ProfilePage(modifier: Modifier, viewModel: MiniPetsViewModel, onBack:()-> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(modifier = Modifier
            .width(150.dp)
            .height(70.dp),
            text = "Profile Page")
        Button(
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            onClick = { onBack() }) {
            Text("Back")
        }
    }
}