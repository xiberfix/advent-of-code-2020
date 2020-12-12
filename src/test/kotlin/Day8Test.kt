import org.junit.Test
import kotlin.test.assertEquals

class Day8Test {
    private val input = """
        nop +0
        acc +1
        jmp +4
        acc +3
        jmp -3
        acc -99
        acc +1
        jmp -4
        acc +6
    """.trimIndent()

    @Test
    fun testPart1() {
        val result = day8.part1(input)
        assertEquals(5, result)
    }

    @Test
    fun testPart2() {
        val result = day8.part2(input)
        assertEquals(8, result)
    }
}
