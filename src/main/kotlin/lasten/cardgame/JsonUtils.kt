package lasten.cardgame

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
import lasten.cardgame.engine.Card
import lasten.cardgame.engine.Decklist
import org.tinylog.kotlin.Logger
import java.io.File
import java.net.URL

object JsonUtils {
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

    /** Source for getResource:
     * https://github.com/google/guava/blob/master/guava/src/com/google/common/io/Resources.java
     * Copyright (C) 2007 The Guava Authors
     */
    private fun getResource(resourceName: String): URL {
        val loader: ClassLoader =
                Thread.currentThread().contextClassLoader?: JsonUtils.javaClass.classLoader
        val url: URL? = loader.getResource(resourceName)
        return url ?: throw NullPointerException("resource $resourceName not found.")
    }
}
