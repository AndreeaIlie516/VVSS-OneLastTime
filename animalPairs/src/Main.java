import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static List<Integer> FindPair(List<Animal> animals) {
        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < animals.size() - 1; i++) {
            int currentId = animals.get(i).getId();
            int nextId = animals.get(i + 1).getId();
            if ((currentId == 1 && nextId == 2) || (currentId == 2 && nextId == 3)) {
                pairs.add(i);
            }
        }
        return pairs;
    }

    public static List<Animal> InsertCow(List<Animal> animals, List<Integer> pairs) {
        for (int i = pairs.size() - 1; i >= 0; i--) {
            animals.add(pairs.get(i) + 1, new Cow());
        }
        return animals;
    }

    public static List<Animal> BeFriends(List<Animal> animals) {
        List<Integer> pairs = FindPair(animals);
        return InsertCow(animals, pairs);
    }

    public static List<Animal> readArray(int[] arr) {
        List<Animal> animals = new ArrayList<>();
        for (int id : arr) {
            switch (id) {
                case 1:
                    animals.add(new Mouse());
                    break;
                case 2:
                    animals.add(new Cat());
                    break;
                case 3:
                    animals.add(new Dog());
                    break;
                case 4:
                    animals.add(new Cow());
                    break;
                default:
                    System.out.println("Invalid animal id: " + id);
                    break;
            }
        }
        return animals;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of animals:");
        int n = scanner.nextInt();
        int[] inputArray = new int[n];

        System.out.println("Enter the animal ids:");
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }
        List<Animal> animals = readArray(inputArray);
        List<Animal> outputArray = BeFriends(animals);

        System.out.print("New array: ");
        for (Animal animal : outputArray) {
            System.out.print(animal.getId() + " ");
        }
    }
}
