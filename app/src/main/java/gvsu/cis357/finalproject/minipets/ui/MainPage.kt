package gvsu.cis357.finalproject.minipets.ui

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gvsu.cis357.finalproject.minipets.R
import gvsu.cis357.finalproject.minipets.MiniPetsViewModel


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
    val scale = 27

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

            val density = LocalDensity.current
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red.copy(alpha = 0.2f))
                    .height(400.dp)
                    .pointerInput(Unit) {
//                        detectTapGestures { offset ->
//                            val xPx = offset.x   // already pixels
//                            val yPx = offset.y   // already pixels
//
//                            println("Tapped at xPx=$xPx, yPx=$yPx")
                        detectTapGestures { offset ->
                            // offset.x and offset.y are in pixels
                            val xDp = with(density) { offset.x.toDp() }
                            val yDp = with(density) { offset.y.toDp() }

                            println("Tapped at dp: x=$xDp, y=$yDp")

//                    .onGloballyPositioned { layout ->
//                        val widthDp = with(density) { layout.size.width.toDp() }
//                        val heightDp = with(density) { layout.size.height.toDp() }
//
//                        println("Width = $widthDp, Height = $heightDp")
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.room3),
                    contentDescription = "Base room",
                    modifier = Modifier
                        .fillMaxSize()
//                        .graphicsLayer(
//                            scaleX = 1.5f,
//                            scaleY = 1.5f
//                        )
                        .size((128 * scale).dp, (128 * scale).dp)
                        .offset(x = 0.dp, y = 0.dp)
                )
//                Couch()
//                Desk()
//                Tv()
//                Bed()
//                Mirror()
//                Lamp()
//                Art()

                if (viewModel.isBed) {
                    Bed()
                }
                if (viewModel.isCouch) {
                    Couch()
                }
                if (viewModel.isTv) {
                    Tv()
                }
                if (viewModel.isDesk) {
                    Desk()
                }
                if (viewModel.isMirror) {
                    Mirror()
                }
                if (viewModel.isLamp) {
                    Lamp()
                }
                if (viewModel.isArt) {
                    Art()
                }

                Cat(viewModel = viewModel)

            }
            Spacer(modifier = Modifier.height(20.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Text("Happiness: 75")
//                Text("Energy: 50")
//                Text("Coins: 120")
//            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {/* Walk */ }) {
                    Text("Walk")
                }
                Button(onClick = { /* nap */}) {
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

@Composable
fun Cat(viewModel: MiniPetsViewModel) {
    val position by viewModel.catPosition.collectAsState()
    val state by viewModel.catState.collectAsState()

    val catX by animateDpAsState(targetValue = position.x)
    val catY by animateDpAsState(targetValue = position.y)

    Image(
        painter = painterResource(id = R.drawable.cat4),
        contentDescription = "Pixel cat",
        modifier = Modifier
            .size(175.dp)
            .offset(x = catX, y = catY)
    )
}

@Composable
fun Bed() {
    val scale = 30
    Image(
        painter = painterResource(id = R.drawable.bed7),
        contentDescription = "Empty bed",
        modifier = Modifier
            .size((128 * scale).dp, (128 * scale).dp)
            .offset(x = (-23).dp, y = 24.dp)
    )
}

@Composable
fun Couch() {
    val scale = 30
    Image(
        painter = painterResource(id = R.drawable.couch),
        contentDescription = "Couch",
        modifier = Modifier
            .size((128 * scale).dp, (128 * scale).dp)
            .offset(x = 47.dp, y = 160.dp)
    )
}

@Composable
fun Tv() {
    val scale = 30
    Image(
        painter = painterResource(id = R.drawable.tv),
        contentDescription = "Couch",
        modifier = Modifier
            .size((128 * scale).dp, (128 * scale).dp)
            .offset(x = 57.dp, y = 185.dp)
    )
}

@Composable
fun Desk() {
    val scale = 30
    Image(
        painter = painterResource(id = R.drawable.desk2),
        contentDescription = "Desk",
        modifier = Modifier
            .size((128 * scale).dp, (128 * scale).dp)
            .offset(x = 93.dp, y = 69.dp)
    )
}
@Composable
fun Mirror() {
    val scale = 30
    Image(
        painter = painterResource(id = R.drawable.mirror),
        contentDescription = "Couch",
        modifier = Modifier
            .size((128 * scale).dp, (128 * scale).dp)
            .offset(x = (-81).dp, y = 13.dp)
    )
}

@Composable
fun Lamp() {
    val scale = 30
    Image(
        painter = painterResource(id = R.drawable.lamp),
        contentDescription = "Couch",
        modifier = Modifier
            .size((128 * scale).dp, (128 * scale).dp)
            .offset(x = 104.dp, y = 149.dp)
    )
}

@Composable
fun Art() {
    val scale = 30
    Image(
        painter = painterResource(id = R.drawable.art),
        contentDescription = "Couch",
        modifier = Modifier
            .size((128 * scale).dp, (128 * scale).dp)
            .offset(x = 93.dp, y = 12.dp)
    )
}