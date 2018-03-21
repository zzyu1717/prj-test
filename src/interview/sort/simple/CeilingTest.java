package interview.sort.simple;

public class CeilingTest {
    public static void main(String[] args) {
        int[] data = {1,2,3,3,3,4,5};
        int index = BinarySearch.ceiling(data,3);
        System.out.println(index);
        int index2 = BinarySearch.ceiling2(data,3);
        System.out.println(index2);
    }
}
