package com.bignerdranch.nyethack

open class Room(val name: String) {

    protected open val dangerLevel = 5
    var monster: Monster? = Goblin()

    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel" +
            "Creature: ${monster?.description ?: "none."}"

    open fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square") {

    private val bellSound = "GWONG"

    override val dangerLevel = super.dangerLevel - 3

    final override fun load() = "The villagers rally and cheer as you enter!\n" +
            "${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}