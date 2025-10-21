package gvsu.cis357.finalproject.minipets

<<<<<<< HEAD
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
=======
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
>>>>>>> origin/main
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MiniPetsViewModel(): ViewModel(){
<<<<<<< HEAD
    
    // User profile data
    var userName by mutableStateOf("Pet Lover")
        private set
    
    var petDisplayName by mutableStateOf("Fluffarita")
        private set
    
    // Functions to update the data
    fun updateUserName(newName: String) {
        userName = newName
    }
    
    fun updatePetDisplayName(newName: String) {
        petDisplayName = newName
    }
}
=======
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
        ShopItem("Pet", "\uD83D\uDC36", "Doggo", "100"),
        ShopItem("Pet", "\uD83D\uDC30", "Bunny", "100"),
        ShopItem("Pet", "\uD83D\uDC39", "Mouse", "100"),
    )

    val furniture = listOf<ShopItem>(
        ShopItem("Furniture", "\uD83D\uDECF\uFE0F", "Bed", "75"),
        ShopItem("Furniture", "\uD83D\uDECB\uFE0F", "Couch", "50"),
        ShopItem("Furniture", "\uD83E\uDE9E", "Mirror", "50"),
        ShopItem("Furniture", "\uD83E\uDE91", "Chair", "25"),
        )

    val hats = listOf<ShopItem>(
        ShopItem("Hat", "⛑\uFE0F", "Red Helmet", "25"),
        ShopItem("Hat", "\uD83C\uDF93", "Graduation Cap", "25"),
        ShopItem("Hat", "\uD83C\uDFA9", "Top Hat", "25"),
        ShopItem("Hat", "\uD83D\uDC52", "Sun Hat", "25"),
        ShopItem("Hat", "\uD83E\uDDE2", "Blue Cap", "25"),

        )
}


data class ShopItem(
    val itemType: String,
    val name: String,
    val description: String,
    val price: String
)
>>>>>>> origin/main
