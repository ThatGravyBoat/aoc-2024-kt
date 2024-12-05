import kotlin.math.absoluteValue

fun main() {

    fun isSafe(numbers: List<Int>): Boolean {
        if (!numbers.isSortedBy { a, b -> a <= b } && !numbers.isSortedBy { a, b -> a >= b }) {
            return false
        } else {
            var last: Int? = null

            for (number in numbers) {
                if (last != null) {
                    val diff = (number - last).absoluteValue
                    if (diff == 0 || diff >= 4) return false
                }
                last = number
            }

            return true
        }
    }

    fun part1(input: List<String>): Int {
        return input.map { it.split(" ").map(String::toInt) }.count(::isSafe)
    }

    fun part2(input: List<String>): Int {
        return input.map { it.split(" ").map(String::toInt).toMutableList() }.count {
            if (isSafe(it)) {
                return@count true
            } else {
                for (i in 0 until it.size) {
                    val number = it[i]
                    it.removeAt(i)
                    if (isSafe(it)) return@count true
                    it.add(i, number)
                }
                return@count false
            }
        }
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}