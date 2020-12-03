import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {
    private val input = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent()

    @Test
    fun testPart1() {
        val result = day3.part1(input)
        assertEquals(7, result)
    }

    @Test
    fun testPart2() {
        val result = day3.part2(input)
        assertEquals(336, result)
    }
}
