package gvsu.cis357.finalproject.minipets

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MiniPetsViewModel(): ViewModel(){
    val BackgroundColor = Color(0xff208d6d)
    val MainColor = Color(0xff2ec99c)
    val TitleSize = 50.sp
    val HeaderSize = 30.sp
    val BodySize = 20.sp

    // View Model Info for Store: Might split of later
    val petName = MutableStateFlow("Tui")
    val coins = MutableStateFlow(100)
    val categories = listOf("Furniture", "Hats", "Pets")
}


data class ShopItem(
    val itemType: String,
    val name: String,
    val description: String,
    val price: String
)