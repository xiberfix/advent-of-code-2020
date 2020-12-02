import org.junit.Test
import kotlin.test.assertEquals

class Day2Test {
    private val input = """
        1-3 a: abcde
        1-3 b: cdefg
        2-9 c: ccccccccc
    """.trimIndent()

    @Test
    fun testPart1() {
        val result = day2.part1(input)
        assertEquals(2, result)
    }

    @Test
    fun testPart2() {
        val result = day2.part2(input)
        assertEquals(1, result)
    }
}
