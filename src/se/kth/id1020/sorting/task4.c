/*
    Written by Alexander Broms, 2020-09-15
    Solution to task 4 of the sorting lab.
    The orderNegatives algorithm has time complexity O(N) without the call to printArray.
    The purpose of that algorithm is to order the elements so that all negative values are to the left,
    and all positive values are to the right.
*/
#include <stdio.h>

void printArray(int a[], size_t arraySize){
    for(int i=0; i<arraySize; i++){
        if(i==(arraySize-1)){ printf("%d", a[i]); }

        else{ printf("%d, ", a[i]); }
    }
    printf("\n");
}

void orderNegatives(int a[], size_t arraySize){
    int orderedTo = 0;
    int j;

    printf("Size of array: %lu\n", arraySize);

    for(j=1; j < arraySize; j++){
        if(a[j] < 0){
            int tmp = a[orderedTo];
            a[orderedTo] = a[j];
            a[j] = tmp;
            orderedTo++;
            //printArray(a, arraySize); //alters the time complexity so that it becomes O(N^2)
        }
    }
}

int main()
{
    //set up an array to test
    int myArray[] = {3, 1, 2, -5, -1, -2};
    int myArraySize = sizeof(myArray)/sizeof(myArray[0]);

    //show results of algorithm
    printf("Before order:\n");
    printArray(myArray, myArraySize);
    orderNegatives(myArray, myArraySize);
    printf("After order:\n");
    printArray(myArray, myArraySize);

    return 0;
}