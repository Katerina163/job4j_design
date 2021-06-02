package ru.job4j.ood.lsp.explanation;

public class AutoTransport {
    private float fuel;

    public AutoTransport(float fuel) {
        this.fuel = fuel;
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 0) { // <= предусловие
            throw new IllegalArgumentException("Need more fuel!");
        }
        // other logic
    }
}
