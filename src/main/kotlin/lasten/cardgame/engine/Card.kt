package lasten.cardgame.engine

import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import kotlinx.serialization.Serializable
import lasten.cardgame.CARD_HEIGHT
import lasten.cardgame.CARD_WIDTH

@Serializable
data class Card(val id: String, val text: String, val rules: Map<String, String>) {
    fun toNode(): Node {
        val node = VBox(Label(id), Label(text))
        node.prefWidth = CARD_WIDTH
        node.prefHeight = CARD_HEIGHT
        node.border = Border(BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths(2.0)))
        node.onMouseClicked = EventHandler{ event: MouseEvent -> println(event)}

        return node
    }
}

