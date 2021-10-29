package lesson14;

import java.io.*;

class Droid implements Serializable{
    private String name;
    private int move;
    private double health;

    public Droid(){}

    public String toCsvString() {
        return name + ';' +
                move + ';' +
                health;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", move=" + move +
                ", health=" + health +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Droid(String name, int move, double health) {
        this.name = name;
        this.move = move;
        this.health = health;
    }
}

public class ProgramSer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Droid d1 = new Droid("R2D2", 10, 90);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("droid.dat"))) {
            oos.writeObject(d1);
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("droid.dat"))) {
            Droid d2 = (Droid) ois.readObject();
            System.out.println(d2);
        }

    }
}
