package lap13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private Utilities util;

    @BeforeEach
    public void setup() {
        util = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void removePairs() {

        // Test case 1: ABBCDEEF -> ABCDEF
        assertEquals("ABCDEF", util.removePairs("ABBCDEEF")); // Kiểm tra kết quả mong đợi

        // Test case 2: ABCBDEEF -> ABCBDEF
        assertEquals("ABCBDEF", util.removePairs("ABCBDEEF")); // Kiểm tra kết quả mong đợi
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {

        // Case 1: n = 2
        char[] input1 = {'h', 'e', 'l', 'l', 'o'};
        char[] expected1 = {'e', 'l'};
        assertArrayEquals(expected1, util.everyNthChar(input1, 2));

        // Case 2: n > array length
        char[] input2 = {'h', 'e', 'l', 'l', 'o'};
        assertArrayEquals(input2, util.everyNthChar(input2, 10));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertThrows(ArithmeticException.class, () -> util.converter(10, 0));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {

        // Case 1: Length is even
        String input1 = "even";
        assertNotNull(util.nullIfOddLength(input1));
        assertEquals("even", util.nullIfOddLength(input1));

        // Case 2: Length is odd
        String input2 = "odd";
        assertNull(util.nullIfOddLength(input2));
    }

    @ParameterizedTest
    @CsvSource({
            "'ABCDEFF', 'ABCDEF'",
            "'AB88EFFG', 'AB8EFG'",
            "'112233445566', '123456'",
            "'ZYZQQB', 'ZYZQB'",
            "'A', 'A'"
    })
    public void testRemovePairs(String input, String expected) {
        assertEquals(expected, util.removePairs(input));
    }
}