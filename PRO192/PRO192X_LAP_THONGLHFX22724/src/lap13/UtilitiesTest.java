package lap13;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @org.junit.jupiter.api.Test
    void removePairs() {
        Utilities util = new Utilities();

        // Test case 1: ABBCDEEF -> ABCDEF
        assertEquals("ABCDEF", util.removePairs("ABBCDEEF")); // Kiểm tra kết quả mong đợi

        // Test case 2: ABCBDEEF -> ABCBDEF
        assertEquals("ABCBDEF", util.removePairs("ABCBDEEF")); // Kiểm tra kết quả mong đợi
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        Utilities util = new Utilities();

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
        fail("Not yet implemented");
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        Utilities util = new Utilities();

        // Case 1: Length is even
        String input1 = "even";
        assertNotNull(util.nullIfOddLength(input1));
        assertEquals("even", util.nullIfOddLength(input1));

        // Case 2: Length is odd
        String input2 = "odd";
        assertNull(util.nullIfOddLength(input2));
    }
}