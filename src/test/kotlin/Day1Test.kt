import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {
    private val input = """
        1721
        979
        366
        299
        675
        1456
    """.trimIndent()

    @Test
    fun testPart1() {
        val result = day1.part1(input)
        assertEquals(514579, result)
    }

    @Test
    fun testPart2() {
        val result = day1.part2(input)
        assertEquals(241861950, result)
    }
}
