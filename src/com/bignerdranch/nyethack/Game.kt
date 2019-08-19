package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    val player = Player()

    player.castFireball()

    //A
    val auraColor = player.auraColor(player.isBlessed)

    printPlayerStatus(player)
    player.auraColor(player.isBlessed)
}

private fun  printPlayerStatus(player: Player){
    println("(Aura: ${player.auraColor(player.isBlessed)})" +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus(player.healthPoints,player.isBlessed)}")
}


