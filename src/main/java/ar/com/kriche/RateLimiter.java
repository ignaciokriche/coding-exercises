package ar.com.kriche;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Keep track of how many calls were made in a given interval of seconds.
 * <p>
 * Usage:
 * RateLimiter rateLimiter = new RateLimiter(5, 2); // max 5 calls within 2 seconds.
 * rateLimiter.isWithinRate();
 *
 * @author Kriche
 */
public class RateLimiter {

    private final int maxCalls;
    private final int intervalInSeconds;

    private Queue<LocalDateTime> calls;

    /**
     * @param maxCalls          the amount of calls allowed. A negative value means no limit.
     * @param intervalInSeconds the time window within up to max calls will be allowed.
     *                          A non-positive value means no calls allowed (except maxCalls is negative).
     */
    public RateLimiter(int maxCalls, int intervalInSeconds) {
        this.maxCalls = maxCalls;
        this.intervalInSeconds = intervalInSeconds;
        if (maxCalls <= 0 || intervalInSeconds <= 0) {
            return;
        }
        calls = new ArrayDeque<>(maxCalls);
    }

    /**
     * @return true if no more than max calls where made during the interval. False, otherwise.
     */
    public boolean isWithinRate() {

        final LocalDateTime timeStampNow = LocalDateTime.now();

        if (maxCalls < 0) {
            return true;
        }
        if (maxCalls == 0) {
            return false;
        }
        if (intervalInSeconds <= 0) {
            return false;
        }

        // TODO this is not an efficient way of making it thread safe! Use a thread safe queue if needed.
        synchronized (this) {
            calls.add(timeStampNow);
            if (calls.size() <= maxCalls) {
                // the first maxCalls calls will always be within the limit.
                return true;
            }
            LocalDateTime intervalSecondsAgo = timeStampNow.minusSeconds(intervalInSeconds);
            LocalDateTime oldest = calls.poll(); // poll keeps the queue from not unlimited growing.
            return oldest.isBefore(intervalSecondsAgo);
        }
    }

}
