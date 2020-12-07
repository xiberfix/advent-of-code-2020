import java.io.File

fun main() {
    val path = "data/7.txt"
    val input = File(path).readText().trim()
    val result1 = day7.part1(input)
    println(result1)
    val result2 = day7.part2(input)
    println(result2)
}
