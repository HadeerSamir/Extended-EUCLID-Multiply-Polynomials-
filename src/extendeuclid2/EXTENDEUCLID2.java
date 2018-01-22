package extendeuclid2;

import java.util.Scanner;

public class EXTENDEUCLID2 {

    public static long multiply(long x, long y) {

        String a11 = String.format("%02X", x);
        String a = hexaToBinary(a11);

        String b11 = String.format("%02X", y);
        String b = hexaToBinary(b11);

        String output = "00000000";
        String B1 = "00011011";
        int flag = 0;

        String a1 = a;
        if (a1.charAt(0) == '1') {
            flag = 1;
        }

        String a2 = a1.substring(1) + "0";
        if (flag == 1) {
            a2 = performXOR(a2, B1);
            flag = 0;
        }
        if (a2.charAt(0) == '1') {
            flag = 1;
        }

        String a3 = a2.substring(1) + "0";
        if (flag == 1) {
            a3 = performXOR(a3, B1);
            flag = 0;
        }
        if (a3.charAt(0) == '1') {
            flag = 1;
        }

        String a4 = a3.substring(1) + "0";
        if (flag == 1) {
            a4 = performXOR(a4, B1);
            flag = 0;
        }
        if (a4.charAt(0) == '1') {
            flag = 1;
        }

        String a5 = a4.substring(1) + "0";
        if (flag == 1) {
            a5 = performXOR(a5, B1);
            flag = 0;
        }
        if (a5.charAt(0) == '1') {
            flag = 1;
        }
        String a6 = a5.substring(1) + "0";
        if (flag == 1) {
            a6 = performXOR(a6, B1);
            flag = 0;
        }
        if (a6.charAt(0) == '1') {
            flag = 1;
        }

        String a7 = a6.substring(1) + "0";
        if (flag == 1) {
            a7 = performXOR(a7, B1);
            flag = 0;
        }
        if (a7.charAt(0) == '1') {
            flag = 1;
        }

        String a8 = a7.substring(1) + "0";
        if (flag == 1) {
            a8 = performXOR(a8, B1);
            flag = 0;
        }
        if (a8.charAt(0) == '1') {
            flag = 1;
        }

        String bIndex = "";
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                bIndex += i;
            }

        }

        for (int i = 0; i < bIndex.length(); i++) {
            switch (bIndex.charAt(i)) {
                case '0':
                    output = performXOR(output, a8);
                    break;

                case '1':
                    output = performXOR(output, a7);
                    break;

                case '2':
                    output = performXOR(output, a6);
                    break;

                case '3':
                    output = performXOR(output, a5);
                    break;

                case '4':
                    output = performXOR(output, a4);
                    break;

                case '5':
                    output = performXOR(output, a3);
                    break;

                case '6':
                    output = performXOR(output, a2);
                    break;

                case '7':
                    output = performXOR(output, a1);
                    break;

            }
        }

        long result = Long.parseLong(output);

        return result;

    }

    public static long binaryToLong(String x) {
        long output = Long.parseLong(x);

        return output;
    }

    private static long numberOfShift(long a) {

        long b = 0;
        while (a > 0) {
            a = a >> 1;
            b = b + 1;
        }

        return b;
    }

    public static long division(long p1, long p2) {

        long a = p1;
        long b = p2;

        long q = 0;
        long t1 = numberOfShift(a);
        long t2 = numberOfShift(b);

        while (t1 >= t2) {
            q = q | (1 << (t1 - t2));
            a = a ^ (b << (t1 - t2));
            t1 = numberOfShift(a);
            t2 = numberOfShift(b);
        }

        return q;
    }

    public static long extendEUCLID(long p1) {

        long A1 = 1;
        long A2 = 0;
        long A3 = 27;

        long B1 = 0;
        long B2 = 1;
        long B3 = p1;

        while (B3 != 1) {

            long quo = division(A3, B3);

            long t1 = B1;
            long t2 = B2;
            long t3 = B3;

            B1 = add(A1, multiply(quo, B1));
            B2 = add(A2, multiply(quo, B2));

            B3 = add(A3, multiply(quo, B3));

            A1 = t1;
            A2 = t2;
            A3 = t3;

        }
        return B2;
    }

    public static String performXOR(String key, String permulationTableOutput) {
        int res;
        String output = "";

        for (int i = 0; i < key.length(); i++) {
            int keyChar = (int) key.charAt(i);
            int permulationTableOutputChar = (int) permulationTableOutput.charAt(i);
            res = (int) (keyChar ^ permulationTableOutputChar);

            output += res;
        }

        return output;   //binaryformat
    }

    public static String binaryToHexa(String input) {

        String result = "";
        String hexaOutput = "";

        for (int i = 0; i < input.length(); i = i + 4) {

            String tmp = input.substring(i, i + 4);

            int decimal = Integer.parseInt(tmp, 2);
            hexaOutput = hexaOutput + Integer.toHexString(decimal);

        }
        result = hexaOutput.toUpperCase();

        return result;
    }

    public static String hexaToBinary(String hexa) {
        String binary = "";
        String formatedInput = "";
        for (int i = 0; i < hexa.length(); i++) {
            switch (hexa.charAt(i)) {

                case '0':
                    binary = "0000";
                    break;

                case '1':
                    binary = "0001";
                    break;

                case '2':
                    binary = "0010";
                    break;

                case '3':
                    binary = "0011";
                    break;

                case '4':
                    binary = "0100";
                    break;

                case '5':
                    binary = "0101";
                    break;

                case '6':
                    binary = "0110";
                    break;

                case '7':
                    binary = "0111";
                    break;

                case '8':
                    binary = "1000";
                    break;

                case '9':
                    binary = "1001";
                    break;

                case 'A':
                    binary = "1010";
                    break;

                case 'B':
                    binary = "1011";
                    break;

                case 'C':
                    binary = "1100";
                    break;

                case 'D':
                    binary = "1101";
                    break;

                case 'E':
                    binary = "1110";
                    break;

                case 'F':
                    binary = "1111";
                    break;
            }
            formatedInput += binary;

        }
        return formatedInput;

    }

    public static long add(long x, long y) {

        String a11 = String.format("%02X", x);
        String a = hexaToBinary(a11);

        String b11 = String.format("%02X", y);
        String b = hexaToBinary(b11);

        String output = performXOR(a, b);

        long result = Long.parseLong(output);

        return result;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        long input1 = binaryToLong(input);

        long output = extendEUCLID(input1);
        String a11 = String.format("%02X", output);

        System.out.println(input + " " + a11);

    }

}
