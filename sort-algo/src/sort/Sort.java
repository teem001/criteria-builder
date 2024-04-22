package sort;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sort {

    public static long mergeSortCounter;


    public static void quickSort(City[] array, int lowIndex, int highIndex){

        if(lowIndex>=highIndex) return;

        City pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer){
            while (array[leftPointer].getLatitude() <=pivot.getLatitude() && leftPointer < rightPointer){
                leftPointer ++;
            }
            while (array[rightPointer].getLatitude()>pivot.getLatitude() && leftPointer < rightPointer){
                rightPointer --;
            }
            City rightSwap = array[leftPointer];

            array[leftPointer] = array[rightPointer];
            array[rightPointer] = rightSwap;
        }

        City rightSwap = array[highIndex];

        array[leftPointer] = array[highIndex];
        array[rightPointer] = rightSwap;

        quickSort(array,  lowIndex, leftPointer -1);
        quickSort(array,  leftPointer+1,  highIndex);


    }



    public static void  mergeSort(City[] inputArray){

        int inputLength = inputArray.length;

        if(inputLength < 2) return;
        int  mid = inputLength/2;
        City[] leftHalf = new City[mid];
        City [] rightHalf = new City[inputLength - mid];

        for(int i=0; i< mid; i++){
            leftHalf[i] = inputArray[i];
        }
        for(int i=mid; i< inputLength; i++){
            rightHalf[i-mid] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }



    public static void merge(City[] inputArray, City[] left, City[] right){
        int  leftSize = left.length;
        int rightSize = right.length;

        int i=0, j=0, k =0;

        while (i< leftSize && j<rightSize){
            if(left[i].getLatitude() <= right[j].getLatitude()){
                inputArray[k] = left[i];
                i++;
            }
            else {
                inputArray[k]= right[j];
                j++;
            }
            k++;
        }

        while (i<leftSize){
            inputArray[k] = left[i];
            i++;
            k++;
        }
        while (j<rightSize){
            inputArray[k]= right[j];
            j++;
            k++;
        }
        mergeSortCounter++;
    }
    public static void quickSortLonLag(City[] array, int lowIndex, int highIndex){

        if(lowIndex>=highIndex) return;

        City pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer){
            while (getDistance(array[leftPointer] ,pivot)   && leftPointer < rightPointer){
                leftPointer ++;
            }
            while (getDistance(pivot, array[ rightPointer]) && leftPointer < rightPointer){
                rightPointer --;
            }
            City rightSwap = array[leftPointer];

            array[leftPointer] = array[rightPointer];
            array[rightPointer] = rightSwap;
        }

        City rightSwap = array[highIndex];

        array[leftPointer] = array[highIndex];
        array[rightPointer] = rightSwap;

        quickSort(array,  lowIndex, leftPointer -1);
        quickSort(array,  leftPointer+1,  highIndex);


    }



    public static void  mergeSortLonLag(City[] inputArray){

        int inputLength = inputArray.length;

        if(inputLength < 2) return;
        int  mid = inputLength/2;
        City[] leftHalf = new City[mid];
        City [] rightHalf = new City[inputLength - mid];

        for(int i=0; i< mid; i++){
            leftHalf[i] = inputArray[i];
        }
        for(int i=mid; i< inputLength; i++){
            rightHalf[i-mid] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private static boolean getDistance(City city1, City city2){
        //using the equator as the base
        double distanceOne = Math.acos(Math.sin(0)*Math.sin(city1.getLatitude()) + Math.cos(0)*Math.cos(city1.getLongitude())) * 6371000;
        double distanceTwo= Math.acos(Math.sin(0)*Math.sin(city2.getLatitude()) + Math.cos(0)*Math.cos(city2.getLongitude())) * 6371000;

        return distanceOne<= distanceTwo;

    }


    public static void mergeLonLag(City[] inputArray, City[] left, City[] right){
        int  leftSize = left.length;
        int rightSize = right.length;

        int i=0, j=0, k =0;

        while (i< leftSize && j<rightSize){
            if(getDistance(left[i], right[j])){
                inputArray[k] = left[i];
                i++;
            }
            else {
                inputArray[k]= right[j];
                j++;
            }
            k++;
        }

        while (i<leftSize){
            inputArray[k] = left[i];
            i++;
            k++;
        }
        while (j<rightSize){
            inputArray[k]= right[j];
            j++;
            k++;
        }
        mergeSortCounter++;
    }

    public static void main(String[] args) throws IOException {
       CityUploader cityUploader = new CityUploader("sort/worldcities.csv");
       cityUploader.mapCSVToPOJO();
      City[] list = cityUploader.getCities().toArray(City[]::new);

       quickSort(list, 0, list.length -1);


        for (City c: list){
            System.out.println(c);
        }
//        mergeSortCounter =0;
//        mergeSortLonLag(list);
//
//        System.out.println("the second merg sort counted is "+ mergeSortCounter);

        //47867

    }
}
