package problemset11_aufgabe1;

import java.util.Vector;
import java.io.*;
import java.util.*;

public class graph {
   // ungewichteter, gerichteter Graph mit Adjazenzmatrix-
   // darstellung
   int[][] adjazenzmatrix;
   int dimension;
   private LinkedList<Integer> adj[];
   
   public graph(int d) {
      dimension = d;
      adjazenzmatrix = new int[d][d];
      for (int i=0; i<d; i++) {
        adjazenzmatrix[i][i] = 1;
      }
      adj = new LinkedList[dimension];
      for (int i=0; i<dimension; ++i)
          adj[i] = new LinkedList();
   }

   public void addKante(int i, int j) {
     if (i < dimension && j < dimension) {
        adjazenzmatrix[i][j] = 1;
     }
   }
   
   Vector<Integer> besucht = new Vector();
   public void tiefensuche(int i) {
      besucht.clear();
      tf(i);
   }
   
   private void tf(int i) {
       for (int j=0; j<dimension; j++) {
          if (i!=j && adjazenzmatrix[i][j] == 1 && besucht.contains(j) == false) {
                tf(j);
          }
       }
       besucht.add(i);
       System.out.println(i);
  }
  public void breitensuche(int s) {
	// Mark all the vertices as not visited(By default
      // set as false)
      boolean visited[] = new boolean[dimension];

      // Create a queue for BFS
      LinkedList<Integer> queue = new LinkedList<Integer>();

      // Mark the current node as visited and enqueue it
      visited[s]=true;
      queue.add(s);

      while (queue.size() != 0)
      {
          // Dequeue a vertex from queue and print it
          s = queue.poll();
          System.out.print(s+" ");

          // Get all adjacent vertices of the dequeued vertex s
          // If a adjacent has not been visited, then mark it
          // visited and enqueue it
          Iterator<Integer> i = adj[s].listIterator();
          while (i.hasNext())
          {
              int n = i.next();
              if (!visited[n])
              {
                  visited[n] = true;
                  queue.add(n);
              }
          }
      }
  }
  }
