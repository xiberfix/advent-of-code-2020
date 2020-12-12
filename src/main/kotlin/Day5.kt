package day5

import common.boundsOrNull

fun binary(c: Char) = when (c) {
    'B', 'R' -> '1'
    'F', 'L' -> '0'
    else -> error(c)
}

fun id(s: String) = s.map { binary(it) }.joinToString("").toInt(2)

fun part1(input: String) = input
    .lineSequence()
    .map { id(it) }
    .maxOrNull()!!

fun part2(input: String): Int {
    val ids = input
        .lineSequence()
        .map { id(it) }
        .toList()
    // find missing number in arithmetic series: `expected sum` - `actual sum`
    val (min, max) = ids.boundsOrNull()!!
    val n = max - min + 1
    val s = (min + max) * n / 2
    return s - ids.sum()
}
