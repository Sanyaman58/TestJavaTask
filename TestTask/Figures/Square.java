package Figures;

public class Square extends Figure{
    //#region<fields>
    private double firstPoint_x;
    private double firstPoint_y;
    
    private double secondPoint_x;
    private double secondPoint_y;

    private double sideLength;
    //#endregion

    //#region<methods>
    public double getSideLength() {
        return sideLength;
    }
    
    public Square(String color, double firstPoint_x,double firstPoint_y,double secondPoint_x,double secondPoint_y)
    {
        super("square",color);
        this.firstPoint_x = firstPoint_x;
        this.firstPoint_y = firstPoint_y;
        this.secondPoint_x = secondPoint_x;
        this.secondPoint_y = secondPoint_y;
        calculateSideLength();
    }

    public void calculateSideLength()
    {
        sideLength = Math.sqrt(Math.pow(secondPoint_x-firstPoint_x, 2) + Math.pow(secondPoint_y-firstPoint_y, 2));
    }

    public double area()
    {
        return sideLength*sideLength;
    }

    public double diagonal()
    {
        return sideLength * Math.sqrt(2);
    }

    @Override
    public String toString()
    {
        return "Figure: " + super.getShape()
                +"; side length: "+ decimalFormat.format(sideLength)
                +"; diagonal: "+decimalFormat.format(diagonal())
                +"; area: " +decimalFormat.format(area())
                +"; color: "+super.getColor()+".";
    }
    //#endregion
}
