package com.timmattison.bitcoin.test;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: timmattison
 * Date: 5/20/13
 * Time: 8:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class BigIntegerHelper {
    public static BigInteger squareBigInteger(BigInteger input) {
        return input.multiply(input);
    }

   public static boolean equals(BigInteger first, BigInteger second) {
        if ((first == null) || (second == null)) {
            throw new UnsupportedOperationException("BigInteger values cannot be NULL");
        }

        int result = first.compareTo(second);

        return (result == 0);
    }
}