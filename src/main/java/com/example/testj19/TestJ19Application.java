package com.example.testj19;

import com.example.testj19.models.Animal;
import com.example.testj19.models.Dog;
import com.example.testj19.models.User;
import com.example.testj19.services.CodinGame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class TestJ19Application implements CommandLineRunner {
    final CodinGame codinGame;

    public TestJ19Application(CodinGame codinGame) {
        this.codinGame = codinGame;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestJ19Application.class, args);
    }

    @Override
    public void run(String... args) {
//        testRange();
//        int closest0 = codinGame.getClosest0(null);
//        System.out.println(closest0);
//        codinGame.computeCheckDigit("39847");
//        System.out.println(codinGame.hash("hello"));
        demoTypeSalih();
    }

    private void testRange() {
        var list = IntStream.range(1, 5)
            .boxed()
            .collect(Collectors.toList());

        System.out.println(list);
    }

    private void listTest() {
        List<String> list = new ArrayList<>();
        list.add("Toto");
        list.add("Tata");
        list.add("Titi");

        System.out.println();
    }

    private void demoTypeSalih() {
        Animal doggy = new Dog("Doggy");
        doggy.eat();
    }

}
