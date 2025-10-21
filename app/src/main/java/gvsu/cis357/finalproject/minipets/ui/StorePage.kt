package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import gvsu.cis357.finalproject.minipets.ShopItem

@Composable
fun StorePage(modifier: Modifier, viewModel: MiniPetsViewModel, onBack:()-> Unit) {
    val petName by remember { mutableStateOf(viewModel.petName) }
    val coins by remember { mutableStateOf(viewModel.coins) }

    val categories = viewModel.categories

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(viewModel.BackgroundColor)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(viewModel.MainColor),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = viewModel.TitleSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                text = "SHOP"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(viewModel.MainColor),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fontSize = viewModel.HeaderSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                text = "\uD83D\uDC31 ${petName.collectAsState().value}"
            )
            Text(
                fontSize = viewModel.HeaderSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                text = "\uD83D\uDCB2 ${coins.collectAsState().value}"
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
//                .background(MainColor),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(categories) { category ->
                CategoryCard(category, viewModel)
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.85f),
//            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(18) { category ->
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .background(viewModel.MainColor)
                        .clickable { /* Handle click */ },
                    contentAlignment = Alignment.Center
                ) {
                    Text("$category")
                }
            }
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

@Composable
fun CategoryCard(name: String, viewModel: MiniPetsViewModel) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .widthIn(min = 100.dp)
            .background(viewModel.MainColor)
            .clickable { /* Handle click */ },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            color = Color.White,
            fontSize = viewModel.HeaderSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ShopItemCard(item: ShopItem, viewModel: MiniPetsViewModel) {
    Box(
        modifier = Modifier
            .height(120.dp)
            .width(120.dp)
            .background(viewModel.MainColor)
            .clickable { /* Handle click */ },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item.name,
            color = Color.White,
            fontSize = viewModel.BodySize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
