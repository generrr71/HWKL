const val MAX_EXP:Int = 5000
fun main (args: Array<String>){
    val playerName = "Estragon"
    var hasSteed :Boolean = false
    var curLocation :String = "UnicornHorn Tavern"
    val vendor59Name :String ="Npc59PlaceholderName"
    var playerMoney :Int = 50;
    val listOfCurItemsToBuy = setOf("mead", "vine", "beer")

    var expPoints = 5
   // expPoints +=5

    var plNameRev :String = playerName.reversed()
    println(playerName)
    println("has steed="+hasSteed)
    println("location="+curLocation)
    println(listOfCurItemsToBuy)

    println(expPoints)

    println("ReversedMirrorImg="+plNameRev)

}

// fun String.reversed(): String

