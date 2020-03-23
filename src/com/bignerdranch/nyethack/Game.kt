package com.bignerdranch.nyethack

import java.lang.Exception
import java.lang.IllegalStateException

fun main() {
    Game.play()
}

object Game {
    private val player = Player("madrigal")
    private var currentRoom: Room = TownSquare()
    private var isGameStatus = false

    private val worldMap = listOf(
        listOf(
            currentRoom, Room("Tavern"), Room("BackRoom"),
            listOf(Room("Long Corridor"), Room("Generic Room"))
        )
    )

    init {
        println("Welcome, adventurer")
        player.castFireball()
    }

    fun play() {
        while (!isGameStatus) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor()}) " +
                    "(Blessed: ${if (player.isBlessed) "Yes" else "No"})"
        )
        println("${player.name}  ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            "quit" -> quit()
            "map" -> map()
            else -> commandNotFound()
        }
    }

    private fun quit() {
        println("Good luck ${player.name}")
        isGameStatus = true
    }

//    private fun map() {
//        for (maps in worldMap){
//            for (map in maps){
//                var statusRoom = "0"
//                if (map == currentRoom) statusRoom = "X"
//                print("$statusRoom ")
//            }
//        }
//    }

    private fun map() {
        var mapStr = ""
        for (maps in worldMap) {
            maps.forEachIndexed { index, any ->
                if (index == 0) mapStr.plus("\n")
                print("mapStr")
            }
        }
    }

    private fun commandNotFound() = "I'm not quit sure what you're trying to do!"

    private fun move(directionInput: String) {
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom as Room
            "OK, you move $direction to the ${newRoom.name}.\n ${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }
    }
}


/*val auraColor = player.auraColor(isBlessed, healthPoints, isImmortal)
player.auraColor(isBlessed, healthPoints, isImmortal)*/


//println("Level of besotted: $levelOfBesotted")


/*
* val race = "gnome"
//    val faction = when (race) {
//        "dwarf" -> "Keepers of the Mines"
//        "gnome" -> "Keepers of the Mines"
//        "orc" -> "Free People of the Rolling Hills"
//        "human" -> "Free People of the Rolling Hills"
//        else -> "Outcast"
//    }
* */

/*//private fun castFireball(numFireballs:Int = 2) =
//    when (numFireballs){
//        0 -> 0
//        in 1..2 -> (1..10).random()
//        in 3..5 -> (11..20).random()
//        in 6..10 -> (21..30).random()
//        in 11..15 -> (31..40).random()
//        in 15..20 -> (41..49).random()
//        else -> 50
//    }
    //println("A glass of Fireball springs into existence. (x$numFireballs)")
*/

/*val levelOfBesotted =
//        when (castFireball(5)){
//            0 -> "Teetotal"
//            in 1..10 -> "Tipsy"
//            in 11..20 -> "Sloshed"
//            in 21..30 -> "Soused"
//            in 31..40 -> "Stewed"
//            in 41..49 -> "y7SNd9gSD"
//            else -> "Impossible"
//        }*/