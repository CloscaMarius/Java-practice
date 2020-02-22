package teme.w02_flow;

class Ex10_ConsecutiveRepeats {

    static String onlyConsecutiveRepeating(int[] numbersArray) {

        String result = "";
        for (int i = 0; i < numbersArray.length - 1; i++) {
            if (numbersArray[i] == numbersArray[i + 1]) {
                result += String.valueOf(numbersArray[i]) + " ";
                for (int j = i + 2; j < numbersArray.length; j++) {
                    if (numbersArray[i] == numbersArray[j]) {
                        i = j;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(onlyConsecutiveRepeating(new int[]{}));                          //expected: ''
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 1}));                      //expected: '1'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 1, 1}));                   //expected: '1'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 1, 2, 1, 1}));             //expected: '1 1'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 4, 3, 4}));                //expected: ''
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 4, 4, 4, 3, 5, 5, 4, 4})); //expected: '4 5 4'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 4, 4, 4, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9, 9})); //expected: '4 2 9'
    }
}
