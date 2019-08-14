import java.util.concurrent.locks.Condition

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints: Int = 89
    var isBlessed: Boolean = true
    val isImmortal = false
   // var playerDrunkCondition: Int = 1;

    //A
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    println(
        "(Aura: $auraColor)" +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )

    println("$name $healthStatus")

   // castFireball()

    val drunkConditionText = formatplayerDrunkConditionText(castFireball())
    println(drunkConditionText)
}

//private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
//    val auraVisible = (isBlessed && healthPoints > 50) || isImmortal
//    val auraColor = if (auraVisible) "GREEN" else "NONE"
//    return auraColor
//}
private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if ((isBlessed && healthPoints > 50) || isImmortal) {
        "GREEN"
    } else {
        "NONE"
    }


//private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
//    val healthStatus = when (healthPoints) {

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
    100 -> "is in excellent condition!"
    in 90..99 -> "has a few scratches."
    in 75..89 -> if (isBlessed) {
        "has some minor wounds but is healing quite quickly."
    } else {
        "has some minor wounds."
    }

    in 15..74 -> "looks pretty hurt."
    else -> "is in awful condition!"
}
//   return healthStatus
//}

//private fun castFireball(numFireballs: Int = 2){
//    println("A glas of Fireball springs into existence. (x$numFireballs)")
//}
private fun castFireball(numFireballs: Int = 2): Int {
    val playerMinDrunkCondition = 1
    val playerMaxDrunkCondition = 50

    val playerDrunkCondition = (
            if ((numFireballs >= playerMinDrunkCondition) && (numFireballs <= playerMaxDrunkCondition)) {
                numFireballs
            } else if (numFireballs > playerMaxDrunkCondition) {
                playerMaxDrunkCondition
            } else {
                playerMinDrunkCondition
            }
            )
    println("A glas of Fireball springs into existence. (x$numFireballs)")

    return playerDrunkCondition
}

private fun formatplayerDrunkConditionText(playerDrunkCondition: Int): String {
    val drunkConitionText = when (playerDrunkCondition) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        else -> "t0aSt3d"
    }
    return drunkConitionText
}




