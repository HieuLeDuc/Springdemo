package com.ldh.scalingdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PrimeController {

    @Autowired
    private PrimeRepo primeRepository;

    // demo to make sure the app is running
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/prime")
    public Prime getRandomPrime() {
        Iterable<Prime> primeList = primeRepository.findAll();
        List<Prime> primeList2 = new ArrayList<>();
        for (Prime prime : primeList) {
            primeList2.add(prime);
        }
        int random = (int) (Math.random() * primeList2.size());
        busyWait();
        return primeList2.get(random);
    }

    @GetMapping("/prime/getall")
    public Iterable<Prime> getAllPrimes() {
        busyWait();
        return primeRepository.findAll();
    }

    @PostMapping("/prime/add")
    public Prime addPrime(@RequestBody Request request) {
        int seed = request.getSeed();
        Prime prime = new Prime(seed);
        primeRepository.save(prime);
        busyWait();
        return prime;
    }

    @PutMapping("/prime/delete")
    public String deletePrime(@RequestBody Request request) {
        int seed = request.getSeed();
        Prime prime;
        try {
            prime = primeRepository.findById(Long.valueOf(seed)).orElseThrow();
        } catch (Exception e) {
            busyWait();
            return "Prime not found";
        }
        primeRepository.delete(prime);
        return "Prime deleted";
    }

    @PutMapping("/prime/edit/{seed}")
    public Prime editPrime(@PathVariable(value = "seed") int seed, @RequestBody Request request) {
        Prime prime;
        try {
            prime = primeRepository.findById(Long.valueOf(seed)).orElseThrow();
        } catch (Exception e) {
            return null;
        }
        prime.setSeed(request.getSeed());
        return prime;
    }

    public void busyWait() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 2000) {
            // Burn CPU
        }
    }
}
