package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import org.intellij.lang.annotations.JdkConstants


@Composable
fun MainPage(modifier: Modifier,
             viewModel: MiniPetsViewModel,
             onInfo:()-> Unit,
             onProfile:()-> Unit,
             onStore:()-> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            text = "Main Page")
        Button(
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            onClick = { onInfo() }) {
            Text("Info")
        }
        Button(
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            onClick = { onProfile() }) {
            Text("Profile")
        }
        Button(
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            onClick = { onStore() }) {
            Text("Store")
        }
    }
}