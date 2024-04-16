package com.library.LibraryManagementSystem.Controller;
import java.util.Random;
public class GenerateRandom
{
    public long getRandom(){
        int minId = 10000;
        int maxId = 99999;
        java.util.Random random = new java.util.Random();
        return random.nextInt(maxId - minId + 1) + minId;
    }
}
