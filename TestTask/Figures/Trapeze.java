package Figures;

public class Trapeze extends Figure{
    //#region<fields>
    private double firstPoint_x;
    private double firstPoint_y;
    
    private double secondPoint_x;
    private double secondPoint_y;
    
    private double thirdPoint_x;
    private double thirdPoint_y;
    
    private double fourthPoint_x;
    private double fourthPoint_y;
    
    private double firstBaseLength;
    private double secondBaseLength;

    private double firstLegLength;
    private double secondLegLength;
    //#endregion

    //#region<get>
    public double getFirstBaseLength() {
        return firstBaseLength;
    }
    public double getSecondBaseLength() {
        return secondBaseLength;
    }
    public double getFirstLegLength() {
        return firstLegLength;
    }
    public double getSecondLegLength() {
        return secondLegLength;
    }
    //#endregion

    //#region<methods>
    public Trapeze(String color,double fi_x,double fi_y,double se_x,double se_y,
                   double th_x,double th_y,double fo_x,double fo_y)
    {
        super("trapeze",color);
        this.firstPoint_x=fi_x;
        this.firstPoint_y=fi_y;
        this.secondPoint_x=se_x;
        this.secondPoint_y=se_y;
        this.thirdPoint_x=th_x;
        this.thirdPoint_y=th_y;
        this.fourthPoint_x=fo_x;
        this.fourthPoint_y=fo_y;
        typeOfTrapeze();
    }

    public void calculateSideLengths(double firstPoint_x, double firstPoint_y, double secondPoint_x, double secondPoint_y,
                                double thirdPoint_x, double thirdPoint_y, double fourthPoint_x, double fourthPoint_y)
    {
        firstBaseLength = Math.sqrt(Math.pow(secondPoint_x-firstPoint_x, 2) + Math.pow(secondPoint_y-firstPoint_y, 2));
        secondBaseLength = Math.sqrt(Math.pow(thirdPoint_x-secondPoint_x, 2) + Math.pow(thirdPoint_y-secondPoint_y, 2));
        firstLegLength = Math.sqrt(Math.pow(fourthPoint_x-thirdPoint_x, 2) + Math.pow(fourthPoint_y-thirdPoint_y, 2));
        secondLegLength = Math.sqrt(Math.pow(firstPoint_x-fourthPoint_x, 2) + Math.pow(firstPoint_y-fourthPoint_y, 2));
    }

    public void typeOfTrapeze()
    {
        try {
            if (((thirdPoint_x - secondPoint_x) * (fourthPoint_y - firstPoint_y)
                    == (fourthPoint_x - firstPoint_x) * (thirdPoint_y - secondPoint_y))
                    || ((secondPoint_x - firstPoint_x) * (thirdPoint_y - fourthPoint_y)
                    == (thirdPoint_x - fourthPoint_x) * (secondPoint_y - firstPoint_y))) {
                if (((secondPoint_x - firstPoint_x) * (thirdPoint_y - fourthPoint_y)
                        == (thirdPoint_x - fourthPoint_x) * (secondPoint_y - firstPoint_y))
                        && ((thirdPoint_x - secondPoint_x) * (fourthPoint_y - firstPoint_y)
                        == (fourthPoint_x - firstPoint_x) * (thirdPoint_y - secondPoint_y))) {
                    throw new Exception();
                } else {
                    if ((this.thirdPoint_x - this.secondPoint_x) * (this.fourthPoint_y - this.firstPoint_y)
                            == (this.fourthPoint_x - this.firstPoint_x) * (this.thirdPoint_y - this.secondPoint_y))
                        calculateSideLengths(firstPoint_x, firstPoint_y, secondPoint_x, secondPoint_y,
                                thirdPoint_x, thirdPoint_y, fourthPoint_x, fourthPoint_y);
                    else
                        calculateSideLengths(secondPoint_x, secondPoint_y, thirdPoint_x, thirdPoint_y,
                                fourthPoint_x, fourthPoint_y, firstPoint_x, firstPoint_y);
                }
            } else {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public double area()
    {
        double a = ((firstBaseLength+secondBaseLength)/2f);
        double b = Math.pow(firstLegLength, 2f);
        double c = Math.pow((Math.pow(firstBaseLength-secondBaseLength,2) + Math.pow(firstLegLength, 2) - Math.pow(secondLegLength,2))
        / (2f*(firstBaseLength-secondBaseLength)),2);
        double d = Math.sqrt(b-c);
        return a*d;
    }
    
    @Override
    public String toString()
    {
        return "Figure: " + super.getShape()
                +"; side lengths: a(base) - " + decimalFormat.format(firstBaseLength) 
                              +", b(base) - " + decimalFormat.format(secondBaseLength)
                              +", c(leg) - " + decimalFormat.format(firstLegLength) 
                              +", d(leg) - " + decimalFormat.format(secondLegLength)
                +"; area: " +decimalFormat.format(area())
                +"; color: "+super.getColor()+".";
    }
    //#endregion
}
