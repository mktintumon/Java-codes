class InvalidRangeException extends Exception{
    InvalidRangeException(String mssg){
        super(mssg);
    }
}

public class GMethodPrint{
    static <T> int print(T[] arr , int low , int high) throws Exception{
        if(low < 0 || high >= arr.length || low > high){
            throw new InvalidRangeException("out of range");
        }

        for(int i=low ; i<=high ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return high-low+1;
    }

    public static void main(String[] args) throws Exception {
        Integer[] intArr = {1,3,4,3,5,6,7};
        Double[] doubleArr = {1.2,4.5,8.3,7.1,4.4};
        Character[] charArr = {'M','O','H','I','T'};

        int i = print(intArr,1,4);
        int d = print(doubleArr,0,2);
        int c = print(charArr,2,3);
        System.out.println("integer count :" + i);
        System.out.println("float count :" + d);
        System.out.println("char count :" +c);
    }
}
