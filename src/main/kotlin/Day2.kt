package day2

data class Entry(val a: Int, val b: Int, val char: Char, val password: String)

val re = Regex("""(\d+)-(\d+) (\w): (\w+)""")

fun String.toEntry(): Entry {
    val (a, b, c, password) = re.find(this)!!.destructured
    return Entry(a.toInt(), b.toInt(), c[0], password)
}

fun Entry.isValid1() =
    password.count { it == char } in a..b

fun part1(input: String): Int =
    input.lineSequence()
        .map { it.toEntry() }
        .count { it.isValid1() }

fun Entry.isValid2() =
    (password[a - 1] == char) xor (password[b - 1] == char)

fun part2(input: String) =
    input.lineSequence()
        .map { it.toEntry() }
        .count { it.isValid2() }
