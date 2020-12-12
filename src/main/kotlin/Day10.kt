package day10

fun read(input: String) = sequence {
    yield(0)
    val xs = input.lineSequence().map { it.toInt() }.sorted().toList()
    yieldAll(xs)
    yield(xs.last() + 3)
}

fun part1(input: String): Int {
    val diffs = read(input).zipWithNext { a, b -> b - a }.toList()
    return diffs.count { it == 1 } * diffs.count { it == 3 }
}

fun part2(input: String): Long {
    val xs = read(input).toList()
    val ways = MutableList(xs.last() + 1) { 0L }
    ways[xs.last()] = 1
    for (x in xs.reversed().drop(1))
        ways[x] = ways.subList(x + 1, x + 1 + 3).sum()
    return ways[0]
}
