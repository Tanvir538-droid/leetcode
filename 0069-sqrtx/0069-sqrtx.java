class Solution {

    public int search(int x, int start, int end) {

        if (start > end) {
            return end;
        }

        int mid = start + (end - start) / 2;

        if ((long) mid * mid == x) {
            return mid;
        }
        else if ((long) mid * mid < x) {
            return search(x, mid + 1, end);
        }
        else {
            return search(x, start, mid - 1);
        }
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        return search(x, 1, x / 2);
    }
}