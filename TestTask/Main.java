import Figures.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Figure[] figures;
        Random random = new Random();
        int n = random.nextInt(8)+5;
        RandomFigure rf = new RandomFigure();
        figures = rf.randomFigures(n);
        for(int i = 0;i < n;i++)
        {
            System.out.println(figures[i].toString());
        }

    }
}
