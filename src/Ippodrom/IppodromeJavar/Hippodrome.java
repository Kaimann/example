package Ippodrom.IppodromeJavar;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> h) {
        horses = h;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int d = 0;
        Horse winner = horses.get(0);
        for (Horse h : horses) {
            if (h.distance > d) {
                winner = h;
                d = (int) h.distance;
            }
        }

        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) {
        ArrayList<Horse> hrss = new ArrayList<>();
        hrss.add(new Horse("One", 3, 0));
        hrss.add(new Horse("Two", 3, 0));
        hrss.add(new Horse("Three", 3, 0));
        hrss.add(new Horse("Four", 3, 0));
        game = new Hippodrome(hrss);

        game.run();
        game.printWinner();
    }
}
