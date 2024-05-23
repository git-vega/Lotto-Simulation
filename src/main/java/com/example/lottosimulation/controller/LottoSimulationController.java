package com.example.lottosimulation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class LottoSimulationController {
    @GetMapping("/api/lotto-numbers")
    public Map<String, Object> getLottoNumbers() {
        int[] winningNumbers = drawLottoNumbers();
        int superNumber = drawSuperNumber();

        Map<String, Object> response = new HashMap<>();
        response.put("winningNumbers", winningNumbers);
        response.put("superNumber", superNumber);

        return response;
    }

    private int[] drawLottoNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 6) {
            numbers.add(random.nextInt(49) + 1);
        }

        int[] result = new int[6];
        int index = 0;
        for (int number : numbers) {
            result[index++] = number;
        }

        Arrays.sort(result);
        return result;
    }

    private int drawSuperNumber() {
        Random random = new Random();
        return random.nextInt(10); // Superzahl is from 0 to 9
    }
}

