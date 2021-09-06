package Figures;

import java.util.Random;

public class RandomFigure {
    private Random random;
    private int r;

    //#region<methods>
    public Circle randomCircle()
    {
        random = new Random();
        r = random.nextInt(4);
        switch(r)
        {
            case 0:
                return new Circle("red",-1,1,5,1);
            case 1:
                return new Circle("magenta",8,0,-5,5);
            case 2:
                return new Circle("black",0,0,0,1);
            default:
                return new Circle("pink",-1,1,15,-3);
        }
    }

    public Square randomSquare()
    {
        random = new Random();
        r = random.nextInt(4);
        switch(r)
        {
            case 0:
                return new Square("blue",0,0,5,5);
            case 1:
                return new Square("grey",-5,5,5,-5);
            case 2:
                return new Square("brown",-2,0,12,-3);
            default:
                return new Square("white",0,1,1,1);
        }
    }

    public Triangle randomTriangle()
    {
        random = new Random();
        r = random.nextInt(4);
        switch(r)
        {
            case 0:
                return new Triangle("purple",-1,-6,-1,-2,2,-6);
            case 1:
                return new Triangle("pink",0,0,-5,5,3,4);
            case 2:
                return new Triangle("purple",4,-2,2,-5,6,-5);
            default:
                return new Triangle("purple",2,1,3,1,2,2);
        }
    }

    public Trapeze randomTrapeze()
    {
        random = new Random();
        r = random.nextInt(4);
        switch(r)
        {
            case 0:
                return new Trapeze("red",-2,-2,-3,1,7,7,3,1);
            case 1:
                return new Trapeze("orange",-2,3,-2,6,0,6,1,3);
            case 2:
                return new Trapeze("green",-8,-1,-6,-2,-6,-3,-8,-4);
            default:
                return new Trapeze("red",3,6,4,6,5,8,2,8);
        }
    }

    public Figure[] randomFigures(int n)
    {

        Figure[] figures = new Figure[n];
        random = new Random();
        System.out.println("Number of elements : "+n);
        for(int i = 0;i < figures.length;i++)
        {
            r = random.nextInt(4)+1;
            switch(r)
            {
                case 1:
                    figures[i] = randomCircle();
                    break;
                case 2:
                    figures[i] = randomSquare();
                    break;
                case 3:
                    figures[i] = randomTriangle();
                    break;
                default:
                    figures[i] = randomTrapeze();
            }
        }
        return figures;
    }
    //#endregion
}
