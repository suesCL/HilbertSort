package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zsu00 on 6/1/2017.
 */
public class HilbertSort {
    //keep track of sorted list
    Queue<Location> sortedList;
    Queue<Location> unsortedList;
    //size of square
    double S;

    public HilbertSort(Queue<Location> List, int sizeOfSpace) {
        this.unsortedList = List;
        S = sizeOfSpace;
        this.sortedList = new LinkedList();

    }

    //helper method to call hilbertSort method
    public Queue<Location> hilbertHelper() {
        hilbertSort(S, unsortedList);
        return sortedList;
    }


    //recursively divides square into quadrants to sort items
    private void hilbertSort(double S, Queue<Location> listToSort) {
        //put all unsorted location into proper quadrant
        Queue<Location> quadrant1 = new LinkedList<Location>();
        Queue<Location> quadrant2 = new LinkedList<Location>();
        Queue<Location> quadrant3 = new LinkedList<Location>();
        Queue<Location> quadrant4 = new LinkedList<Location>();

        while (!listToSort.isEmpty()) {
            Location item = listToSort.remove();
            //check the x,y values of each location and placed it into corresponding quadrant
            if (item.getX() >= 0 && item.getX() <= S / 2 &&
                    0 <= item.getY() && item.getY() <= S / 2) {
                quadrant1.add(item);
                System.out.println("q1");
            } else if (item.getX() >= 0 && item.getX() <= S / 2 &&
                    S/2 <= item.getY() && item.getY() <= S) {
                quadrant2.add(item);
                System.out.println("q2");
            } else if (item.getX() >= S/2 && item.getX() <= S &&
                    S/2 <= item.getY() && item.getY() <= S) {
                quadrant3.add(item);
                System.out.println("q3");
            } else if (item.getX() >= S / 2 && item.getX() <= S &&
                    0 <= item.getY() && item.getY() <= S / 2) {
                quadrant4.add(item);
                System.out.println("q4");
            }
        }


        //visit the quadrant by order to check if there is only one item in the quadrant
        // if true add that item to sorted list
        //otherwise further divide that quadrant till there is only one item in the quadrant
        //put items to sortedList based on 1,2,3,4 quadrant order
        if (quadrant1.size() > 0) {
            System.out.println("enter quadrant1");
            if (quadrant1.size() == 1) {
                sortedList.add(quadrant1.remove());
            } else {
                //iterates through elements to change x, y by rotation;
                for (Location item : quadrant1) {
                    double temp = item.getX();
                     item.setX(item.getY());
                     item.setY(temp);
                }
                hilbertSort(S/2, quadrant1);
            }
        }

        if (quadrant2.size() > 0) {
            System.out.println("enter quadrant1");
            if (quadrant2.size() == 1) {
                sortedList.add(quadrant2.remove());
            } else {
                for (Location item : quadrant2) {
                    item.setY(item.getY() - S/2);
                }
                hilbertSort(S/2, quadrant2);
            }
        }

        if (quadrant3.size() > 0) {
            System.out.println("enter quadrant1");
            if (quadrant3.size() == 1) {
                sortedList.add(quadrant3.remove());
            } else {
                for (Location item : quadrant3) {
                    item.setX(item.getX() - S/2);
                    item.setY(item.getY() - S/2);
                }
                hilbertSort(S/2, quadrant3);
            }
        }

        if (quadrant4.size() > 0) {
            System.out.println("enter quadrant1");
            if (quadrant4.size() == 1) {
                sortedList.add(quadrant4.remove());
            } else {
                //iterates through and change x,y by rotation
                for (Location item : quadrant4) {
                    double temp = item.getY();
                    item.setY(S-item.getX());
                    item.setX(S/2 - temp);
                }
                hilbertSort(S/2, quadrant4);
            }
        }
    }
}

