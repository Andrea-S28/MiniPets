package gvsu.cis357.finalproject.minipets

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MiniPetsViewModel(): ViewModel(){
    
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
