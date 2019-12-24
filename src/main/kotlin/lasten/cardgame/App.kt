package lasten.cardgame

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

fun main(args: Array<String>) {
    Game.start()
    println(App().greeting)
}
