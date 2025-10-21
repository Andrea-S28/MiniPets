package gvsu.cis357.finalproject.minipets

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

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

    val pets = listOf<ShopItem>(
        ShopItem(0, "Pet", "\uD83D\uDC36", "Doggo", "100"),
        ShopItem(1, "Pet", "\uD83D\uDC30", "Bunny", "100"),
        ShopItem(2, "Pet", "\uD83D\uDC39", "Mouse", "100"),
    )

    val furniture = listOf<ShopItem>(
        ShopItem(3, "Furniture", "\uD83D\uDECF\uFE0F", "Bed", "75"),
        ShopItem(4, "Furniture", "\uD83D\uDECB\uFE0F", "Couch", "50"),
        ShopItem(5, "Furniture", "\uD83E\uDE9E", "Mirror", "50"),
        ShopItem(6, "Furniture", "\uD83E\uDE91", "Chair", "25"),
        )

    val hats = listOf<ShopItem>(
        ShopItem(7, "Hat", "⛑\uFE0F", "Red Helmet", "25"),
        ShopItem(8, "Hat", "\uD83C\uDF93", "Graduation Cap", "25"),
        ShopItem(9, "Hat", "\uD83C\uDFA9", "Top Hat", "25"),
        ShopItem(10, "Hat", "\uD83D\uDC52", "Sun Hat", "25"),
        ShopItem(11, "Hat", "\uD83E\uDDE2", "Blue Cap", "25"),

        )

    val selectedCategoryItems = MutableStateFlow(furniture)


    fun selectShopCategory(category: String) {
        when (category) {
            "Hats" -> selectedCategoryItems.update {hats}
            "Furniture" -> selectedCategoryItems.update {furniture}
            "Pets" -> selectedCategoryItems.update { pets }
        }
    }
}


data class ShopItem(
    val id: Int,
    val itemType: String,
    val name: String,
    val description: String,
    val price: String
)