package day1

fun part1(input: String): Int {
    val xs = input.lineSequence().map { it.toInt() }.toList()
    val s = xs.toSet()
    val a = xs.first { s.contains(2020 - it) }
    val b = 2020 - a
    return a * b
}

fun part2(input: String): Int {
    val xs = input.lineSequence().map { it.toInt() }.toList()
    val s = xs.toSet()
    val pairs = xs.flatMapIndexed { i, a -> xs.asSequence().drop(i + 1).map { b -> a to b } }
    val (a, b) = pairs.first { s.contains(2020 - (it.first + it.second)) }
    val c = 2020 - (a + b)
    return a * b * c
}
