package lasten.cardgame

import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color

val BOARD_BACKGROUND = Background(BackgroundFill(Color.GRAY, null, null))
val CARD_BACKGROUND = Background(BackgroundFill(Color.LIGHTGRAY, null, null))
val CARD_BORDER = Border(BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths(2.0)))

const val WIDTH = 960.00
const val HEIGHT = 0.65 * WIDTH
const val CARD_WIDTH = 0.2 * WIDTH
const val CARD_HEIGHT = 0.35 * HEIGHT
const val CARD_PICTURE_HEIGHT = (2 / 5) * CARD_HEIGHT
const val STARTING_CARDS = 3
