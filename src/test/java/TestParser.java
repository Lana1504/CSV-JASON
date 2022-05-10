import org.junit.jupiter.api.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TestParser extends Main {


    @Test
    @Order(1)
    public void listToJsonTest() {
        String actual = listToJson(new ArrayList<> ());
        assertInstanceOf(String.class, actual);
        assertNotNull(actual);
        System.out.println("Test # 1 listToJson() passed");
    }

    @Test
    @Order(2)
    @Timeout(value = 160, unit = TimeUnit.MILLISECONDS)
    void writeStringTest() throws ParserConfigurationException, IOException, SAXException {

        String expected = listToJson(parseXML("data.xml"));
        String actual = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

        assertTrue(expected.contains("[{"));
        assertNotNull(expected);
        assertNotNull(actual);
        assertInstanceOf(String.class, expected);
        assertInstanceOf(String.class, actual);
        assertThrows(IOException.class, () -> {
            throw new IOException();
        });
        System.out.println("Test # 2 writeString() passed");
    }

    @Test
    @Order(3)
    void parseXMLTest() throws ParserConfigurationException, IOException, SAXException {

        Employee emp1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee emp2 = new Employee(2, "Ivan", "Petrov", "RU", 23);
        List<Employee> expected = new ArrayList<>();
        expected.add(emp1);
        expected.add(emp2);
        List<Employee> actual = parseXML("data.xml");

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).id, actual.get(i).id);
            assertEquals(expected.get(i).firstName, actual.get(i).firstName);
            assertEquals(expected.get(i).lastName, actual.get(i).lastName);
            assertEquals(expected.get(i).country, actual.get(i).country);
            assertEquals(expected.get(i).age, actual.get(i).age);
        }
        assertInstanceOf(List.class, actual);
        assertInstanceOf(List.class, expected);
        assertEquals(expected.size(), 2);
        assertNotSame(expected, actual);
        assertNotEquals(expected, actual);
        assertNotNull(actual);
        assertNotNull(expected);

        System.out.println("Expected " + expected);
        System.out.println("Actual " + actual);
        System.out.println("Test # 3 parseXML() passed");
    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}