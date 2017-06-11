package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("HilbertSort-2000.in"));
        //extract S the size of square from the first line
        int S = 0;
        if (scanner.hasNextLine()) {
            Scanner tokenScan = new Scanner(scanner.nextLine());
            tokenScan.nextInt();
            S = tokenScan.nextInt();
            System.out.println("size is " + S);
        }

        //extract locations from the rest of lines
        Queue<Location> list1 = new LinkedList<Location>();
        list1 = input(scanner);
        System.out.println("location list size is " + list1.size());

        //call hilbert sort class to sort the list
        HilbertSort sort = new HilbertSort(list1, S);
        Queue<Location> sortedList = sort.hilbertHelper();
        Queue<String> outputName = new LinkedList<>();

        //print out names for sorted location of interest
        while (!sortedList.isEmpty()) {
            outputName.add(sortedList.remove().getName());
        }
        System.out.println("Sorted locations using hilbert sort are " + outputName);
        System.out.println("test output is " + getOutput());
        System.out.println("Hilbert sort list matches output file: " + outputName.equals(getOutput()));
    }

    public static LinkedList input(Scanner scanner) {
        LinkedList<Location> list = new LinkedList<Location>();
        //read line by line and store location info in object called Location
        //put all location of interest in queue
        //extract each location info
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner token = new Scanner(line);
            Location location = new Location(token.nextInt(), token.nextInt(), token.next());
            list.add(location);
        }

        //return list of objects
        return list;
    }

    public static LinkedList getOutput() throws FileNotFoundException {
        LinkedList<String> outputList = new LinkedList<String>();
        //read line by line and store location name
        //put all location  of interest in queue
        Scanner lineScan = new Scanner(new File("HilbertSort-2000.out"));
        while (lineScan.hasNext()) {
            String name = lineScan.next();
            outputList.add(name);
        }
        //return name list
        return outputList;
    }


}

