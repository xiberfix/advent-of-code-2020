package day9

import common.boundsOrNull

fun String.toLongs() = this.lineSequence().map { it.toLong() }


// Part #1

// find pair of numbers in `xs` which sums up to `sum`
// returns `null` if it's not possible
// O(n*log(n))
fun findPair(xs: List<Long>, sum: Long): Pair<Long, Long>? {
    if (xs.isEmpty()) return null
    val ys = xs.sorted()
    val lr = generateSequence(Pair(0, ys.size - 1)) { (l, r) ->
        when {
            l >= r -> null
            ys[l] + ys[r] < sum -> Pair(l + 1, r)
            ys[l] + ys[r] > sum -> Pair(l, r - 1)
            else -> null
        }
    }
    return lr.firstOrNull { (l, r) -> ys[l] + ys[r] == sum }?.let { (l, r) -> Pair(ys[l], ys[r]) }
}

fun part1(input: String, k: Int = 25): Long = input
    .toLongs()
    .windowed(k + 1)
    .first { findPair(it.take(k), it.last()) == null }
    .last()


// Part #2

// find continuous range of numbers in `xs` which sums up to `sum`
// returns `null` if it's not possible
// O(n)
fun findRange(xs: List<Long>, sum: Long): Pair<Int, Int>? {
    if (xs.isEmpty()) return null
    val n = xs.size
    val lr = generateSequence(Triple(0, 1, xs[0])) { (l, r, s) ->
        when {
            l >= n || r > n || l >= r -> null
            s < sum -> Triple(l, r + 1, s + xs[r])
            s > sum -> Triple(l + 1, r, s - xs[l])
            else -> null
        }
    }
    return lr.firstOrNull { (_, _, s) -> s == sum }?.let { (l, r, _) -> Pair(l, r) }
}

fun part2(input: String, k: Int = 25): Long {
    val goal = part1(input, k)
    val xs = input.toLongs().toList()
    val (begin, end) = findRange(xs, goal)!!
    val (min, max) = xs.subList(begin, end).boundsOrNull()!!
    return min + max
}
