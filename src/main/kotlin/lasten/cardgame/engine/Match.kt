package lasten.cardgame.engine

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.shape.Rectangle
import lasten.cardgame.BOARD_BACKGROUND
import lasten.cardgame.CARD_HEIGHT
import lasten.cardgame.STARTING_CARDS
import lasten.cardgame.WIDTH

class Match (playerDecklist: Decklist, opponentDecklist: Decklist) {
    val playerDeck: Deck = shuffle(playerDecklist)
    val opponentDeck: Deck = shuffle(opponentDecklist)
    val playerHand = playerDeck.draw(STARTING_CARDS)
    val opponentHand = opponentDeck.draw(STARTING_CARDS)


    fun toScene() : Scene {
        val pane = VBox()
                .also { it.spacing = 4.0 }
                .also { it.background =  BOARD_BACKGROUND }
        val handArea = handToNode("Player's hand", playerHand)
        val opponentHandArea = handToNode("Opponent's hand", opponentHand)

        pane.children.add(opponentHandArea)
        pane.children.add(Rectangle(WIDTH, CARD_HEIGHT))
        pane.children.add(handArea)
        return Scene(pane)
    }

    private fun handToNode(label: String, cards: Array<Card>): Node {
        return HBox(Label(label), *cards.map { card -> card.toNode() }.toTypedArray())
    }

    companion object {
        fun shuffle(decklist: Decklist): Deck {
            return Deck(decklist.cards).also {
                it.shuffle()
            }
        }
    }
}


