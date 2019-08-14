fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints: Int = 89
    val isBlessed: Boolean = true
    val isImmortal = false
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    //A
    val auraVisible = (isBlessed && (healthPoints > 50)) || isImmortal
    val auraColor = if (auraVisible) {
        when (karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purpple"
            in 16..20 -> "green"
            else -> "INVALID_karma_VALUE"
        }
    } else {
        "NONE"
    }
    //  println(auraColor)

    val healthStatus = when (healthPoints) {
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
    //playerStatus
//    println("(Aura: $auraColor)" +
//            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
//    println("$name $healthStatus")
    val HP = ("HP: $healthPoints")
    val A = ("Aura: $auraColor")
    val H = ("$healthStatus")
    val B = (if (isBlessed) {
        "Blessed: YES"
    } else {
        "Blessed: NO"
    })

    val statusFormatString = "($HP)($A)($B) -> $H"
    println(statusFormatString)
}
