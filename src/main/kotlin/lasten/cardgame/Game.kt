package lasten.cardgame

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import lasten.cardgame.gamelogic.Match

class Game : Application() {
    override fun start(stage: Stage) {
        stage.scene = toScene(Match())
        stage.show()
    }
    
    companion object {
        fun toScene(match : Match) : Scene {
            val pane = GridPane()
            return Scene(pane, 640.00, 480.00)
        }

        @JvmStatic
        fun start() {
            launch(Game::class.java)
        }
    }
}
