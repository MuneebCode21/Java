package park.service;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private final AtomicInteger sequence = new AtomicInteger(1000);
    public String next(String prefix) { return prefix + sequence.incrementAndGet(); }
}
