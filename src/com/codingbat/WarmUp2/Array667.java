package com.codingbat.WarmUp2;

public class Array667 {
    public int array667(int[] num) {
        int cont = 0;
        for (int i=0; i < (num.length-1); i++) {
            if (num[i] == 6) {
                if (num[i+1] == 6 || num[i+1] == 7) {
                    cont++;
                }
            }
        }
        return cont;
    }
}
