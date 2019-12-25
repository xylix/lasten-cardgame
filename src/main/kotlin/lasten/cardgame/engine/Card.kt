package lasten.cardgame.engine

import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import kotlinx.serialization.Serializable

@Serializable
data class Card(val id: String, val text: String, val rules: Map<String, String>) {
    fun toNode(): Node {
        val node = VBox(Label(id), Label(text))
        node.onMouseClicked = EventHandler{ event: MouseEvent -> print(event)}
        return node
    }
}

