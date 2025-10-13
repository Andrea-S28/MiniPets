package gvsu.cis357.finalproject.minipets
import kotlinx.serialization.Serializable


@Serializable
sealed class Route {
    @Serializable
    data object MainPage

    @Serializable
    data object InfoPage

    @Serializable
    data object ProfilePage

    @Serializable
    data object StorePage
}