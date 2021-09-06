package Figures;

import java.text.DecimalFormat;

public class Figure {
    private String shape;
    private String color;
    DecimalFormat decimalFormat = new DecimalFormat("#.###");
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getShape() {
        return shape;
    }
    public String getColor() {
        return color;
    }

    public Figure(String shape, String color)
    {
        this.shape=shape;
        this.color=color;
    }

    @Override
    public String toString()
    {
        return "Figure: " + getShape()
                +"; color: " +getColor()+".";
    }
}
