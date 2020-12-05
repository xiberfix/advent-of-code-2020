import java.io.File

fun main() {
    val path = "data/5.txt"
    val input = File(path).readText().trim()
    val result1 = day5.part1(input)
    println(result1)
    val result2 = day5.part2(input)
    println(result2)
}
