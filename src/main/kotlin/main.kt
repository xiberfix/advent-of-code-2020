import java.io.File

fun main() {
    val path = "data/2.txt"
    val input = File(path).readText().trim()
    val result1 = day2.part1(input)
    println(result1)
    val result2 = day2.part2(input)
    println(result2)
}
