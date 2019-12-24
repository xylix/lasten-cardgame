package lasten.cardgame.gamelogic


class Match (private val playerDecklist: Decklist, private val opponentDecklist: Decklist) {
    val playerDeck: Deck = shuffle(playerDecklist)
    val opponentDeck: Deck = shuffle(opponentDecklist)

}

fun shuffle(decklist: Decklist): Deck {
    val deck = Deck(decklist)
    deck.shuffle()
    return deck
}
