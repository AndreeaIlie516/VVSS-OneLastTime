import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class IntegrationTest {

    @Test
    public void testBeFriends_FindPair() {
        List<Animal> animals = List.of(new Mouse(), new Cat(), new Dog(), new Mouse(), new Cat(), new Dog());
        List<Integer> result = Main.FindPair(new ArrayList<>(animals));
        List<Integer> expected = List.of(0, 1, 3, 4);
        assertEquals("Expected pairs at indices 0, 1, 3, and 4.", expected, result);
    }

    @Test
    public void testBeFriends_BeFriends() {
        List<Animal> animals = List.of(new Mouse(), new Cat(), new Dog(), new Mouse(), new Cat(), new Dog());
        List<Animal> result = Main.BeFriends(new ArrayList<>(animals));
        List<Animal> expected = List.of(new Mouse(), new Cow(), new Cat(), new Cow(), new Dog(), new Mouse(), new Cow(), new Cat(), new Cow(), new Dog());
        assertEquals("Expected cows at indices 1, 3, 6, 8", expected, result);
    }
}
