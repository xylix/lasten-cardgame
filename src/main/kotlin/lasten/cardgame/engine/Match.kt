package lasten.cardgame.engine

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.shape.Rectangle
import lasten.cardgame.Game.Companion.WIDTH


class Match (playerDecklist: Decklist, opponentDecklist: Decklist) {
    val playerDeck: Deck = shuffle(playerDecklist)
    val opponentDeck: Deck = shuffle(opponentDecklist)
    val playerHand = playerDeck.draw(3)
    val opponentHand = opponentDeck.draw(3)


    fun toScene() : Scene {

        val pane = VBox()

        val handArea = handToNode("Player's hand", playerHand)
        val opponentHandArea = handToNode("Opponent's hand", opponentHand)

        pane.children.add(opponentHandArea)
        pane.children.add(Rectangle(WIDTH, 200.00))
        pane.children.add(handArea)
        return Scene(pane, WIDTH, 560.00)
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

