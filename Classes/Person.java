package Classes;

class Person {
    public String name;
    public int wage;
}

class Player extends Person {
    String posicion;

    public Player(String name, int wage, String posicion) {
        this.name = name;
        this.wage = wage;
        this.posicion = posicion;
    }
}

class Coach extends Person {
    int experience;

    public Coach(String name, int wage, int experience) {
        this.name = name;
        this.wage = wage;
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }
}
