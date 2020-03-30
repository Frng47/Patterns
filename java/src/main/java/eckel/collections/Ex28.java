package eckel.collections;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Ex28  {

    public static void main(String[] args) {
        Random random=new Random();
        PriorityQueue<Double> pq=new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            pq.offer(random.nextDouble()+random.nextInt(10));
        }
        while(pq.peek()!=null) System.out.println(pq.poll());
    }



}

