fun main() {

    val dirs: List<Pair<Int, Int>> = listOf(
        0 to -1,
        0 to 1,
        -1 to 0,
        1 to 0,
        -1 to -1,
        -1 to 1,
        1 to -1,
        1 to 1,
    )

    fun part1(input: List<String>): Int {
        val grid = input.map(String::toCharArray)
        var found = 0

        for ((y, row) in grid.withIndex()) {
            for ((x, char) in row.withIndex()) {
                if (char == 'X') {
                    fun check(x: Int, y: Int, mulX: Int, mulY: Int): Boolean =
                        (mulX != 1 || x < row.size - 3) && (mulX != -1 || x >= 3) && (mulY != 1 || y < grid.size - 3) && (mulY != -1 || y >= 3) &&
                                grid[y + 1 * mulY][x + 1 * mulX] == 'M' &&
                                grid[y + 2 * mulY][x + 2 * mulX] == 'A' &&
                                grid[y + 3 * mulY][x + 3 * mulX] == 'S'

                    dirs.forEach { (xMul, yMul) ->
                        if (check(x, y, xMul, yMul)) {
                            found++
                        }
                    }
                }
            }
        }

        return found
    }

    fun part2(input: List<String>): Int {
        val grid = input.map(String::toCharArray)
        var found = 0

        for (y in 1 until grid.size - 1) {
            val row = grid[y]
            for (x in 1 until row.size - 1) {
                if (row[x] == 'A') {
                    val above = grid[y - 1]
                    val below = grid[y + 1]

                    val top_left_bottom_right = (above[x - 1] == 'M' && below[x + 1] == 'S') || (above[x - 1] == 'S' && below[x + 1] == 'M')
                    val top_right_bottom_left = (above[x + 1] == 'M' && below[x - 1] == 'S') || (above[x + 1] == 'S' && below[x - 1] == 'M')

                    if (top_left_bottom_right && top_right_bottom_left) {
                        found++
                    }
                }
            }
        }

        return found
    }

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}