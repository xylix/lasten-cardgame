package lasten.cardgame.engine

import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import kotlinx.serialization.Serializable
import lasten.cardgame.CARD_BACKGROUND
import lasten.cardgame.CARD_BORDER
import lasten.cardgame.CARD_HEIGHT
import lasten.cardgame.CARD_WIDTH
import lasten.cardgame.FileUtils.loadGraphic
import org.tinylog.kotlin.Logger

@Serializable
data class Card(val id: String, val text: String, val rules: Map<String, String>, val graphics: String?) {
    fun toNode(): Node {
        val textBox = Label(text).also { it.minHeight = 40.00 }
        return CardBox(Label(id), loadGraphic(graphics!!), textBox)
    }
}

class CardBox(vararg children: Node?) : VBox(*children) {
    init {
        background = CARD_BACKGROUND
        prefWidth = CARD_WIDTH
        prefHeight = CARD_HEIGHT
        border = CARD_BORDER
        onMouseClicked = EventHandler { event: MouseEvent -> Logger.trace("MouseEvent: ${event.target}") }
    }
}

