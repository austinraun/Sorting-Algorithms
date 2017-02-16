public class Mergesort{
	public static int[] mergeSort(int[] a) {
        if (a.length <= 1) { //at most 1 element
            return a; }
        // Split the array in half
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];
        //copy items in a from 0 to index of first starting 
        //at first[0] up until first.length
        System.arraycopy(a, 0, first, 0, first.length);
        System.arraycopy(a, first.length, second, 0, second.length);
        // Sort each half recursively
        mergeSort(first);
        mergeSort(second);
        // Merge the halves together, overwriting the original array
        merge(first, second, a);
        return a;
    }
    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        int iFirst = 0;// Index of next element to consider in the first array
        int iSecond = 0;// Index of next element to consider in the second array
        int j = 0;// Next open position in the result
        // Make sure neither index past end, put smallest in result
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            }else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        //copy unused item left in 1st or 2nd  array from its index 
        //endpoint starting from position j in result, into however many 
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
    public static void main(String args[]){
        int[] intArray = {5,17,2,6,8,4,6,11,40,1,23};
        System.out.println("Values before Merge Sort: ");
        for (int j=0;j<intArray.length;j++) {
            System.out.print(intArray[j]+" "); }
        intArray=mergeSort(intArray);
        System.out.println("\nValues after Merge Sort: ");
        for (int j=0;j<intArray.length;j++) {
            System.out.print(intArray[j]+" ");
        }
    }
}