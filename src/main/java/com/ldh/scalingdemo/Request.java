package com.ldh.scalingdemo;

public class Request {

    private Flag flag;
    private int seed;

    Request() {}

    Request(Flag flag, int seed) {
        this.flag = flag;
        this.seed = seed;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
    

    
}
