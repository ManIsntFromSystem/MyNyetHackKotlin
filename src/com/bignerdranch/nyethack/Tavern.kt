package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

var greetingParent = ""
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatron = mutableSetOf<String>()
var typeMenuItems = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()

fun main() {

    displayMenuList()

    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Mordoc", "Sophie"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    placeOrder(
        "Madrigal",
        menuList[0]
    )
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatron += name
    }
    println(uniquePatron)

    uniquePatron.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(
            uniquePatron.shuffled().first(),
            menuList.shuffled().first()
        )
        orderCount++
    }

    displayPatronBalance()
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    if (totalPurse >= price){
        patronGold[patronName] = totalPurse - price
    } else {
        println("Bouncer throws the $patronName out")
    }
}

fun displayPatronBalance() {
    patronGold.forEach { (patron, balance) ->
        if (balance < 0){
            patronGold.remove(patron)
            uniquePatron.remove(patron)
            println("Bouncer throws the $patron out")
        } else {
            println("$patron, balance: ${"%.2f".format(balance)}")
        }
    }
}

fun placeOrder(namePatron: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$namePatron speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$namePatron buys a $name($type) for $price"
    println(message)

    if (namePatron != "Madrigal") performPurchase(
        price.toDouble(),
        namePatron
    )
//    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath" && namePatron == "Madrigal") {
        "$namePatron exclaims ${toDragonSpeak("Ah, delicious $name")}"
        "$namePatron exclaims ${toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE!")}"
    } else if (name == "Dragon's Breath") {
        "$namePatron exclaims ${toDragonSpeak("Ah, delicious $name")}"
    } else {
        "$namePatron says: 'Thanks for the $name'"
    }

    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }
private fun displayMenuList() {
    greetingParent = "*** Welcome to $TAVERN_NAME ***\n"
    println(greetingParent)

    var itemsCount = 0
    while ( itemsCount < menuList.size) {
        val (type, _, _) = menuList[itemsCount].split(',')
        typeMenuItems.add(type)
        itemsCount++
    }

    for (typeItem in typeMenuItems) {
        println("        ~[$typeItem]~        ")

        for (item in menuList) {
            val (_, name, price) = item.split(',')
            if (item.contains(typeItem))
                println("$name.........$price")
        }
    }
    println()
}






