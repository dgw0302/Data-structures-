package 美团笔试;


public class 最多礼盒 {
    public static void main(String[] args) {


//
//        int A = 9, B = 49;
//        int res = 0;
//        while(A > 0 && B > 0) {
//            if (A == B) {
//                A -= 2;
//                B--;
//                if (A< 0) {
//                    break;
//                }
//            } else if (A > B) {
//                A -= 2;
//                B--;
//
//                if (A< 0) {
//                    break;
//                }
//            } else {
//                B -= 2;
//                A--;
//                if (B< 0) {
//                    break;
//                }
//            }
//            res += 1;
//        }
//        System.out.println(res);
//
//
//


        System.out.println(Math.min(Math.min(9,49), ((9 + 49) / 3)));


    }



}
