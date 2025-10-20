package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gvsu.cis357.finalproject.minipets.MiniPetsViewModel
import androidx.compose.runtime.collectAsState


@Composable
fun StorePage(modifier: Modifier, viewModel: MiniPetsViewModel, onBack:()-> Unit) {
    val BackgroundColor = Color(0xff208d6d)
    val MainColor = Color(0xff2ec99c)
    val TitleSize = 50.sp
    val HeaderSize = 30.sp
    val BodySize = 20.sp


    val petName by remember { mutableStateOf(viewModel.petName) }
    val coins by remember { mutableStateOf(viewModel.coins) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(MainColor),
//            contentAlignment = Alignment.Center
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = TitleSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                text = "SHOP"
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
                text = "\uD83D\uDC31 ${petName.collectAsState().value}"
            )
            Text(
                fontSize = HeaderSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                text = "\uD83D\uDCB2 ${coins.collectAsState().value}"
            )
        }
        Button(
            modifier = Modifier
                .width(150.dp)
                .height(70.dp),
            onClick = { onBack() }) {
            Text("Back")
        }
    }
}