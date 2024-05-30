import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class BBTest {
    @Test
    public void testFindPair_EmptyArray() {
        List<Animal> animals = new ArrayList<>();
        List<Integer> result = Main.FindPair(animals);
        assertTrue("Expected empty result for empty array.", result.isEmpty());
    }

    @Test
    public void testFindPair_SinglePairMouseCat() {
        List<Animal> animals = List.of(new Mouse(), new Cat());
        List<Integer> result = Main.FindPair(animals);
        assertEquals("Expected single pair at index 0.", List.of(0), result);
    }

    @Test
    public void testFindPair_SinglePairCatDog() {
        List<Animal> animals = List.of(new Cat(), new Dog());
        List<Integer> result = Main.FindPair(animals);
        assertEquals("Expected single pair at index 0.", List.of(0), result);
    }

    @Test
    public void testFindPair_NoPairs() {
        List<Animal> animals = List.of(new Mouse(), new Dog(), new Mouse(), new Cow());
        List<Integer> result = Main.FindPair(animals);
        assertTrue("Expected no pairs.", result.isEmpty());
    }

    @Test
    public void testFindPair_PairAtBeginningAndEnd() {
        List<Animal> animals = List.of(new Mouse(), new Cat(), new Dog(), new Mouse(), new Cat(), new Dog());
        List<Integer> result = Main.FindPair(animals);
        assertEquals("Expected pairs at indices 0, 1, 3, and 4.", List.of(0, 1, 3, 4), result);
    }

    @Test
    public void testFindPair_MultiplePairs() {
        List<Animal> animals = List.of(new Mouse(), new Cat(), new Cat(), new Dog(), new Mouse(), new Cat(), new Dog(), new Cat());
        List<Integer> result = Main.FindPair(animals);
        assertEquals("Expected pairs at indices 0, 2, 4, and 5.", List.of(0, 2, 4, 5), result);
    }

    @Test
    public void testFindPair_InvalidIDs() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Mouse());
        animals.add(new Animal(5) {}); // invalid animal id
        animals.add(new Cat());
        animals.add(new Animal(0) {}); // invalid animal id
        animals.add(new Dog());

        List<Integer> result = Main.FindPair(animals);
        assertTrue("Expected no pairs due to invalid IDs.", result.isEmpty());
    }
}
