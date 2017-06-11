package com.company;

/**
 * Created by zsu00 on 6/1/2017.
 */
public class Location {
    private double x;
    private double y;
    private String name;

    public Location(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public String getName(){
        return this.name;
    }



}
