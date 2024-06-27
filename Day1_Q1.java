
/*
    We have two arrays arr1 and arr2 which are initially empty. You need to add positive integers to them such that they satisfy all the following conditions:

    arr1 contains uniqueCnt1 distinct positive integers, each of which is not divisible by divisor1.
    arr2 contains uniqueCnt2 distinct positive integers, each of which is not divisible by divisor2.
    No integer is present in both arr1 and arr2.
    Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum possible maximum integer that can be present in either array.
*/

class Day1_Q1 {

    // Failed

    // public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int
    // uniqueCnt2) {
    // // HashSet<Integer> set1 = new HashSet<>();
    // // HashSet<Integer> set2 = new HashSet<>();
    // HashSet<Integer> set3 = new HashSet<>();
    // int i = 0,value = 0,size1=0,size2=0;
    // while((size1+size2)<(uniqueCnt1+uniqueCnt2)){
    // value++;
    // if(value%divisor1!=0 && size1<uniqueCnt1){
    // // System.out.println(value);
    // // set1.add(value);
    // size1++;
    // }else if(value%divisor2!=0 && size2<uniqueCnt2){
    // // System.out.println("--> "+value);
    // // set2.add(value);
    // size2++;
    // }else{
    // set3.add(value);
    // }
    // i++;
    // }

    // // System.out.println(set1+" ::: "+set2+" ++ "+set3); //14
    // return value;
    // }

    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long l = 1, r = (long) 1e15, ans = r, d1 = divisor1, d2 = divisor2, cnt1 = uniqueCnt1, cnt2 = uniqueCnt2;
        long g = gcd(d1, d2), lcm = (d1 * d2) / g;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (d1 == d2) {
                long cnt = mid - (mid / d1);
                if (cnt >= cnt1 + cnt2) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                long common = mid / lcm;
                long c1 = (mid / d1) - common, c2 = (mid / d2) - common;

                long z1 = cnt1, z2 = cnt2;
                long avail = mid - (c1 + c2 + common);

                z1 -= Math.min(z1, c2);
                z2 -= Math.min(z2, c1);

                if (z1 + z2 <= avail) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return (int) ans;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("        Question 1: ");
        // int divisor1 = 2, divisor2 = 4, uniqueCnt1 = 8, uniqueCnt2 = 2;
        // int divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3;
        int divisor1 = 12, divisor2 = 3, uniqueCnt1 = 2, uniqueCnt2 = 10;// 14
        System.out.println("Ans : " + minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2));
    }
}