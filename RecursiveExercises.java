public class RecursiveExercises{
    //Part 1
    //Finding maximun number with array
    public static int findMax(int[] arr, int left, int right){
        if (left == right){     //one element only = return it
            return arr[left];
        }

        int middle = (left + right) / 2;    //Spilt array in half


        //To find the max of each half
        int maxLeft = findMax(arr, left, middle);
        int maxRight = findMax(arr, middle + 1, right);

        if (maxLeft > maxRight){    //lines 16 - 19
            return maxLeft;         //process of returning the bigger half
        } else{
            return maxRight;
        }                       
    }

    //Part Two
    //Reversing array with process of swapping left and right components

    public static void reverseArray(int[] arr, int left, int right){
        if (left >right){   //left = right OR left > right
            return;
        }

        //Swaping left and right components
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArray(arr, left + 1, right - 1); //Move to center
    }

    //Part 3
    //Process of counting how many times a number appears in array

    public static int countOccurrences(int [] arr, int target, int index){
        if (index >= arr.length){   //reaching end of the array
            return 0;
        }

        //check if component = target
        int count = 0;
        if (arr[index] == target){
            count = 1;
        }

        return count + countOccurrences(arr, target, index + 1); //Checking rest of array
    }

    //Part 4
    //Using binary search to find number in a sorted array

    public static int binarySearch(int[] arr, int target, int left, int right){
        if(left > right) {  //range is empty
            return -1;
        }

        int middle = (left + right) / 2; //checking middle component

        if (arr[middle] == target) {
            return middle;
        } else if (target < arr[middle]) {
            return binarySearch(arr, target, left, middle - 1);     //checking left half
        }else{
            return binarySearch(arr, target, middle + 1, right);    //checking right half
        }
    }



    //Test parts
    public static void main(String[] args) {

        //Part one: to find max
        int [] test1 = {3, 8, 2, 5, 1, 9, 4};
        System.out.println("Max Value: " + findMax(test1, 0, test1.length -1));

        //Part 2: the reverseArray
        System.out.print("Initial array: ");
        for (int i=0; i < test1.length; i++) {
            System.out.print(test1[i] + " ");
        }
        System.out.println();

        reverseArray(test1, 0, test1.length -1);

        System.out.print("Reversed array: ");
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i] + " ");
        }
        System.out.println();

        //Part 3: testing count Occurences
        int [] test2 = {1, 2, 2, 3, 4, 2, 5};
        int count = countOccurrences(test2, 2, 0);
        System.out.println("NUmber of 2s: " + count);


        //Part 4: test BinarySearch
        int [] test3 = {1, 3, 5, 7, 9, 11};
        int foundIndex = binarySearch(test3, 7, 0, test3.length - 1);
        System.out.println("Index of 7: " + foundIndex);

        int notFound = binarySearch(test3, 4, 0, test3.length - 1);
        System.out.println("Index of 4: " + notFound + " not found");
    }
}