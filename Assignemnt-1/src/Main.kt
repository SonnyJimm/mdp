fun findFirstLastANumber(num: Int):Int{
    if (num < 10){
        return num
    }
    var last = num%10
    var res = num
    while (res >= 10) res /= 10
    return res * 10 + last
}
fun findOddSquares(array: Array<Int>): Int{
    var sum = 0
    for(num in array){
        if(num % 2 == 1){
            sum += num*num
        }
    }
    return sum
}
fun isNumeric(toCheck: String): Boolean {
    return toCheck.all { char -> char.isDigit() }
}

fun getWeight() {
    println("Please Choose the planet you are in:")
    println("""
        1 Venus
        2 Mars
        3 Jupiter
        4 Saturn
        5 Uranus 
        6 Neptune
    """.trimIndent())
    var  input = readlnOrNull()
    while(input == null || !input.matches("^[1-6]\$".toRegex())){
        println("please insert valid choice : ")
        input = readlnOrNull()
    }
    println("please insert your weight : ")
    var weightInput = readlnOrNull()
    while(weightInput == null ||!isNumeric(weightInput)){
        println("please insert valid number : ")
        weightInput = readlnOrNull()
    }
    var weight = weightInput.toDouble()
    when(input){
        "1"-> println(weight * 0.78)
        "2"-> println(weight * 0.39)
        "3"-> println(weight * 2.65)
        "4"-> println(weight * 1.17 )
        "5"->println(weight * 1.05)
        "6"->println(weight * 1.23)
    }

}
fun main() {
    println("Hello World!")
    println(findFirstLastANumber(11))
    println(findOddSquares(arrayOf(1,2,3,4,5,6,7,8,9,10)))
    getWeight()
    var test = Test()
    test.test()
}