package lasten.cardgame.gamelogic

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

@Serializable
data class Decklist (val cards: List<Card>)

class Deck (decklist: Decklist) {
    private val deckState: MutableList<Card> = decklist.cards.toMutableList()

    fun shuffle() {
        deckState.shuffle()
    }

    fun draw(): Card {
        return deckState.removeAt(0)
    }
}
