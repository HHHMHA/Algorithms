package data_structs.trees.node;

import data_structs.common.Color;

import java.util.Objects;

public class ColoredNode implements NodeProperty {
    public Color getColor() {
        return color;
    }
    private static final ColoredNode BLACK = new ColoredNode(Color.BLACK);
    private static final ColoredNode RED = new ColoredNode(Color.RED);

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
        return ColoredNode.BLACK;
    }

    public static ColoredNode Red() {
        return ColoredNode.RED;
    }
}
