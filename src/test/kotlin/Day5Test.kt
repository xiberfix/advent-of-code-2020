import org.junit.Test
import kotlin.test.assertEquals

class Day5Test {
    @Test
    fun testId() {
        assertEquals(357, day5.id("FBFBBFFRLR"))
        assertEquals(567, day5.id("BFFFBBFRRR"))
        assertEquals(119, day5.id("FFFBBBFRRR"))
        assertEquals(820, day5.id("BBFFBBFRLL"))
    }
}
