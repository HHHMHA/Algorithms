package collections;

import java.util.Objects;

public class ColoredNode implements NodeProperty {
    public Color getColor() {
        return color;
    }

    private final Color color;

    public ColoredNode(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredNode that = (ColoredNode) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public Object getValue() {
        return this.getColor();
    }

    public static ColoredNode Black() {
        return new ColoredNode(Color.BLACK);
    }

    public static ColoredNode Red() {
        return new ColoredNode(Color.RED);
    }
}
