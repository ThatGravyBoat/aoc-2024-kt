import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        for (line in input) {
            val (first, second) = line.split("   ")
            list1.add(first.toInt())
            list2.add(second.toInt())
        }

        list1.sort()
        list2.sort()

        return list1.zip(list2).sumOf { (first, second) -> (first - second).absoluteValue }
    }

    fun part2(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val occurances = mutableMapOf<Int, Int>()

        for (line in input) {
            val (first, second) = line.split("   ")
            list1.add(first.toInt())
            val key = second.toInt()

            occurances[key] = (occurances[key] ?: 0) + 1
        }

        return list1.sumOf { it * (occurances[it] ?: 0) }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
