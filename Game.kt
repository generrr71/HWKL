package com.bignerdranch.nyethack

import com.sun.org.apache.xpath.internal.operations.Bool
import sun.text.normalizer.UCharacter
import java.util.*
import java.util.List
import kotlin.system.exitProcess



fun main(args: Array<String>) {
    //A
    //   val auraColor = player.auraColor(player.isBlessed)
    Game.play()
    //  player.auraColor(player.isBlessed)
}

object Game {

    private var continueGame: Boolean = true

    val player = Player("Madrigal")
    var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    //  private var positionMapDraw:List = listOf<>()


    init {
        println("Welcome, advanturer.")
        player.castFireball()
    }

    fun play() {

        while (continueGame == true) {
            println(currentRoom.description())
            println(currentRoom.load())
            printPlayerStatus(player)

            print(">Enter your command: ")
            println(GameInput(readLine()).processCommand())
            //playing
            //  GameInput(readLine()).processCommand()


        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor(player.isBlessed)})" +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus(player.healthPoints, player.isBlessed)}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            "map" -> mapDraw()

            "exit" -> exit()
            "ring" -> {
                if ((argument != null) && (argument != "") && (argument.matches("-?\\d+(\\.\\d+)?".toRegex()))) {
                    ring(argument.toInt())
                } else {
                    ring()
                }
            }
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }

    private fun exit(): String {
        continueGame = false
        return "exiting"
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction : $directionInput."
        }

    private fun mapDraw(): String {
        worldMap.forEach()
        {
            var sb1 = ""
            it.forEach() {

                if (it.name == currentRoom.name) {
                    sb1 += "X"
                } else {
                    sb1 += "0"
                }
            }
            println(sb1)
        }
        return "player's current position is 'X'"
    }

    public fun ring(numberOfRings: Int): String {
/// добавить проверку на - null и на ("") -пустая строка на вводе
        if (numberOfRings != null) {


            if (numberOfRings.toInt() >= 2) {

                if ("${currentRoom.name}" == "Town Square") {
                    val str1 = "${TownSquare().ringBell()} x $numberOfRings "
                    return "${str1}"

                } else if (numberOfRings == null) {
                    return TownSquare().ringBell()
                } else {
                    return "there is no bell around"
                }
            }
        }
        return TownSquare().ringBell()
    }

    public fun ring(): String {

        val str1 = "${TownSquare().ringBell()}"

        if ("${currentRoom.name}" == "Town Square") {

            return "${str1}"

            // return TownSquare().ringBell()
        } else {
            return "There is no bell around"
        }
    }
}
