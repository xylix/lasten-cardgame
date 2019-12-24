package lasten.cardgame.gamelogic

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.tinylog.kotlin.Logger
import java.io.File

@Serializable
data class Card(val id: String, val text: String) {

}

