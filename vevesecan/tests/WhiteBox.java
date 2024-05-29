import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WhiteBox {
    @Test
    public void testInsertCow_NoPairs() {
        List<Animal> animals = List.of(new Mouse(), new Dog(), new Mouse(), new Cow());
        List<Integer> pairs = new ArrayList<>();
        List<Animal> result = Main.InsertCow(new ArrayList<>(animals), pairs);
        assertEquals("Expected no change for no pairs.", animals, result);
    }

    @Test
    public void testInsertCow_SinglePair() {
        List<Animal> animals = List.of(new Mouse(), new Cat());
        List<Integer> pairs = List.of(0);
        List<Animal> expected = List.of(new Mouse(), new Cow(), new Cat());
        List<Animal> result = Main.InsertCow(new ArrayList<>(animals), pairs);
        assertEquals("Expected single cow inserted.", expected, result);
    }

    @Test
    public void testInsertCow_MultiplePairs() {
        List<Animal> animals = List.of(new Mouse(), new Cat(), new Dog(), new Cat());
        List<Integer> pairs = List.of(0, 2);
        List<Animal> expected = List.of(new Mouse(), new Cow(), new Cat(), new Dog(), new Cow(), new Cat());
        List<Animal> result = Main.InsertCow(new ArrayList<>(animals), pairs);
        assertEquals("Expected cows inserted at multiple positions.", expected, result);
    }

    @Test
    public void testInsertCow_PairsAtBeginningAndEnd() {
        List<Animal> animals = List.of(new Mouse(), new Cat(), new Dog(), new Mouse(), new Cat(), new Dog());
        List<Integer> pairs = List.of(0, 4);
        List<Animal> expected = List.of(new Mouse(), new Cow(), new Cat(), new Dog(), new Mouse(), new Cat(), new Cow(), new Dog());
        List<Animal> result = Main.InsertCow(new ArrayList<>(animals), pairs);
        assertEquals("Expected cows inserted at the beginning and end.", expected, result);
    }

    @Test
    public void testInsertCow_ConsecutivePairs() {
        List<Animal> animals = List.of(new Mouse(), new Cat(), new Cat(), new Dog());
        List<Integer> pairs = List.of(0, 1);
        List<Animal> expected = List.of(new Mouse(), new Cow(), new Cat(), new Cow(), new Cat(), new Dog());
        List<Animal> result = Main.InsertCow(new ArrayList<>(animals), pairs);
        assertEquals("Expected cows inserted at consecutive positions.", expected, result);
    }
}
