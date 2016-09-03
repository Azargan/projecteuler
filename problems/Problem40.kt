/**
 * Created by Aliaksei Vihuro <alexey.viguro@gmail.com> on 3.9.16.
 */

/*
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
fun main(args: Array<String>) {
    problem40brutforce()
    println("Answer: ${1 * 1 * 5 * 3 * 7 * 2 * 1}")
}

private fun problem40brutforce() {
    val mantisa = (1..202222).fold(StringBuilder()) { sb, number -> sb.append(number) }.toString()
    println("${mantisa[0]} * ${mantisa[9]} * ${mantisa[99]} * ${mantisa[999]} * ${mantisa[9999]} * ${mantisa[99999]} * ${mantisa[999999]}")
}

private fun problem40first() {
    val lengthMap = mapOf(
            1 to 1,
            10 to 2,
            100 to 3,
            1000 to 4,
            10000 to 5
    )

    var requiredNumbers = listOf(1, 10, 100, 1000, 10000, 100000, 1000000)
    val numbersMap = mapOf<Int, Int>()

    var length = 0
    var currentLentgth = 0
    (1..202222).forEach { number ->
        if (number in lengthMap) {
            currentLentgth = lengthMap[number]!!
        }
        length += currentLentgth

        if (requiredNumbers.isEmpty()) {
            println(numbersMap)
            return
        }

        val requirementLength = requiredNumbers.first()
        if (length >= requirementLength) {
            requiredNumbers = requiredNumbers.drop(1)
            println("Length: $length Number: $number")
        }

    }
    println()
    println("Answer: ${1 * 1 * 5 * 3 * 7 * 2 * 2}")
}