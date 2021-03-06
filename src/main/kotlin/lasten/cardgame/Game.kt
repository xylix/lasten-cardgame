package lasten.cardgame

import javafx.application.Application
import javafx.stage.Stage
import lasten.cardgame.FileLoading.loadDecklist
import lasten.cardgame.engine.Match

class Game : Application() {
    override fun start(stage: Stage) {
        val playerDecklist = loadDecklist("1")
        val opponentDecklist = loadDecklist("1")
        stage.scene = Match(playerDecklist, opponentDecklist).toScene()
        stage.show()
    }

    companion object {
        @JvmStatic
        fun start() {
            launch(Game::class.java)
        }
    }
}
