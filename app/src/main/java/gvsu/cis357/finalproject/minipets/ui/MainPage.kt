package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gvsu.cis357.finalproject.minipets.R
import gvsu.cis357.finalproject.minipets.MiniPetsViewModel
import org.intellij.lang.annotations.JdkConstants


@Composable
fun MainPage(modifier: Modifier,
             viewModel: MiniPetsViewModel,
             onInfo:()-> Unit,
             onProfile:()-> Unit,
             onStore:()-> Unit
) {
    val BackgroundColor = Color(0xff208d6d)
    val MainColor = Color(0xff2ec99c)
    val TitleSize = 50.sp
    val HeaderSize = 30.sp
    val BodySize = 20.sp
    val petName by remember { mutableStateOf(viewModel.petName) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(MainColor),
//              contentAlignment = Alignment.Center
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    fontSize = TitleSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    text = "MiniPets"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(MainColor),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    fontSize = HeaderSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    text = "\uD83D\uDC31 ${petName.collectAsState().value}")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = onInfo) { Text("Info") }
                Button(onClick = onProfile) { Text("Profile") }
                Button(onClick = onStore) { Text("Store") }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pixelpet),
                    contentDescription = "Beginner pixel",
                    modifier = Modifier.size(200.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Happiness: 75")
                Text("Energy: 50")
                Text("Points: 120")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {/* Walk */ }) {
                    Text("Walk")
                }
                Button(onClick = {/* Screen Break */ }) {
                    Text("Nap Time")
                }
                Button(onClick = {/* Play */ }) {
                    Text("Play")
                }

            }
            //        Text(
            //            modifier = Modifier
            //                .width(150.dp)
            //                .height(70.dp),
            //            text = "Main Page")
            //        Button(
            //            modifier = Modifier
            //                .width(150.dp)
            //                .height(70.dp),
            //            onClick = { onInfo() }) {
            //            Text("Info")
            //        }
            //        Button(
            //            modifier = Modifier
            //                .width(150.dp)
            //                .height(70.dp),
            //            onClick = { onProfile() }) {
            //            Text("Profile")
            //        }
            //        Button(
            //            modifier = Modifier
            //                .width(150.dp)
            //                .height(70.dp),
            //            onClick = { onStore() }) {
            //            Text("Store")
            //        }
        }
    }
}

//@Composable
//fun