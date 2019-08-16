import kotlin.math.roundToInt
import java.io.File

//const val TAVERN_NAME = "Taernyl's Folly"
//
//var playerGold =10
//var playerSilver =10

const val MENU_STRING_MAX_LENGTH = 35

//val patronList = mutableListOf("Eli","Mordoc","Sophie")
//val lastName = listOf("Ironfoot","Fernsworth","Baggins")

//val uniquePatrons = mutableSetOf<String>()

val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

fun main (args: Array<String>) {

    var isFirstShandy = true
    var isFirstElixir = true
    var isFirstMeal =  true
    var isFirstDessert = true

    menuList.forEach{
        inputStringFormatingMethod1(menuList.indexOf(it),it)
    }

    val sortedList =  menuList.sortedBy { it.first() }.reversed()

    println("")

    println("*** Welcome to Taernyl's Folly ***")
    sortedList.forEach()
    {
        if (it.split(",").first() == "shandy")
        {
            if (isFirstShandy) {
                println("${" ".repeat((MENU_STRING_MAX_LENGTH/3).toInt())}" +"~[shandy]~")
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
                isFirstShandy = false
            } else {
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
            }

        }
        else if (it.split(",").first() == "elixir")
        {
            if (isFirstElixir) {
                println("${" ".repeat((MENU_STRING_MAX_LENGTH/3).toInt())}" +"~[elixir]~")
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
                isFirstElixir = false
            } else {
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
            }

        }
        else if (it.split(",").first() == "meal")
        {
            if (isFirstMeal) {
                println("${" ".repeat((MENU_STRING_MAX_LENGTH/3).toInt())}" +"~[meal]~")
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
                isFirstMeal = false
            } else {
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
            }

        }
        else if (it.split(",").first() == "desert dessert")
        {
            if (isFirstDessert) {
                println("${" ".repeat((MENU_STRING_MAX_LENGTH/3).toInt())}" + "~[desert dessert]~")
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
                isFirstDessert = false
            } else {
                inputStringFormatingMethod2(sortedList.indexOf(it), it)
            }

        }
      //  println(it)
    }


}

private fun inputStringFormatingMethod1 (index: Int, data: String){
    val processingStringDataElements = data.split(",")
    val itemType = processingStringDataElements[0]
    val itemName = processingStringDataElements[1].capitalize()
    val itemCost = processingStringDataElements[2]
    val nextStringSpecialSymbolPresent = if (processingStringDataElements.last().contains('\r')){
        1
    } else {
        0
    }

    var numberOfPointsToDraw = MENU_STRING_MAX_LENGTH - (itemName.length + itemCost.length -  nextStringSpecialSymbolPresent)
    val pointsToDraw = "${".".repeat(numberOfPointsToDraw)}"

    println("$itemName"+"$pointsToDraw"+"$itemCost" )
}

private fun inputStringFormatingMethod2(index: Int, data: String){



    val processingStringDataElements = data.split(",")
    val itemType = processingStringDataElements[0]
    val itemName = processingStringDataElements[1].capitalize()
    val itemCost = processingStringDataElements[2]
    val nextStringSpecialSymbolPresent = if (processingStringDataElements.last().contains('\r')){
        1
    } else {
        0
    }

    val desertShortedLine:Int = 6

    val numberOfPointsToDraw:Int = if (itemType == "desert dessert") {
              MENU_STRING_MAX_LENGTH - (itemName.length + itemCost.length - nextStringSpecialSymbolPresent) - desertShortedLine
        } else {
             MENU_STRING_MAX_LENGTH - (itemName.length + itemCost.length - nextStringSpecialSymbolPresent)
        }

    val pointsToDraw = "${".".repeat(numberOfPointsToDraw)}"


    //println("shandy")
  //  if(itemType=="shandy") {
  //      println("$itemName"+"$pointsToDraw"+"$itemCost" )
  //  }
  //  else if(itemType=="elixir"){
  //      println("$itemName"+"$pointsToDraw"+"$itemCost" )
 //   }
  //  else if (itemType=="meal"){
  //      println("$itemName"+"$pointsToDraw"+"$itemCost" )
  //  }
  //  else if (itemType=="desert dessert"){

        println("$itemName"+"$pointsToDraw"+"$itemCost" )
   // } else {
  //      println("")
  //  }

}

