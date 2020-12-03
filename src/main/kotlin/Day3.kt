package day3

data class Pos(val x: Int, val y: Int) {
    operator fun plus(other: Pos) = Pos(x + other.x, y + other.y)
}

data class Map(val data: List<List<Boolean>>) {
    val width get() = data[0].size
    val height get() = data.size
    operator fun get(p: Pos) = data[p.y][p.x % width]
}

fun String.toMap(): Map {
    val data = lineSequence().map { row -> row.map { it == '#' } }.toList()
    return Map(data)
}

fun positions(slope: Pos) =
    generateSequence(Pos(0, 0)) { it + slope }

fun check(map: Map, slope: Pos) =
    positions(slope)
        .takeWhile { it.y < map.height }
        .count { map[it] }

fun part1(input: String): Int {
    val map = input.toMap()
    val slope = Pos(3, 1)
    return check(map, slope)
}

fun part2(input: String): Int {
    val map = input.toMap()
    val slopes = listOf(
        Pos(1, 1),
        Pos(3, 1),
        Pos(5, 1),
        Pos(7, 1),
        Pos(1, 2),
    )
    return slopes.map { check(map, it) }.reduce { a, b -> a * b }
}
