package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    public long labseq( int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 0;
        if (n == 3) return 1;

        return labseq(n - 4) + labseq(n - 3);
        }
    }

