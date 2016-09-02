import java.util.*

/**
 * Created by Aliaksei Vihuro <alexey.viguro@gmail.com> on 2.9.16.
 */

/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
 */
fun main(args: Array<String>) {
    println(firstTry())
}

fun firstTry(): Int {
    val n = 1000
    val m = HashMap<Int, Int>()

    var a = 1
    while (a < n) {

        var b = 1
        while (b < n) {

            var c = 1
            while (c < n) {

                val p: Int = (a + b + c)
                if ((p < 1000) && (a * a == (b * b + c * c))) {

                    val count: Int? = m[p]
                    m.put(p, if (count == null) 1 else count + 1)
                }

                c++
            }

            b++
        }

        a++
    }

    val max = m.maxBy { it.value }
    return if (max == null) 0 else max.key
}