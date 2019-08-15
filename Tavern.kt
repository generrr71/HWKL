import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold =0
var playerSilver =0
var playerDrakoins = 5.0
var gallonsRemain = 5.0
val gallon  = 1
val pint = 0.125 * gallon
var pintsRemain = gallonsRemain/pint
val dracoinTradeCourse = 1.43


fun main (args: Array<String>) {

    placeOrder("shandy,Dragon's Breath,5.91")
  //  placeOrder("elixir,Shirley's Temple,4.12")
    placeOrder("shandy,Dragon's Breath,5.91")

    //   var beverage = readLine()
//    var beverage = readLine()?.let {
//        if(it.isNotBlank()){
//            it.capitalize()
//        }
//        else {
//            "Buttered Ale"
//        }
//    }
//    beverage = null
//    println(beverage)
}

fun performPurchase(price:Double){
    displayBalance()
    displayGallonsRemain()
 //   val gallon = 1
//    val pint = gallon * 0.125

   // val totalPurse = playerGold +(playerSilver/100.0)
    val totalPurse = Math.round((playerDrakoins* dracoinTradeCourse)*100)/100.0
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    pintsRemain = (gallonsRemain - pint)/pint
    gallonsRemain = pintsRemain*pint



    println("Remaining Gold balance :${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance%1*100).roundToInt()
  // playerGold = remainingGold
  //  playerSilver = remainingSilver
    playerDrakoins = remainingBalance.toDouble()/dracoinTradeCourse
    playerDrakoins = Math.round(playerDrakoins * 10000) / 10000.0

    displayBalance()
    displayGallonsRemain()
}

private fun displayBalance(){
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver, Dracoins: $playerDrakoins")
}

private fun displayGallonsRemain(){
    println("Full gallons in barrel for now : ${gallonsRemain.toInt()} ( ${pintsRemain.roundToInt()} pints) ")
}

private fun toDragonSpeak(phrase:String)=
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(menuData:String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    println("Today 1 Dracoin = $dracoinTradeCourse Gold")

    val(type,name,price) = menuData.split(',')

    if ((((playerGold.toDouble()+(playerSilver/100.0))>= price.toDouble())&&(pintsRemain>=1)) ||
        ((playerDrakoins*dracoinTradeCourse >= price.toDouble())&&(pintsRemain >= 1))) {

    val message = "Madrigal buys a $name ($type) for $price gold. "
    println(message)

        performPurchase(price.toDouble())

        val phrase = if (name == "Dragon's Breath") {
            "Mardrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        } else {
            "Mardigal says: Thanks for the $name"
        }
        println(phrase)
//    val phrase = "Ah, delicious $name!"
//    println("Madrigal ecxlaims: ${toDragonSpeak(phrase)}")
    } else {
        println("Madrigal try to buy a $name ($type) for $price gold.")
        println("Madrigal can't buy this thing for now")
    }
}
