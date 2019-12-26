package lasten.cardgame.engine

import kotlinx.serialization.Serializable
import lasten.cardgame.FileUtils.loadCard

@Serializable
data class Decklist (val cards: Map<String, Int>)

class Deck (decklist: Map<String, Int>) {
    private val deckState = mutableListOf<Card>()
    init {
        for ((key, value) in decklist) {
            val c = loadCard(key)
            for (i in 0..value) {
                deckState.add(c)
            }
        }
    }

    fun shuffle() {
        deckState.shuffle()
    }

    fun draw(amount: Int): Array<Card> {
        val cards = Array(amount) { draw() }
        return cards
    }

    private fun draw(): Card {
        return deckState.removeAt(0)
    }
}
