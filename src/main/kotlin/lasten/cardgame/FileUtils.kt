package lasten.cardgame

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
import lasten.cardgame.engine.Card
import lasten.cardgame.engine.Decklist
import org.tinylog.kotlin.Logger
import java.io.File
import java.net.URL

object FileUtils {
    private const val cardPath = "cards.json"
    private const val decklistPath = "decklists/"
    private val json = Json(JsonConfiguration.Stable)

    fun loadCard(id: String): Card {
        val cardData = File(getResource(cardPath).file)

        val parsed = json.parse(Card.serializer().list, cardData.readText())
        val card = parsed.firstOrNull{ entry -> entry.id == id }
                ?: throw NoSuchElementException("Card $id not found in $cardPath")
        Logger.trace("Loaded $card from $cardPath")
        return card
    }

    fun loadDecklist(id: String): Decklist {
        val deckData: File = File(getResource("$decklistPath/$id.json").file)
        val json = Json(JsonConfiguration.Stable)
        val decklist = json.parse(Decklist.serializer(), deckData.readText())
        Logger.trace("Loaded $decklist from $decklistPath$id.json")
        return decklist
    }

    fun loadGraphic(filename: String): ImageView {
        val path = getResource("assets/$filename")
        return ImageView(
                Image(path.toString(), CARD_WIDTH, CARD_PICTURE_HEIGHT, true, false))
    }
    /** Source for getResource:
     * https://github.com/google/guava/blob/master/guava/src/com/google/common/io/Resources.java
     * Copyright (C) 2007 The Guava Authors
     */
    private fun getResource(resourceName: String): URL {
        val loader: ClassLoader =
                Thread.currentThread().contextClassLoader?: FileUtils.javaClass.classLoader
        val url: URL? = loader.getResource(resourceName)
        return url ?: throw NullPointerException("resource $resourceName not found.")
    }
}
