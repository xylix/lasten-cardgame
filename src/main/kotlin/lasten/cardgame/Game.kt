package lasten.cardgame

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import lasten.cardgame.JsonUtils.loadDecklist
import lasten.cardgame.gamelogic.Decklist
import lasten.cardgame.gamelogic.Match

class Game : Application() {
    override fun start(stage: Stage) {
        val playerDecklist = loadDecklist("1.json")
        val opponentDecklist = loadDecklist("1.json")
        stage.scene = toScene(Match(playerDecklist, opponentDecklist))
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
