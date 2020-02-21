package Main

fun main() {
    val name = "Madrigal"
    val isBlessed = true
    val isImmortal = false
    var healthPoints = 89

    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthyStatus = formatHealthStatus(healthPoints, isBlessed)

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "Outcast"
    }
    val levelOfBesotted =
        when (castFireball(5)){
            0 -> "Teetotal"
            in 1..10 -> "Tipsy"
            in 11..20 -> "Sloshed"
            in 21..30 -> "Soused"
            in 31..40 -> "Stewed"
            in 41..49 -> "y7SNd9gSD"
            else -> "Impossible"
        }
    printPlayerStatus(auraColor, isBlessed, name, healthyStatus, levelOfBesotted)
}

private fun castFireball(numFireballs:Int = 2) =
    when (numFireballs){
        0 -> 0
        in 1..2 -> (1..10).random()
        in 3..5 -> (11..20).random()
        in 6..10 -> (21..30).random()
        in 11..15 -> (31..40).random()
        in 15..20 -> (41..49).random()
        else -> 50
    }
    //println("A glass of Fireball springs into existence. (x$numFireballs)")

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthyStatus: String,
    levelOfBesotted: String
) {
    println(
        "Aura: $auraColor " +
                "(Blessed: ${if (isBlessed) "Yes" else "No"})"
    )
    println("Level of besotted: $levelOfBesotted")
    println("$name $healthyStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }