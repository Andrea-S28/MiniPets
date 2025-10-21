package gvsu.cis357.finalproject.minipets

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MiniPetsViewModel(): ViewModel(){


    //MAIN PAGE LOGIC
    var happiness by mutableStateOf(75)
    var energy by mutableStateOf(50)
    var points by mutableStateOf(120)

    fun walk(){
        happiness = (happiness +10).coerceAtMost(100)
        energy = (energy - 5).coerceAtLeast(0)
        points += 5
    }

    fun screenBreak() {
        energy = (energy + 10).coerceAtMost(100)
        points += 5
    }

    fun play() {
        happiness = (happiness + 5).coerceAtMost(100)
        energy = (energy - 5).coerceAtLeast(0)
        points += 5
    }

    //STORE LOGIC
    val petName = MutableStateFlow("Tui")
    val coins = MutableStateFlow(100)

}