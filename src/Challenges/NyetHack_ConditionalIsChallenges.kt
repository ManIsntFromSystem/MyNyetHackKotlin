package Challenges

fun main() {
    val name = "Madrigal"
    val isBlessed = true
    val isImmortal = false
    var healthPoints = 89

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    //Aura
    val auraColor = when (karma) {
        in 0..5 -> "Red"
        in 6..10 -> "Orange"
        in 11..15 -> "Purple"
        in 16..20 -> "Green"
        else -> "Unknown"
    }

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "Outcast"
    }

    val healthyStatus = formatHealthStatus(healthPoints, isBlessed)

    val statusFormatString1 = "(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    println(statusFormatString1)

    val statusFormatString2 = "(HP: $healthPoints) " +
            "(Aura: $auraColor)" +
            " -> $name $healthyStatus"
    println(statusFormatString2)
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthyStatus = when (healthPoints) {
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
    return healthyStatus
}