package Figures;

public class Triangle extends Figure{
    //#region<fields>
    private double firstPoint_x;
    private double firstPoint_y;
    
    private double secondPoint_x;
    private double secondPoint_y;
    
    private double thirdPoint_x;
    private double thirdPoint_y;

    private double firstSide;
    private double secondSide;
    private double thirdSide;
    protected String triangleType;
    //#endregion
    
    //#region<get>
    public double getFirstSide() {
        return firstSide;
    }
    public double getSecondSide() {
        return secondSide;
    }
    public double getThirdSide() {
        return thirdSide;
    }
    //#endregion

    //#region<methods>
    public Triangle(String color, double firstPoint_x,double firstPoint_y,double secondPoint_x,double secondPoint_y,double thirdPoint_x,double thirdPoint_y)
    {
        super("triangle", color);
        this.firstPoint_x = firstPoint_x;
        this.firstPoint_y = firstPoint_y;
        this.secondPoint_x = secondPoint_x;
        this.secondPoint_y = secondPoint_y;
        this.thirdPoint_x = thirdPoint_x;
        this.thirdPoint_y = thirdPoint_y;
        calculateSideLength();
    }

    public void calculateSideLength()
    {
        firstSide = Math.sqrt(Math.pow(secondPoint_x-firstPoint_x, 2) + Math.pow(secondPoint_y-firstPoint_y, 2));
        secondSide= Math.sqrt(Math.pow(thirdPoint_x-secondPoint_x, 2) + Math.pow(thirdPoint_y-secondPoint_y, 2));
        thirdSide= Math.sqrt(Math.pow(firstPoint_x-thirdPoint_x, 2) + Math.pow(firstPoint_y-thirdPoint_y, 2));
    }

    public String identifyType()
    {
        triangleType="";
        if((firstSide == secondSide) && (secondSide == thirdSide) && (firstSide == thirdSide))
            triangleType += "equilateral";
        else if((firstSide == secondSide) || (secondSide == thirdSide) || (firstSide == thirdSide))
            triangleType += "isosceles";
        else
            triangleType += "scalene";

        if((Math.pow(firstSide, 2) + (Math.pow(secondSide, 2)) == (Math.pow(thirdSide, 2)))
        || (Math.pow(secondSide, 2) + (Math.pow(thirdSide, 2)) == (Math.pow(firstSide, 2)))
        || (Math.pow(firstSide, 2) + (Math.pow(thirdSide, 2)) == (Math.pow(secondSide, 2))))
            triangleType += ", right"; 
        return triangleType;
    }

    public double halfPerimeter()
    {
        return (0.5f)*(firstSide+secondSide+thirdSide);
    }

    public double circumscribedCircleRadius()
    {
        double p = halfPerimeter();
        return (firstSide*secondSide*thirdSide)
        /(4*Math.sqrt(p*(p-firstSide)*(p-secondSide)*(p-thirdSide)));
    }

    public double area()
    {
        return (firstSide*secondSide*thirdSide)
                /(4*circumscribedCircleRadius());
    }

    @Override
    public String toString()
    {
        return "Figure: " + super.getShape()
                +"; side lengths: a - "+ decimalFormat.format(firstSide)
                +", b - " + decimalFormat.format(secondSide)
                +", c - " + decimalFormat.format(thirdSide)
                +"; triangle type: "+identifyType()
                +"; area: "+decimalFormat.format(area())
                +"; color: "+super.getColor()+".";
    }
    //#endregion
}
