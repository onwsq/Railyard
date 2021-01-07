/**
 * Railyard class represents a railyard made of classification yards, with tracks to sort the cars on a train
 * 
 * @author Olivia Weng 
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class RailYard<T extends Comparable<? super T>>{
  //number of tracks per yard
  private int[] numTracks;
  //string of cars, a train
  private String[] cars;
  //car String
  private String car;
  //linked list = the tracks, within an arraylist = each yard, within an arraylist = overall railyard
  private ArrayList<ArrayList<LinkedList<T>>> yardlist;
  
  
  
  /**constructor
    * @param int array showing number of tracks per classification yard
    */
  public RailYard(int[] numTracks){
    yardlist = new ArrayList<ArrayList<LinkedList<T>>>();
    //creates an arraylist for each classification yard within railyard
    for(int i = 0; i < numTracks.length; i++){
      yardlist.add(i, new ArrayList<LinkedList<T>>());
      //creates a linkedlist for each track within classification yard
      for(int j = 0; j < numTracks[i]; j++){
        yardlist.get(i).add(new LinkedList<T>());
      }
    }
  }
  
  
  /**main method
    * @param string[] args for the main method
    */
  public static void main(String[] args){
    
    //parsing command line arguments
    try{
      int numYards = 0;
      int[] numTracks;
      String[] cars;
      
      String method = args[0];
      numYards = Integer.parseInt(args[1]);
      numTracks = new int[numYards];
      RailYard<String> yard = new RailYard<String>(numTracks);
      
      for(int i = 0; i < numYards; i++){
        numTracks[i] = Integer.parseInt(args[i + 2]);
      }
      cars = new String[args.length - numYards - 2];
      for(int i = 0; i <args.length - numYards - 2; i++){
        cars[i] = args[i + numYards + 2];
      }
      if(method.equals("cycle")){
        yard = new RailYard<String>(numTracks);
        yard.cycleSort(cars);
        System.out.println("cycle sort "+Arrays.toString(cars));
      }
      else if (method.equals("closest")){
        yard = new RailYard<String>(numTracks);
        yard.closestSort(cars);
        System.out.println("closest sort "+Arrays.toString(cars));
    }
      System.out.println(numYards);
      System.out.println(Arrays.toString(numTracks));
      System.out.println(Arrays.toString(cars));
      
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("invalid argument");
    }
  }
  
  
  /**sorts the train array using cyclesort through one classification yard
    * @param int yardIndex which classificaton yard
    * @param array of a train
    */
  public void oneCycleSort(int yardIndex, T[] train){
    int lane = 0;
    
    if(yardlist.get(yardIndex).isEmpty() == true){
      return;
    }
    
    //get the array that signifies first yard, get first linked list within array and add train
    yardlist.get(yardIndex).get(0).add(train[0]);
    
    //looping through the entire train
    for(int j = 1; j < train.length; j++){
      
      //if next car is greater than or equal to last car
      if(train[j].compareTo(train[j-1]) >= 0){
        
        //if current lane is less than number tracks
        if(lane >= yardlist.get(yardIndex).size()){
          lane = 0;
        }
      }
      else{
        lane++;
        if(lane >= yardlist.get(yardIndex).size()){
          lane = 0;
        }
      }
      //get the linked list at lane value and add car
      yardlist.get(yardIndex).get(lane).add(train[j]);
    }
    System.out.println("cycle sort"+yardlist.get(yardIndex).toString());
  }
  
  
  
  /**sorts the train list using cyclesort through one classification yard
    * @param int yardIndex which classification yard
    * @param list train
    */
  public void oneCycleSort(int yardIndex, List<T> train){
    int lane = 0;
    int i = 1;
    int count = 0;
    T carVal;
    
    //set previous car value as first
    ListIterator<T> iterator = train.listIterator();
    T lastCarVal = iterator.next();
    iterator = train.listIterator(0);

    if(yardlist.get(yardIndex).isEmpty() == true){
      return;
    } 
    //looping through the entire train
    while(iterator.hasNext()){

      carVal = iterator.next(); //sets next car at next value
      
      //if next car is greater than or equal to last car
      if(carVal.compareTo(lastCarVal) >= 0){
          //if current lane is less than number tracks
        if(lane >= yardlist.get(yardIndex).size()){
          lane = 0;
        }
      }
      else{
        lane++;
        if(lane >= yardlist.get(yardIndex).size()){
          lane = 0;
        }
      }
      //get the linked list at lane value and add car value
      yardlist.get(yardIndex).get(lane).add(carVal);
      //update last car value to next car value
      lastCarVal = carVal;
    }
    System.out.println("cycle sort list"+yardlist.get(yardIndex).toString());
  }
  
  
  
  /**merges the car values from the tracks to the train
    * @param int yardIndex which classification yard
    * @param array of a train
    */
  public void mergeForArray(int yardIndex, T[] outTrain){
    int trainIndex = 0;
    int minTrackIndex = 0;
    int trackIndex = 0;
    T minimumVal;
    
    Arrays.fill(outTrain, null);
    //goes through each track and makes sure it is empty
    while(trackIndex < yardlist.get(yardIndex).size() ||
          (trackIndex < yardlist.get(yardIndex).size() && yardlist.get(yardIndex).get(trackIndex).isEmpty() == false)){
      
      //because of the or condition
      if(yardlist.get(yardIndex).get(trackIndex).peekFirst() == null){
        trackIndex++;
        continue;
      }
      
      minimumVal = yardlist.get(yardIndex).get(trackIndex).peekFirst();
      minTrackIndex = trackIndex;
      
      //loop through all tracks to find minimum value
      for(int j = trackIndex; j < yardlist.get(yardIndex).size(); j++){
        if(yardlist.get(yardIndex).get(j).peekFirst() != null){
          if (minimumVal.compareTo(yardlist.get(yardIndex).get(j).getFirst()) > 0){
            minimumVal = yardlist.get(yardIndex).get(j).getFirst();
            minTrackIndex = j;
          }
        }
        else{
          continue;
        }
      }
      //remove minimum and add to new train
      outTrain[trainIndex] = minimumVal;
      yardlist.get(yardIndex).get(minTrackIndex).removeFirst();
      trainIndex++;
      
      //if track is empty, move on to next one
      if(yardlist.get(yardIndex).get(trackIndex).isEmpty() == true){
        trackIndex++;
      }
    }
    System.out.println("merge result "+Arrays.toString(outTrain));
  } 
  
  
    /**merges the car values from the tracks to the train
    * @param int yardIndex which classification yard
    * @param list of a train
    */
  public void mergeForList(int yardIndex, List<T> outTrain){
    int trainIndex = 0;
    int minTrackIndex = 0;
    int trackIndex = 0;
    T minimumVal;
    
    outTrain.clear();

    //goes through each track and makes sure it is empty
    while(trackIndex < yardlist.get(yardIndex).size() ||
          (trackIndex < yardlist.get(yardIndex).size() && yardlist.get(yardIndex).get(trackIndex).isEmpty() == false)){
      
      //bc of the or
      if(yardlist.get(yardIndex).get(trackIndex).peekFirst() == null){
        trackIndex++;
        continue;
      }
      
      minimumVal = yardlist.get(yardIndex).get(trackIndex).peekFirst();
      minTrackIndex = trackIndex;
      
      //loop through all tracks to find minimum value
      for(int j = trackIndex; j < yardlist.get(yardIndex).size(); j++){
        if(yardlist.get(yardIndex).get(j).peekFirst() != null){
          if (minimumVal.compareTo(yardlist.get(yardIndex).get(j).getFirst()) > 0){
            minimumVal = yardlist.get(yardIndex).get(j).getFirst();
            minTrackIndex = j;
          }
        }
        else{
          continue;
        }
      }
      //remove minimum and add to new train
      outTrain.add(minimumVal);
      yardlist.get(yardIndex).get(minTrackIndex).removeFirst();
      trainIndex++;
      
      //if track is empty, move on to next one
      if(yardlist.get(yardIndex).get(trackIndex).isEmpty() == true){
        trackIndex++;
      }
    }
    System.out.println("merge result "+Arrays.toString(outTrain.toArray()));
  } 
  
  
  /**cycle sorts entire train through all classification yards
    * @param array of train to sort
    */
  public void cycleSort(T[] train){
    int yardIndex = 0;
    
    for(yardIndex = 0; yardIndex < yardlist.size(); yardIndex++){
      this.oneCycleSort(yardIndex, train);
      System.out.println("cycle sort one yard "+yardlist.get(yardIndex).toString());
      this.mergeForArray(yardIndex, train);
    }
    
  }
  
  
  
    /**cycle sorts entire train through all classification yards
    * @param list of train to sort
    */
  public void cycleSort(List<T> train){
    int yardIndex = 0;
    
    for(yardIndex = 0; yardIndex < yardlist.size(); yardIndex++){
      this.oneCycleSort(yardIndex, train);
      System.out.println("cycle sort one yard "+yardlist.get(yardIndex).toString());
      this.mergeForList(yardIndex, train);
    }
    
  }
  
  
  
  /**sorts train with closestsort method through one classification yard
    * @param int yardIndex which classification yard
    * @param array of a train
    */
  public void oneClosestSort(int yardIndex, T[] train){
    T maximumVal;
    T minimumVal;
    int trackIndex = 0;
    int maxValIndex = -1;
    int minValIndex = -1;
    int trainIndex = 1;
    int emptyIndex = -1;
    int findMinIndex = -1;
    T minTrain;
    
    if(yardlist.get(yardIndex).isEmpty() == true){
      return;
    }
    yardlist.get(yardIndex).get(0).add(train[0]);
    
    //find minimum of train
    minTrain = train[0];
    for(int j = 0; j < train.length; j++){
      if(minTrain.compareTo(train[j]) >= 0){
        minTrain = train[j];
      }
    }
    
    //looping through the entire train
    for(trainIndex = 1; trainIndex < train.length; trainIndex++){
      maximumVal = minTrain;
      minimumVal = yardlist.get(yardIndex).get(0).getLast();
      minValIndex = -1;
      maxValIndex = -1;
      emptyIndex = -1;
      
      //MAXIMUM AND MINIMUM
      //looping through all the tracks to find max value that is still less than car value, and min val
      for(int j = trackIndex; j < yardlist.get(yardIndex).size(); j++){
        //if lane is not empty
        if(yardlist.get(yardIndex).get(j).peekLast() != null){
          //if min val is greater than current lane
          if(minimumVal.compareTo(yardlist.get(yardIndex).get(j).getLast()) > 0){
            //lane value is set to new min
            minimumVal = yardlist.get(yardIndex).get(j).getLast();
            minValIndex = j;
          } 
          //if current lane is less than value of car
          if(yardlist.get(yardIndex).get(j).getLast().compareTo(train[trainIndex]) < 0){
            // if current lane is greater than value of current max
            if(yardlist.get(yardIndex).get(j).getLast().compareTo(maximumVal) >= 0){
              maximumVal = yardlist.get(yardIndex).get(j).getLast();
              maxValIndex = j;
            }
          }
          
        }
        else{
          if(emptyIndex == -1){
            emptyIndex = j;
          }
        }
      }
      if(maxValIndex != -1){
        yardlist.get(yardIndex).get(maxValIndex).add(train[trainIndex]);
      } else if(emptyIndex != -1 && maxValIndex == -1){
        yardlist.get(yardIndex).get(emptyIndex).add(train[trainIndex]);
      } else if(minValIndex != -1 && maxValIndex == -1){
          yardlist.get(yardIndex).get(minValIndex).add(train[trainIndex]);
        }
      else{
          System.out.println("error: "+"maxValIndex "+maxValIndex+
                             "\nminValIndex "+minValIndex+
                             "\nemptyIndex "+emptyIndex);
        }
    }
    System.out.println("closest sort"+yardlist.get(yardIndex).toString());
  }
  
  
  
   /**sorts train with closestsort method through one classification yard
    * @param int yardIndex which classification yard
    * @param array of a train
    */
  public void oneClosestSort(int yardIndex, List<T> train){
    T maximumVal;
    T minimumVal;
    int trackIndex = 0;
    int maxValIndex = -1;
    int minValIndex = -1;
    int trainIndex = 1;
    int emptyIndex = -1;
    int findMinIndex = -1;
    T minTrain;
    
    //if there are no tracks
    if(yardlist.get(yardIndex).isEmpty() == true){
      return;
    }
    
    ListIterator<T> iterator = train.listIterator();
    //get the array that signifies first yard, get first linked list within array and add train
    yardlist.get(yardIndex).get(0).add(iterator.next());
    iterator = train.listIterator(0);
    
    //find minimum of train
    minTrain = iterator.next();
      while(iterator.hasNext()){
      if(minTrain.compareTo(iterator.next()) >= 0){
        minTrain = iterator.next();
      }
    }
    
    iterator = train.listIterator(0);
    //looping through the entire train
    while(iterator.hasNext()){
      maximumVal = minTrain;
      minimumVal = yardlist.get(yardIndex).get(0).getLast();
      minValIndex = -1;
      maxValIndex = -1;
      emptyIndex = -1;
      
      //MAXIMUM AND MINIMUM
      //looping through all the tracks to find max value that is still less than car value, and min val
      for(int j = trackIndex; j < yardlist.get(yardIndex).size(); j++){
        //if lane is not empty
        if(yardlist.get(yardIndex).get(j).peekLast() != null){
          //if min val is greater than current lane
          if(minimumVal.compareTo(yardlist.get(yardIndex).get(j).getLast()) > 0){
            //lane value is set to new min
            minimumVal = yardlist.get(yardIndex).get(j).getLast();
            minValIndex = j;
          } 
          //if current lane is less than value of car
          if(yardlist.get(yardIndex).get(j).getLast().compareTo(iterator.next()) < 0){
            // if current lane is greater than value of current max
            if(yardlist.get(yardIndex).get(j).getLast().compareTo(maximumVal) >= 0){
              maximumVal = yardlist.get(yardIndex).get(j).getLast();
              maxValIndex = j;
            }
          }
          
        }
        else{
          if(emptyIndex == -1){
            emptyIndex = j;
          }
        }
      }
      if(maxValIndex != -1){
        yardlist.get(yardIndex).get(maxValIndex).add(iterator.next());
      } else if(emptyIndex != -1 && maxValIndex == -1){
        yardlist.get(yardIndex).get(emptyIndex).add(iterator.next());
      } else if(minValIndex != -1 && maxValIndex == -1){
          yardlist.get(yardIndex).get(minValIndex).add(iterator.next());
        }
      else{
          System.out.println("error: "+"maxValIndex "+maxValIndex+
                             "\nminValIndex "+minValIndex+
                             "\nemptyIndex "+emptyIndex);
        }
    }
    System.out.println("closest sort"+yardlist.get(yardIndex).toString());
  }
  
           
  
  
  /**sorts train using closestsort method through all classification yards
    * @param array of train
    */
  public void closestSort(T[] train){
    int yardIndex = 0;
    
    for(yardIndex = 0; yardIndex < yardlist.size(); yardIndex++){
      this.oneClosestSort(yardIndex, train);
      System.out.println("closest sort one yard "+yardlist.get(yardIndex).toString());
      this.mergeForArray(yardIndex, train);
    }
  }
  
  
    /**sorts train using closestsort method through all classification yards
    * @param list of train
    */
  public void closestSort(List<T> train){
    int yardIndex = 0;
    
    for(yardIndex = 0; yardIndex < yardlist.size(); yardIndex++){
      this.oneClosestSort(yardIndex, train);
      System.out.println("closest sort one yard "+yardlist.get(yardIndex).toString());
      this.mergeForList(yardIndex, train);
    }
  }
  
}





