package lasten.cardgame.gamelogic


class Match (private val player: Person, private val opponent: Person) {
    val playerDeck: Deck = shuffle(player.decklist)
    val opponentDeck: Deck = shuffle(opponent.decklist)

}

fun shuffle(decklist: Decklist): Deck {
    val deck = Deck(decklist)
    deck.shuffle()
    return deck
}
