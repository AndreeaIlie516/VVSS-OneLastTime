abstract class Animal {
    int id;

    public Animal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Mouse extends Animal {
    public Mouse() {
        super(1);
    }
}