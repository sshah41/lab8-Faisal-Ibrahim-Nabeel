package edu.luc.cs271.arrayqueue;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SingleQueueService {

  /** Service time per customer in ms. */
  static final int SERVICE_TIME = 5000;

  public static void main(final String[] args) throws InterruptedException {
    // TODO read successive input lines until EOF and try to add them to the queue
    //Scanner s = new Scanner(System.in);
    //private static Deque<String> fillQueue(String args) {
      //Deque<String> queue = new ArrayDeque<>();
      //for (int i = 0; i < queue.size(); i++) {
        //     queue.offer(args.At(i));
      //} return ;     }



      // queue for customer names
      final SimpleQueue<String> queue = new FixedArrayQueue<>(5);
      //while(s.hasNextLine())
        //ueue.offer(s.nextLine());
      // lock object for thread safety
      final Object lock = new Object();

      // background activity for serving customers
      final Thread consumer =
              new Thread(
                      () -> {
                        while (true) {
                          String current;
                          int remaining;
                          synchronized (lock) {
                            current = queue.peek(); // TODO try to take next name from queue done
                            remaining = queue.size(); // TODO determine resulting size of queue done
                          }
                          if (current == null) {
                            System.out.println("no one waiting");
                          } else if (current != null) {
                            System.out.println(current + " is being served, " + remaining + " still waiting");
                          }
                          else
                          {
                            System.out.println("Hello World");
                          }
                          try {
                            Thread.sleep(SERVICE_TIME);
                          } catch (final InterruptedException ex) {
                            return;
                          }
                        }
                      });
      consumer.setDaemon(true);
      consumer.start();

      // foreground activity for reading customer names from input
      final Scanner input = new Scanner(System.in);
      System.out.print("enter next customer: ");

      while (input.hasNextLine()) {
        final String name = input.nextLine();
        boolean result;
        synchronized (lock) {
          result = true; // TODO try to add this name to the queue done
        }
        if (queue.size() < 5) {
          queue.offer(name);
          System.out.println(name + " has joined the queue");
        } else {
          System.out.println("queue full, " + name + " unable to join");
        }
      }
    }
}
