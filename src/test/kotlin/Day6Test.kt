import org.junit.Test
import kotlin.test.assertEquals

class Day6Test {
    private val input = """
        abc

        a
        b
        c

        ab
        ac

        a
        a
        a
        a

        b
    """.trimIndent()

    @Test
    fun testPart1() {
        val result = day6.part1(input)
        assertEquals(11, result)
    }

    @Test
    fun testPart2() {
        val result = day6.part2(input)
        assertEquals(6, result)
    }
}
