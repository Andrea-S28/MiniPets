package gvsu.cis357.finalproject.minipets

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp



class MiniPetsViewModel(): ViewModel(){
    val BackgroundColor = Color(0xff208d6d)
    val MainColor = Color(0xff2ec99c)
    val TitleSize = 50.sp
    val HeaderSize = 30.sp
    val BodySize = 20.sp


    //MAIN PAGE LOGIC
    var happiness by mutableStateOf(75)
    var energy by mutableStateOf(50)
    var points by mutableStateOf(120)
    private val _catPosition = MutableStateFlow(CatPosition(0.dp, 0.dp))
    val catPosition: StateFlow<CatPosition> = _catPosition
    private val _catState = MutableStateFlow(CatState.Idle)
    val catState: StateFlow<CatState> = _catState
    //private var _isBed = false
    var isBed by mutableStateOf(false)
    var isCouch by mutableStateOf(false)
    var isDesk by mutableStateOf(false)
    var isTv by mutableStateOf(false)
    var isMirror by mutableStateOf(false)
    var isLamp by mutableStateOf(false)
    var isArt by mutableStateOf(false)

    var message by mutableStateOf("")

//    val floorArea = listOf(
//        //WalkableArea(topLeft = 23.616816.dp, bottomLeft = 191.98996.dp, topRight = )
//    )

    init {
        wandering()
    }

    fun wandering(){
        val minX = 0.dp
        val maxX = 100.dp
        val minY = 0.dp
        val maxY = 100.dp
        viewModelScope.launch {
            while(true){
                delay(5000)
                val newX = Random.nextInt(minX.value.toInt(), maxX.value.toInt()).dp
                val newY = Random.nextInt(minY.value.toInt(), maxY.value.toInt()).dp

                _catPosition.value = CatPosition(newX, newY)
            }
        }
    }

    fun walk(){
        happiness = (happiness +10).coerceAtMost(100)
        energy = (energy - 5).coerceAtLeast(0)
        points += 5
        coins.value += 15
        message = "Lets go for a walk...+15 coins"
        viewModelScope.launch {
            delay(1300L)
            message = ""
        }
    }

    fun nap() {
        coins.value += 2
        message = "Zzz...+5 coins"
        viewModelScope.launch {
            delay(1300L)
            message = ""
        }
    }

    fun play() {
        happiness = (happiness + 5).coerceAtMost(100)
        energy = (energy - 5).coerceAtLeast(0)
        points += 5
        coins.value += 10
        message = "Play Time \uD83E\uDD2A...+10 coins"
        viewModelScope.launch {
            delay(1300L)
            message = ""
        }
    }

    // USER PROFILE LOGIC
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

    //STORE LOGIC
    val petName = MutableStateFlow("Tui")
    val coins = MutableStateFlow(100)
    val categories = listOf("Furniture", "Hats", "Pets")

    val pets = listOf<ShopItem>(
        ShopItem(0, "Pet", "\uD83D\uDC36", "Doggo", 100),
        ShopItem(1, "Pet", "\uD83D\uDC30", "Bunny", 100),
        ShopItem(2, "Pet", "\uD83D\uDC39", "Mouse", 100),
    )

    var furniture = listOf<ShopItem>(
        ShopItem(3, "Furniture", "\uD83D\uDECF\uFE0F", "Bed", 75),
        ShopItem(4, "Furniture", "\uD83D\uDECB\uFE0F", "Couch", 50),
        ShopItem(5, "Furniture", "\uD83E\uDE9E", "Mirror", 50),
        ShopItem(6, "Furniture", "\uD83D\uDCBB", "Desk", 25),
        ShopItem(7, "Furniture", "\uD83D\uDCFA", "TV", 25),
        ShopItem(8, "Furniture", "\uD83D\uDCA1", "Lamp", 25),
        ShopItem(9, "Furniture", "\uD83D\uDDBC\uFE0F", "Wall Art", 25),
        )

    val hats = listOf<ShopItem>(
        ShopItem(10, "Hat", "⛑\uFE0F", "Red Helmet", 25),
        ShopItem(11, "Hat", "\uD83C\uDF93", "Graduation Cap", 25),
        ShopItem(12, "Hat", "\uD83C\uDFA9", "Top Hat", 25),
        ShopItem(13, "Hat", "\uD83D\uDC52", "Sun Hat", 25),
        ShopItem(14, "Hat", "\uD83E\uDDE2", "Blue Cap", 25),

        )

    val selectedCategoryItems = MutableStateFlow(furniture)

    fun selectShopCategory(category: String) {
        when (category) {
            "Hats" -> selectedCategoryItems.update {hats}
            "Furniture" -> selectedCategoryItems.update {furniture}
            "Pets" -> selectedCategoryItems.update { pets }
        }
    }

    fun onStoreItemClick(item: ShopItem) {
        if (coins.value < item.price) return
        coins.value -= item.price

        when(item.id) {
            3 -> {
                isBed = true
                furniture = furniture.filter { it.id != 3 }
                selectedCategoryItems.update { furniture }
            }
            4 -> {
                isCouch = true
                furniture = furniture.filter { it.id != 4 }
                selectedCategoryItems.update { furniture }
            }
            5 -> {
                isMirror = true
                furniture = furniture.filter { it.id != 5 }
                selectedCategoryItems.update { furniture }
            }
            6 -> {
                isDesk = true
                furniture = furniture.filter { it.id != 6 }
                selectedCategoryItems.update { furniture }
            }
            7 -> {
                isLamp = true
                furniture = furniture.filter { it.id != 7 }
                selectedCategoryItems.update { furniture }
            }
            8 -> {
                isTv = true
                furniture = furniture.filter { it.id != 8 }
                selectedCategoryItems.update { furniture }
            }
            9 -> {
                isArt = true
                furniture = furniture.filter { it.id != 9 }
                selectedCategoryItems.update { furniture }
            }
        }
    }
}

data class ShopItem(
    val id: Int,
    val itemType: String,
    val name: String,
    val description: String,
    val price: Int
)
data class CatPosition(val x: Dp, val y: Dp)
enum class CatState {Idle, Sleeping}
data class WalkableArea(val topLeft: Dp, val bottomLeft: Dp, val topRight: Dp, val bottomRight: Dp)
