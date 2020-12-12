import org.junit.Test
import kotlin.test.assertEquals

class Day10Test {
    private val inputSmall = """
        16
        10
        15
        5
        1
        11
        7
        19
        6
        12
        4
    """.trimIndent()

    @Test
    fun testPart1Small() {
        val result = day10.part1(inputSmall)
        assertEquals(35, result)
    }

    @Test
    fun test1Part2Small() {
        val result = day10.part2(inputSmall)
        assertEquals(8, result)
    }

    private val inputLarge = """
        28
        33
        18
        42
        31
        14
        46
        20
        48
        47
        24
        23
        49
        45
        19
        38
        39
        11
        1
        32
        25
        35
        8
        17
        7
        9
        4
        2
        34
        10
        3
    """.trimIndent()

    @Test
    fun testPart1Large() {
        val result = day10.part1(inputLarge)
        assertEquals(220, result)
    }

    @Test
    fun testPart2Large() {
        val result = day10.part2(inputLarge)
        assertEquals(19208, result)
    }
}
