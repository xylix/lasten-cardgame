package lasten.cardgame

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import lasten.cardgame.gamelogic.Card
import lasten.cardgame.gamelogic.Deck
import lasten.cardgame.gamelogic.Decklist
import org.tinylog.kotlin.Logger
import java.io.File

object JsonUtils {
    private val json = Json(JsonConfiguration.Stable)

    fun loadCard(id: String): Card {
        val cardData: File = File("resources/cards/$id.json")
        val parsed = json.parse(Card.serializer(), cardData.readText())
        Logger.trace(parsed)
        return parsed
    }

    fun loadDecklist(id: String): Decklist {
        val deckData: File = File("resources/decklists/$id.json")
        val json = Json(JsonConfiguration.Stable)
        val parsed = JsonUtils.json.parse(Decklist.serializer(), deckData.readText())
        Logger.trace(parsed)
        return parsed
    }
}
