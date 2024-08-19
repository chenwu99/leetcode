package array;

public class Lc66 {
    public int[] plusOne(int[] digits) {
        int num = 0;
        int preM = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            num = num * preM + digits[i];
            preM *= 10;
        }
        num ++;
        return digits;
    }

}
