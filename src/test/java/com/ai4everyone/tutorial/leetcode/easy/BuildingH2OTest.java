package com.ai4everyone.tutorial.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BuildingH2OTest {
    private static final int MOLECULE_LENGTH = 3;
    private static final char H_CHAR = 'H';
    private static final char O_CHAR = 'O';
    private static final String H_STRING = "H";
    private static final String O_STRING = "O";

    @Test
    void givenInput_whenCreatingOxygenAndHydrogen_thenOutputShouldBeCorrect() throws InterruptedException {
        log.info("BuildingH2OTest#givenInput_whenCreatingOxygenAndHydrogen_thenOutputShouldBeCorrect");
        BuildingH2O buildingH2O = new BuildingH2O();
        String input = "OOHHHH";

        var output = simulateH2OFormation(buildingH2O, input);

        assertEquals(input.length(), output.length());

        for (int counter = 0; counter < output.length(); counter += MOLECULE_LENGTH) {
            String molecule = output.substring(counter, counter + 3);
            long hCount = molecule.chars().filter(ch -> ch == H_CHAR).count();
            long oCount = molecule.chars().filter(ch -> ch == O_CHAR).count();

            assertEquals(2, hCount);
            assertEquals(1, oCount);
        }
    }

    private String simulateH2OFormation(BuildingH2O buildingH2O, String input) throws InterruptedException {
        StringBuffer output = new StringBuffer();

        ExecutorService executor = Executors.newFixedThreadPool(input.length());
        List<Future<?>> futures = new ArrayList<>();

        IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .forEach(c -> {
                    if (c == 'H') {
                        futures.add(executor.submit(() -> {
                            try {
                                buildingH2O.hydrogen(() -> output.append(H_STRING));
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }));
                    } else {
                        futures.add(executor.submit(() -> {
                            try {
                                buildingH2O.oxygen(() -> output.append(O_STRING));
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }));
                    }
                });
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
        return output.toString();
    }
}