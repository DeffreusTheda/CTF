package tspSolver;

import java.util.ArrayList;

public class MatrixCreator {
    private static int[][] m;
    private int size;

    public MatrixCreator(){
        ArrayList<City> cityList = City.getCityList();
        this.size = cityList.size();
        m = new int[size][size];
        for(int i = 0; i<size; i++)
            for (int j=0; j<size; j++)
                m[i][j] = computeDistance(cityList.get(i), cityList.get(j));
    }
    public static int computeDistance(City city1, City city2){
        int x1 = city1.getX_coord();
        int y1 = city1.getY_coord();
        int x2 = city2.getX_coord();
        int y2 = city2.getY_coord();
        double dist = Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
        dist = Math.round(Math.sqrt(dist));
        return (int) dist;
    }


    public void printMatrix(){
        for(int i = 0; i<size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] getM() {
        return m;
    }

    public static void setM(int[][] m) {
        MatrixCreator.m = m;
    }
}
