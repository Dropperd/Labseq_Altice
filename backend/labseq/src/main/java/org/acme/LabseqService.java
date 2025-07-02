package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class LabseqService {

    private final ConcurrentHashMap<Integer, BigInteger> cache = new ConcurrentHashMap<>();

    public BigInteger labseq(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        if (n == 2) return BigInteger.ZERO;
        if (n == 3) return BigInteger.ONE;

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        BigInteger result = labseq(n - 4).add(labseq(n - 3));
        cache.put(n, result);

        return result;
    }

}

