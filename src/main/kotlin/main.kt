import java.io.File

fun main() {
    val path = "data/4.txt"
    val input = File(path).readText().trim()
    val result1 = day4.part1(input)
    println(result1)
    val result2 = day4.part2(input)
    println(result2)
}
