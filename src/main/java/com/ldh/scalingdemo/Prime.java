package com.ldh.scalingdemo;

import org.apache.commons.math3.primes.Primes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prime")
public class Prime {
    @Id
    private long seed;
    private long prime; 
    
    Prime() {}

    Prime(long seed) {
        this.seed = seed;
        randomPrimeFromSeed(seed);
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        randomPrimeFromSeed(seed);
    }

    public long getPrime() {
        return prime;
    }

    public void setPrime(long prime) {
        this.prime = prime;
    }
    
    //Generate a 10 digit number from a seed
    public void randomPrimeFromSeed(long seed) {
        int newseed = (int) (((seed + 2000000000))/8.3);
        prime = Primes.nextPrime(newseed);
    }

}
