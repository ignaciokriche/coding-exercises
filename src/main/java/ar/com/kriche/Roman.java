/**
 * converts from arabic to roman numeral and vice versa.
 *
 * @author Kriche
 */
package ar.com.kriche;

import org.jetbrains.annotations.NotNull;

public class Roman {


    /**
     * @param number positive
     * @return the roman numeral for the given number.
     */
    public static String toRoman(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(String.format("cannot convert %d to roman numeral.", number));
        }

        StringBuilder roman = new StringBuilder();

        // Roman numerals are represented by seven different symbols:
        // I for 1
        // V for 5
        // X for 10
        // L for 50
        // C for 100
        // D for 500
        // M for 1000
        //
        // For example:
        // 2 is written as II in Roman numeral, just two one's added together.
        // 12 is written as XII, which is simply X + II.
        // The number 27 is written as XXVII, which is XX + V + II.
        // Roman numerals are usually written largest to smallest from left to right.
        // However, the numeral for 4 is not IIII. Instead, the number 4 is written as IV.
        // Because 1 is before 5 then 1 substracts to 5 giving 4.
        // The same rule applies to the number 9, which is written as IX.
        // There are six instances where subtraction is used:
        // I can be placed before V and X to make 4 and 9.
        // X can be placed before L and C to make 40 and 90.
        // C can be placed before D and M to make 400 and 900.

        while (number > 0) {
            // alternatively we could use 2 arrays here for the values and roman numerals.
            if (number >= 1000) {
                int remainder = number % 1000;
                number = number / 1000;
                while (number-- > 0) {
                    roman.append("M");
                }
                number = remainder;
            } else if (number >= 900) {
                roman.append("CM");
                number -= 900;
            } else if (number >= 500) {
                roman.append("D");
                number -= 500;
            } else if (number >= 400) {
                roman.append("CD");
                number -= 400;
            } else if (number >= 100) {
                roman.append("C");
                number -= 100;
            } else if (number >= 90) {
                roman.append("XC");
                number -= 90;
            } else if (number >= 50) {
                roman.append("L");
                number -= 50;
            } else if (number >= 40) {
                roman.append("XL");
                number -= 40;
            } else if (number >= 10) {
                roman.append("X");
                number -= 10;
            } else if (number >= 9) {
                roman.append("IX");
                number -= 9;
            } else if (number >= 5) {
                roman.append("V");
                number -= 5;
            } else if (number >= 4) {
                roman.append("IV");
                number -= 4;
            } else {
                // 3, 2, 1
                roman.append("I");
                number -= 1;
            }
        }
        return roman.toString();
    }

    public static int toArabic(@NotNull String roman) {
        char[] romanNumerals = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] arabicValues = new int[]{1, 5, 10, 50, 100, 500, 1000};

        int arabicNumber = 0;
        int romanPreviousIndex = -1;
        int right = roman.length();
        while (right-- > 0) {
            char romanCurrent = roman.charAt(right);
            int i;
            for (i = 0; i < romanNumerals.length; i++) {
                if (romanCurrent == romanNumerals[i]) {
                    int arabicCurrent = arabicValues[i];
                    if (romanPreviousIndex >= 0 && arabicCurrent < arabicValues[romanPreviousIndex]) {
                        arabicNumber -= arabicCurrent;
                    } else {
                        arabicNumber += arabicCurrent;
                    }
                    romanPreviousIndex = i;
                    break;
                }
            }
            if (i == romanNumerals.length) {
                throw new IllegalArgumentException(String.format("invalid value: %c at %d", romanCurrent, right));
            }
        }
        return arabicNumber;
    }

}
