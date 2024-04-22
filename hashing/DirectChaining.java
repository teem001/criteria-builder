package hashing;

import java.util.ArrayList;
import java.util.LinkedList;
public class DirectChaining {

    LinkedList<String>[] hashTable;
    int maxChainSize =5;

    DirectChaining(int size){
        hashTable = new LinkedList[size];
    }

    public int modASCIIHashFunction(String word, int M){

        char[] ch = word.toCharArray();
        int i, sum;

      for(sum =0, i=0; i<ch.length; i++){
          sum +=ch[i];
      }
      return sum %M;
    }


    public void insertHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if(hashTable[newIndex]== null){
            hashTable[newIndex] = new LinkedList<>();
            hashTable[newIndex].add(word);

        }
        else hashTable[newIndex].add(word);
    }

    public void printHashTable(){

        if(hashTable == null) System.out.print("The has table do not exist");

        else {
            System.out.println("---------------Hash table-----------");
            for(int i =0; i<hashTable.length ;i++ ){
                System.out.println("The value for index "+i + "is : "+ hashTable[i]);
            }
        }
    }
    public boolean searchHashTable(String word){
        int index = modASCIIHashFunction(word, hashTable.length);

        return hashTable[index] !=null && hashTable[index].contains(word);
    }

    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(50);

        directChaining.insertHashTable("Boy");
        directChaining.insertHashTable("hello");
        directChaining.insertHashTable("how");
        directChaining.insertHashTable("big");
        directChaining.insertHashTable("yinka");
        directChaining.insertHashTable("top");
        directChaining.insertHashTable("Hope");

        directChaining.printHashTable();

        System.out.println(directChaining.searchHashTable("how"));
    }
}
