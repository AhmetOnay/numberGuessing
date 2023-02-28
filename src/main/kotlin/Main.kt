import kotlin.random.Random

fun main() {
    var random: Int
    do {
        random = Random.nextInt(1000,10000)
    } while (!random.isEachDigitUnique())


    //println(random)
    do{
        print("Guess the 4 Digits: ")
        val rand = random.toString().toCharArray().toList()
        val res = readLine().toString().toCharArray().toList()
        val resTemp = res.toMutableList()

        val countRightByPosition = rand.zip(res) .count{ (a,b) -> a == b }
        val countRight = rand.filter { it in resTemp }.also { i -> resTemp.removeAll(i) }.count()
        println("User Input: ${res.joinToString("")}, Output: $countRight:$countRightByPosition")
    }while(res !=rand)

}

fun Int.isEachDigitUnique(): Boolean {
    val digits = this.toString().toCharArray()
    return digits.toSet().size == digits.size
}