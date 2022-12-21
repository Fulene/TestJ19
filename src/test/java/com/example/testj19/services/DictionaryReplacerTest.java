package com.example.testj19.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DictionaryReplacerTest {

    DictionaryReplacer dictionaryReplacer;

    @BeforeEach
    public void init() {
        dictionaryReplacer = new DictionaryReplacer();
    }

    @Test
    public void shouldStringReplacer_ThrowIllegalArgumentException_ifStrIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> dictionaryReplacer.stringReplacer(null, Collections.emptyMap()));
        assertEquals("The input string is null or empty", exception.getMessage());
    }

    @Test
    public void shouldStringReplacer_ThrowIllegalArgumentException_ifStrIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> dictionaryReplacer.stringReplacer("", Collections.emptyMap()));
        assertEquals("The input string is null or empty", exception.getMessage());
    }

    @Test
    public void shouldStringReplacer_returnTheSameStrAsOnEntry_ifDictionaryIsNull() {
        String str = "$temp$ here comes the name $name$";
        assertEquals(str, dictionaryReplacer.stringReplacer(str, null));
    }

    @Test
    public void shouldStringReplacer_returnTheSameStrAsOnEntry_ifDictionaryDoesNotContainAStringIncludedInSource() {
        String str = "$temp$ here comes the name $name$";
        var dictionary = Map.of("tempi", "Temperature", "namei", "Mehdi");
        assertEquals(str, dictionaryReplacer.stringReplacer(str, dictionary));
    }

    @Test
    public void shouldStringReplacer_returnTheSameStrAsOnEntry_ifDictionaryDoesNotContainAStringIncludedInSourceBetween2$() {
        String str = "$temp$ here comes the name $name$";
        var dictionary = Map.of("here", "foo", "the", "bar");
        assertEquals(str, dictionaryReplacer.stringReplacer(str, dictionary));
    }

    @Test
    public void shouldStringReplacer_returnTemperature_whenDictionaryContainTemperatureFor$temp$() {
        String str = "$temp$";
        var dictionary = Map.of("temp", "Temperature");
        assertEquals("Temperature", dictionaryReplacer.stringReplacer(str, dictionary));
    }

    @Test
    public void shouldStringReplacer_returnMehdiHasARabbit_whenDictionaryContainMehdiFor$name$AndRabbitFor$animal$() {
        String str = "$name$ has a $animal$";
        var dictionary = Map.of("name", "Mehdi", "animal", "rabbit");
        assertEquals("Mehdi has a rabbit", dictionaryReplacer.stringReplacer(str, dictionary));
    }

    @Test
    public void shouldStringReplacer_returnTheGoodString() {
        String str = "$name$ has a $animal$. His name is Cookie";
        var dictionary = Map.of("name", "Mehdi", "animal", "rabbit");
        assertEquals("Mehdi has a rabbit. His name is Cookie", dictionaryReplacer.stringReplacer(str, dictionary));
    }

}
