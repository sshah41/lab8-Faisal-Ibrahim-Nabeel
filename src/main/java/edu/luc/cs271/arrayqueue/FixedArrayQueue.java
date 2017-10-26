package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // TODO why do we need an explicit constructor?

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    // TODO done
    if (size==capacity){
      System.out.println("Queue is at capacity, please try again later");
      return false;
    }
    else{

      rear = (rear + 1) % capacity;
      data[rear] = obj;
      return true;

    }
  }

  @Override
  public E peek() {
    // TODO done
    if (isEmpty()) {
      return null;
    } else {
      return data[front];
    }
    //return null;
  }

  @Override
  public E poll() {
    // TODO done
    if (isEmpty()) {
      return null;
    } else {
      E result = data[front];
      front = front+1;
      return result;
    }
   // return null;
  }

  @Override
  public boolean isEmpty() {
    // TODO done
    if(this.front==0){
    return true;}
    else return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // TODO implement using an ArrayList preallocated with the right size
    List<E> list = new ArrayList<>(5 );
    return Arrays.asList();
  }
}
