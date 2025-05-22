import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testMainOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            Main.main(new String[]{});
            String output = outContent.toString();

            // Проверяем, что вывод содержит какую-то ожидаемую информацию
            assertTrue(output.contains("Математический факультет"));
            assertTrue(output.contains("Преподаватели"));
            assertTrue(output.contains("Студенты"));
            assertTrue(output.contains("Курсы"));
        } finally {
            System.setOut(originalOut);
        }
    }
}
