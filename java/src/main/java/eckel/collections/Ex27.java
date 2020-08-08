package eckel.collections;

import java.util.*;

public class Ex27 {
    public static void main(String[] args) {
        Ex27.consumeQueue(Filler.fill(Arrays.asList(new Command("Turn ON"),new Command("Turn OFF"))));
    }
    static void consumeQueue(Queue<Command> queue){
        /*for(Command item:queue){
           item.operation();
        }*/
        /*for(Command item){
            queue.peek().operation();
        }*/
        while(queue.peek()!=null){
            queue.poll().operation();
        }
    }
}
class Command{
    public Command(String string){
        this.string=string;
    }
    String string;
    void operation(){
        System.out.println(string);
    }
}
class Filler{
    public static Queue<Command> fill(List<Command> list){
        Queue<Command> queue=new LinkedList<>();

        for(Command item:list){
            queue.offer(item);
        }
      return queue;
    };
}