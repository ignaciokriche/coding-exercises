/**
 * @author Kriche
 */
package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.Roman.toArabic;
import static ar.com.kriche.Roman.toRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanTest {

    @Test
    public void toRomanTest() {
        assertEquals("I", toRoman(1));
        assertEquals("II", toRoman(2));
        assertEquals("III", toRoman(3));
        assertEquals("IV", toRoman(4));
        assertEquals("V", toRoman(5));
        assertEquals("VI", toRoman(6));
        assertEquals("VII", toRoman(7));
        assertEquals("VIII", toRoman(8));
        assertEquals("IX", toRoman(9));
        assertEquals("X", toRoman(10));
        assertEquals("XII", toRoman(12));
        assertEquals("XIV", toRoman(14));
        assertEquals("XV", toRoman(15));
        assertEquals("XIX", toRoman(19));
        assertEquals("XX", toRoman(20));
        assertEquals("XXIII", toRoman(23));
        assertEquals("XXV", toRoman(25));
        assertEquals("XXVII", toRoman(27));
        assertEquals("XXIX", toRoman(29));
        assertEquals("XXX", toRoman(30));
        assertEquals("XXXI", toRoman(31));
        assertEquals("XXXIX", toRoman(39));
        assertEquals("XL", toRoman(40));
        assertEquals("XLIV", toRoman(44));
        assertEquals("XLV", toRoman(45));
        assertEquals("L", toRoman(50));
        assertEquals("LI", toRoman(51));
        assertEquals("LIV", toRoman(54));
        assertEquals("LX", toRoman(60));
        assertEquals("LXXXVIII", toRoman(88));
        assertEquals("LXXXIX", toRoman(89));
        assertEquals("XC", toRoman(90));
        assertEquals("XCI", toRoman(91));
        assertEquals("XCIX", toRoman(99));
        assertEquals("C", toRoman(100));
        assertEquals("CIV", toRoman(104));
        assertEquals("CV", toRoman(105));
        assertEquals("CCCLVII", toRoman(357));
        assertEquals("CCCXCIX", toRoman(399));
        assertEquals("CD", toRoman(400));
        assertEquals("CDI", toRoman(401));
        assertEquals("CDXCIX", toRoman(499));
        assertEquals("D", toRoman(500));
        assertEquals("DI", toRoman(501));
        assertEquals("DCCCXCVII", toRoman(897));
        assertEquals("DCCCXCIX", toRoman(899));
        assertEquals("CM", toRoman(900));
        assertEquals("CMI", toRoman(901));
        assertEquals("CMXCIX", toRoman(999));
        assertEquals("M", toRoman(1000));
        assertEquals("MI", toRoman(1001));
        assertEquals("MCMXCIX", toRoman(1999));
        assertEquals("MM", toRoman(2000));
    }

    @Test
    public void toArabicTest() {
        assertEquals(1, toArabic("I"));
        assertEquals(2, toArabic("II"));
        assertEquals(3, toArabic("III"));
        assertEquals(4, toArabic("IV"));
        assertEquals(5, toArabic("V"));
        assertEquals(6, toArabic("VI"));
        assertEquals(7, toArabic("VII"));
        assertEquals(8, toArabic("VIII"));
        assertEquals(9, toArabic("IX"));
        assertEquals(10, toArabic("X"));
        assertEquals(12, toArabic("XII"));
        assertEquals(14, toArabic("XIV"));
        assertEquals(15, toArabic("XV"));
        assertEquals(19, toArabic("XIX"));
        assertEquals(20, toArabic("XX"));
        assertEquals(23, toArabic("XXIII"));
        assertEquals(25, toArabic("XXV"));
        assertEquals(27, toArabic("XXVII"));
        assertEquals(29, toArabic("XXIX"));
        assertEquals(30, toArabic("XXX"));
        assertEquals(31, toArabic("XXXI"));
        assertEquals(39, toArabic("XXXIX"));
        assertEquals(40, toArabic("XL"));
        assertEquals(44, toArabic("XLIV"));
        assertEquals(45, toArabic("XLV"));
        assertEquals(50, toArabic("L"));
        assertEquals(51, toArabic("LI"));
        assertEquals(54, toArabic("LIV"));
        assertEquals(60, toArabic("LX"));
        assertEquals(88, toArabic("LXXXVIII"));
        assertEquals(89, toArabic("LXXXIX"));
        assertEquals(90, toArabic("XC"));
        assertEquals(91, toArabic("XCI"));
        assertEquals(99, toArabic("XCIX"));
        assertEquals(104, toArabic("CIV"));
        assertEquals(105, toArabic("CV"));
        assertEquals(357, toArabic("CCCLVII"));
        assertEquals(399, toArabic("CCCXCIX"));
        assertEquals(400, toArabic("CD"));
        assertEquals(401, toArabic("CDI"));
        assertEquals(499, toArabic("CDXCIX"));
        assertEquals(500, toArabic("D"));
        assertEquals(501, toArabic("DI"));
        assertEquals(897, toArabic("DCCCXCVII"));
        assertEquals(899, toArabic("DCCCXCIX"));
        assertEquals(900, toArabic("CM"));
        assertEquals(901, toArabic("CMI"));
        assertEquals(999, toArabic("CMXCIX"));
        assertEquals(1000, toArabic("M"));
        assertEquals(1001, toArabic("MI"));
        assertEquals(1999, toArabic("MCMXCIX"));
        assertEquals(2000, toArabic("MM"));

    }

    @Test
    public void toArabicToRomanSymmetryTest() {
        // tests consistency between toArabic and toRoman methods, NOT correctness.
        for (int n = 1; n <= 2000; n++) {
            assertEquals(n, toArabic(toRoman(n)));
        }
    }

}