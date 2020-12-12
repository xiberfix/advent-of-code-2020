import java.io.File

fun main() {
    val path = "data/10.txt"
    val input = File(path).readText().trim()
    val result1 = day10.part1(input)
    println(result1)
    val result2 = day10.part2(input)
    println(result2)
}
