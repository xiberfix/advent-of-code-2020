package day6

fun process(group: String, f: (Set<Char>, Set<Char>) -> Set<Char>) = group
    .lineSequence()
    .map { it.toSet() }
    .reduce(f)
    .size

fun part1(input: String) = input
    .splitToSequence("\n\n")
    .map { process(it, Set<Char>::union) }
    .sum()

fun part2(input: String) = input
    .splitToSequence("\n\n")
    .map { process(it, Set<Char>::intersect) }
    .sum()
