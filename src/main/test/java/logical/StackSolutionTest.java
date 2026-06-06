package logical;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackSolutionTest {

    @DisplayName("push and pop should behave as LIFO")
    @Test
    void shouldPopMostRecentlyPushedElementFirst() {
        Stack stack = new Stack();

        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(-1, stack.pop());
    }

    @DisplayName("pop on empty stack returns -1 and later pushes still work")
    @Test
    void shouldReturnMinusOneForEmptyStackAndContinueProcessing() {
        Stack stack = new Stack();

        assertEquals(-1, stack.pop());

        stack.push(7);
        assertEquals(7, stack.pop());

        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(-1, stack.pop());
    }

    @DisplayName("main should produce expected output for sample input one")
    @Test
    void shouldMatchSampleOutputOne() throws Exception {
        String input = String.join(System.lineSeparator(),
                "5",
                "1 2",
                "1 3",
                "2",
                "2",
                "1 8"
        ) + System.lineSeparator();

        List<String> outputLines = runMainAndCollectTrimmedOutputLines(input);

        assertEquals(List.of("3", "2"), outputLines);
    }

    @DisplayName("main should produce expected output for sample input two")
    @Test
    void shouldMatchSampleOutputTwo() throws Exception {
        String input = String.join(System.lineSeparator(),
                "6",
                "2",
                "1 7",
                "2",
                "1 3",
                "1 4",
                "2"
        ) + System.lineSeparator();

        List<String> outputLines = runMainAndCollectTrimmedOutputLines(input);

        assertEquals(List.of("-1", "7", "4"), outputLines);
    }

    private List<String> runMainAndCollectTrimmedOutputLines(String input) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();

        try {
            System.setIn(testIn);
            System.setOut(new PrintStream(testOut, true, StandardCharsets.UTF_8));

            StackSolution.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return Arrays.stream(testOut.toString(StandardCharsets.UTF_8).split("\\R"))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .toList();
    }
}
