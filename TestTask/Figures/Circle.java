package Figures;

public class Circle extends Figure{
    //#region<fields>
    private double firstPoint_x;
    private double firstPoint_y;
    
    private double secondPoint_x;
    private double secondPoint_y;
    //#endregion

    //#region<methods>
    public Circle(String color, double firstPoint_x,double firstPoint_y,double secondPoint_x,double secondPoint_y)
    {
        super("circle",color);
        this.firstPoint_x = firstPoint_x;
        this.firstPoint_y = firstPoint_y;
        this.secondPoint_x = secondPoint_x;
        this.secondPoint_y = secondPoint_y;
    }

    public double radius()
    {
        return Math.sqrt(Math.pow(secondPoint_x-firstPoint_x, 2) + Math.pow(secondPoint_y-firstPoint_y, 2));
    }

    public double area()
    {
        double radius = radius();
        return Math.PI*(radius*radius);
    }

    @Override
    public String toString()
    {
        return "Figure: " + super.getShape()
                +"; radius: "+decimalFormat.format(radius())
                +"; area: " +decimalFormat.format(area())
                +"; color: "+super.getColor()+".";
    }
    //#endregion
}
