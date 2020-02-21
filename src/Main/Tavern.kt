package Main

const val TAVERN_NAME = "Taernyl's Folly"

fun main() {

    placeOrder("sandy,Dragon's Breath,5.91")
    placeOrder("sandy,Dragon's Breath,5.91")
}

fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name($type) for $price."
    println(message)

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name")}"
        "Madrigal exclaims ${toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE!")}"
    } else {
        "Madrigal says: 'Thanks for the $name'"
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

//val date = menuData.split(',')
//    val type = date[0]
//    val name = date[1]
//    val price = date[2]

//var beverage2 = readLine()!!.capitalize()

//      var beverage = readLine()
//    if (beverage != null){
//        beverage = beverage.capitalize()
//    } else {
//        println("I can't do that without crashing - beverage was null!")
//    }
//
//    val beverageServed: String = beverage?: "Buttered Ale"
//    println(beverageServed)






