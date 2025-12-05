package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gvsu.cis357.finalproject.minipets.MiniPetsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoPage(modifier: Modifier, viewModel: MiniPetsViewModel, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "About MiniPets",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.Default.ArrowBack, 
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = viewModel.MainColor
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(viewModel.BackgroundColor)
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App Icon
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "MiniPets Logo",
                modifier = Modifier
                    .size(80.dp)
                    .padding(bottom = 16.dp),
                tint = Color.White
            )

            // App Name
            Text(
                text = "MiniPets",
                fontSize = viewModel.HeaderSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Version
            Text(
                text = "Version 1.0.0",
                fontSize = viewModel.BodySize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Mission Statement Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = viewModel.MainColor
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 8.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Our Mission",
                            fontSize = viewModel.BodySize,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Text(
                        text = "At MiniPets, we believe in the joy of nurturing and caring for digital companions. Our mission is to create a fun, engaging, and rewarding virtual pet experience that teaches responsibility while providing endless entertainment. Every moment spent caring for your pet brings you closer to unlocking new adventures and customizations!",
                        fontSize = viewModel.BodySize,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 26.sp,
                        color = Color.White
                    )
                }
            }

            // Coin Info Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = viewModel.MainColor
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 8.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Earning Coins",
                            fontSize = viewModel.BodySize,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    
                    Text(
                        text = "Taking care of your pocket pet will result in you gaining coins that you can spend on customizations like outfits, room decor, and more!",
                        fontSize = viewModel.BodySize,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 26.sp,
                        color = Color.White
                    )
                }
            }


            // Developer Info
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = viewModel.MainColor
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Developer",
                        fontSize = viewModel.BodySize,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Developed by GVSU CIS 357 Students",
                        fontSize = viewModel.BodySize,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "© 2025 MiniPets App",
                        fontSize = viewModel.BodySize,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}
