package com.example.testj19;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class TestJ19Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestJ19Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testRange();
    }

    private void testRange() {
        var list = IntStream.range(1, 5)
            .boxed()
            .collect(Collectors.toList());

        System.out.println(list);
    }

}
