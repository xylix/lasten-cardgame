package lasten.cardgame.gamelogic

class Decklist {
    val cards = listOf<Card>()
}

class Deck (decklist: Decklist) {
    private val deckState: MutableList<Card> = decklist.cards.toMutableList()

    fun shuffle() {
        deckState.shuffle()
    }

    fun draw(): Card {
        return deckState.removeAt(0)
    }
}
