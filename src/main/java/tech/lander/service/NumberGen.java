package tech.lander.service;
import java.util.Random;

public class NumberGen {
    public Integer getNewRndNum(Integer upperBound){
        Random rand = new Random();
        int n = rand.nextInt(upperBound);
        return n;
    }
}
