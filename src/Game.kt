fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints: Int = 89
    var isBlessed: Boolean = true
    val isImmortal = false

    //A
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    //  println(auraColor)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    //playerStatus
    println("(Aura: $auraColor)" +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")

    castFireball()
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = (isBlessed && healthPoints > 50) || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
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
private fun castFireball(numFireballs: Int = 2) =
    println("A glas of Fireball springs into existence. (x$numFireballs)")
