fun main() {

    fun part1(input: List<String>): Int {
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
        return regex.findAll(input.joinToString("\n"))
            .map(MatchResult::groups)
            .sumOf { it[1]!!.value.toInt() * it[2]!!.value.toInt() }
    }

    fun part2(input: List<String>): Int {
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)|don't\\(\\)|do\\(\\)")
        var active = true

        return regex.findAll(input.joinToString("\n"))
            .sumOf {
                when {
                    it.value == "don't()" -> {
                        active = false
                        0
                    }
                    it.value == "do()" -> {
                        active = true
                        0
                    }
                    active -> it.groups[1]!!.value.toInt() * it.groups[2]!!.value.toInt()
                    else -> 0
                }
            }
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}