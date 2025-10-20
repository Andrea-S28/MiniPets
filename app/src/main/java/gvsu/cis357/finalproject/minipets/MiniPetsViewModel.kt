package gvsu.cis357.finalproject.minipets

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MiniPetsViewModel(): ViewModel(){
    // View Model Info for Store: Might split of later
    val petName = MutableStateFlow("Tui")
    val coins = MutableStateFlow(100)
}