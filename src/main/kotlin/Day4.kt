package day4

typealias Record = Map<String, String>

fun String.toRecord(): Record = this
    .splitToSequence(' ', '\n')
    .map { it.split(':') }
    .associate { (name, value) -> name to value }


// Part #1

val fields = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

fun part1(input: String) = input
    .splitToSequence("\n\n")
    .map { it.toRecord() }
    .count { it.keys.containsAll(fields) }


// Part #2

infix fun <A, B, C> ((A) -> B?).then(k: (B) -> C?): (A) -> C? = { a -> this(a)?.let { b -> k(b) } } // fish

fun require(field: String): (Record) -> String? = { it[field] }
fun match(re: Regex): (String) -> MatchResult.Destructured? = { re.matchEntire(it)?.destructured }
fun <T> check(f: (T) -> Boolean): (T) -> Boolean? = { if (f(it)) true else null }

val YEAR = Regex("""(\d{4})""")
val HEIGHT = Regex("""(\d+)(in|cm)""")
val HAIR = Regex("""#([0-9a-f]{6})""")
val EYE = Regex("""(amb|blu|brn|gry|grn|hzl|oth)""")
val ID = Regex("""(\d{9})""")

val checks = listOf(
    require("byr") then match(YEAR) then check { (x) -> x.toInt() in 1920..2002 },
    require("iyr") then match(YEAR) then check { (x) -> x.toInt() in 2010..2020 },
    require("eyr") then match(YEAR) then check { (x) -> x.toInt() in 2020..2030 },
    require("hgt") then match(HEIGHT) then check
    { (x, units) -> units == "cm" && x.toInt() in 150..193 || units == "in" && x.toInt() in 59..76 },
    require("hcl") then match(HAIR),
    require("ecl") then match(EYE),
    require("pid") then match(ID),
)

fun part2(input: String) = input
    .splitToSequence("\n\n")
    .map { it.toRecord() }
    .count { checks.all { check -> check(it) != null } }
