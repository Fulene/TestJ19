package com.example.testj19.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class CodinGame {

    // [1, -2, 0, -8, 4, 5]
    public int getClosest0(int[] ints) {
        if (ints == null || ints.length == 0) return 0;

        int res = ints[0];
        for (int anInt : ints) {
            if (res * res == anInt * anInt)
                res = anInt >= 0 ? anInt : res;
            else
                res = res * res < anInt * anInt ? res : anInt;
        }

        return res;
    }

    public int calculateTotalPrice(int[] prices, int discount) throws Exception {
        if (prices == null || prices.length == 0) return 0;

        List<Integer> integers = Arrays.stream(prices).boxed().toList();
        int maxPrice = integers.stream()
            .mapToInt(Integer::intValue).max().orElseThrow(Exception::new);

        int maxPriceDiscounted = integers.get(integers.indexOf(maxPrice)) * discount / 100;

        return integers.stream().mapToInt(Integer::intValue).sum();
    }

    public void computeCheckDigit(String idNumber) {
//        List<String> strings = Arrays.asList(idNumber.split(""));
//        int sumPair = strings
//            .stream()
//            .mapToInt(Integer::parseInt)
//            .filter(i -> i % 2 == 0)
//            .sum();
//
//        int sumUnpair = strings
//            .stream()
//            .mapToInt(Integer::parseInt)
//            .filter(i -> i % 2 != 0)
//            .sum();
//
//        int res1 = sumPair * 3 + sumUnpair;
//        res1
    }

    public void findStr(int hash) {

    }

    public int hash(String toEncode) {  // hello
        int hash = 26;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String[] strings = toEncode.split("");  // [h, e, l, l, o]
        for (String string : strings) {
            hash = (hash * 37 + letters.indexOf(string));
        }

        // 26
        // 26 * 37 + 7 = 969
        // 969 * 37 + 4 = 35857
        // 35857 * 37 + 11 = 1326720
        // 1326720 * 37 + 11 = 49088651
        // 49088651 * 37 + 15 = 1816280102

        /**
         *
         * lastHash = letterIndex + 37 * previousHash
         * 15 = x + 37 * y
         *
         * **/

        return hash;
    }

}
