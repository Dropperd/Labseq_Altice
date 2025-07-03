package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class LabseqService {

    private final ConcurrentHashMap<Integer, BigInteger> cache = new ConcurrentHashMap<>();

    {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

    public BigInteger labseq(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int startFrom = 4;
        for (int i = n - 1; i >= 4; i--) {
            if (cache.containsKey(i)) {
                startFrom = i + 1;
                break;
            }
        }

        for (int i = startFrom; i <= n; i++) {
            BigInteger val = cache.get(i - 4).add(cache.get(i - 3));
            cache.put(i, val);
        }

        return cache.get(n);
    }
}

