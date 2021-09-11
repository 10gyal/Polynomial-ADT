// Skeleton of the Polynomial ADT

import java.util.*;


public class Polynomial {
  TreeMap <Integer, Integer> poly = new TreeMap<>(Collections.reverseOrder());
  // Create an empty polynomial
  public Polynomial() {
    poly.put(0, 0);
  }

  // Create a single-term polynomial
  public Polynomial(int coef, int exp) {
    poly.put(exp, coef);
  }

  // Add opnd to 'this' polynomial; 'this' is returned
  public Polynomial add(Polynomial opnd) {
    for (Integer exp : this.poly.keySet()) {
      if (opnd.poly.containsKey(exp)) {
        this.poly.replace(exp, this.poly.get(exp) + opnd.poly.get(exp));
      }
    }
    for (Integer expOpnd : opnd.poly.keySet()){
      if(!this.poly.containsKey(expOpnd)){
            this.poly.put(expOpnd, opnd.poly.get(expOpnd));
      }
    }
    return this;
  }

  // Subtract opnd from 'this' polynomial; 'this' is returned
  public Polynomial sub(Polynomial opnd) {
    for (Integer exp : this.poly.keySet()) {
      if (opnd.poly.containsKey(exp)) {
        this.poly.replace(exp, this.poly.get(exp) - opnd.poly.get(exp));
      }
    }
    for (Integer expOpnd : opnd.poly.keySet()){
      if(!this.poly.containsKey(expOpnd)){
        this.poly.put(expOpnd, opnd.poly.get(expOpnd)*(-1));
      }
    }
    return this;
  }

  // Print the terms of 'this' polynomial in decreasing order of exponents.
  // No pair of terms can share the same exponent in the printout.
  public void print() {
    Set<Map.Entry<Integer, Integer>> entrySet = poly.entrySet();
    Map.Entry[] Arr = entrySet.toArray(new Map.Entry[0]);
    for(int i = 0; i <= poly.size()-1; i++){
      if((int)Arr[i].getValue() != 0){
        System.out.print(Arr[i].getValue() + " " + Arr[i].getKey() + " ");
      }
    }
  }
}
