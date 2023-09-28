package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Kriche
 */
public class RateLimiterTest {

    @Test
    public void given_MaxTenCallsForOneSecondInterval_WhenCallingOnce_ThenMustBeWithinRate() {
        RateLimiter theTested = new RateLimiter(10, 1); // 10 calls within 1 second.
        assertTrue(theTested.isWithinRate());
    }

    @Test
    public void given_MaxTenCallsForOneSecondInterval_WhenCallingTenTimes_ThenMustBeWithinRate() {
        RateLimiter theTested = new RateLimiter(10, 1); // 10 calls within 1 second.
        for (int i = 0; i < 10; i++) {
            assertTrue(theTested.isWithinRate());
        }
    }

    @Test
    public void given_MaxTenCallsForOneSecondInterval_WhenCallingElevenTimes_ThenLastCallMustNotBeWithinRate() {
        RateLimiter theTested = new RateLimiter(10, 1); // 10 calls within 1 second.
        // first 10 must be true:
        for (int i = 0; i < 10; i++) {
            assertTrue(theTested.isWithinRate());
        }
        assertFalse(theTested.isWithinRate());
    }

    @Test
    public void uptoFiveCallsWithinTwoSeconds_MustBeInRange() throws InterruptedException {
        RateLimiter theTested = new RateLimiter(5, 2); // 5 calls max within 2 seconds.
        int tries = 2;
        while (tries-- > 0) {
            assertTrue(theTested.isWithinRate());
            assertTrue(theTested.isWithinRate());
            Thread.sleep(1000);
            assertTrue(theTested.isWithinRate());
            Thread.sleep(500);
            assertTrue(theTested.isWithinRate());
            assertTrue(theTested.isWithinRate());
            Thread.sleep(100);
            assertFalse(theTested.isWithinRate());
            Thread.sleep(2000);
        }
    }

    @Test
    public void givenFourCallsWhenMakingFiveCallsTwoSecondsLaterThenMustBeWithinRange() throws InterruptedException {

        RateLimiter theTested = new RateLimiter(5, 2); // 5 calls max within 2 seconds.

        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());

        Thread.sleep(2000);

        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertFalse(theTested.isWithinRate());
    }

    @Test
    public void LastThreeMustBeWithinRange() throws InterruptedException {

        RateLimiter theTested = new RateLimiter(5, 1); // 5 calls max within 1 second.

        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        Thread.sleep(800);

        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        Thread.sleep(800);

        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertTrue(theTested.isWithinRate());
        assertFalse(theTested.isWithinRate());

    }

    @Test
    public void givenNegativeMaxCalls_WhenCalling_ThenMustBeWithinRate() {
        RateLimiter theTested = new RateLimiter(-1, -10);
        assertTrue(theTested.isWithinRate());

        theTested = new RateLimiter(-1, 0);
        assertTrue(theTested.isWithinRate());

        theTested = new RateLimiter(-1, 10);
        assertTrue(theTested.isWithinRate());
    }

    @Test
    public void givenZeroMaxCalls_WhenCalling_ThenMustNotBeWithinRate() {
        RateLimiter theTested = new RateLimiter(0, 10);
        assertFalse(theTested.isWithinRate());

        theTested = new RateLimiter(0, 0);
        assertFalse(theTested.isWithinRate());

        theTested = new RateLimiter(0, -10);
        assertFalse(theTested.isWithinRate());
    }

    @Test
    public void givenNegativeInterval_WhenCalling_ThenMustNotBeWithinRate() {
        RateLimiter theTested = new RateLimiter(10, -1);
        assertFalse(theTested.isWithinRate());
    }

    @Test
    public void givenZeroInterval_WhenCalling_ThenMustNotBeWithinRate() {
        RateLimiter theTested = new RateLimiter(10, 0);
        assertFalse(theTested.isWithinRate());
    }

}
