package teme.w07_comparable.ex0_warmup;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * MAX GRADE: 5p
 */
@RunWith(GradeRunner.class)
public class SetOperationsTest {

    @Test
    @Grade(1)
    public void union() {
        assertEquals(setOf(), SetOperations.union(setOf(), setOf()));
        assertEquals(setOf("ab"), SetOperations.union(setOf(), setOf("ab")));
        assertEquals(setOf("ab", "cd"), SetOperations.union(setOf("ab"), setOf("cd")));
        assertEquals(setOf("ab", "cd", "ef"), SetOperations.union(setOf("ab", "cd"), setOf("cd", "ef")));
    }

    @Test
    @Grade(2)
    public void intersection() {
        assertEquals(setOf(), SetOperations.intersection(setOf(), setOf()));
        assertEquals(setOf(), SetOperations.intersection(setOf("ab"), setOf("cd")));
        assertEquals(setOf("cd"), SetOperations.intersection(setOf("ab", "cd"), setOf("cd")));
        assertEquals(setOf("cd", "ef"), SetOperations.intersection(setOf("ab", "cd", "ef"), setOf("cd", "ef", "gf")));
    }

    @Test
    @Grade(2)
    public void difference() {
        assertEquals(setOf(), SetOperations.difference(setOf(), setOf()));
        assertEquals(setOf(), SetOperations.difference(setOf(), setOf("ab")));
        assertEquals(setOf("ab"), SetOperations.difference(setOf("ab"), setOf()));
        assertEquals(setOf("ab"), SetOperations.difference(setOf("ab"), setOf("cd")));
        assertEquals(setOf("cd"), SetOperations.difference(setOf("cd"), setOf("ab")));
        assertEquals(setOf("ab"), SetOperations.difference(setOf("ab", "cd"), setOf("cd", "ef")));
        assertEquals(setOf("ef"), SetOperations.difference(setOf("cd", "ef"), setOf("ab", "cd")));
        assertEquals(setOf("ab"), SetOperations.difference(setOf("ab", "cd", "ef"), setOf("cd", "ef", "gf")));
    }

    private static Set<String> setOf(String... values) {
        return new HashSet<>(Arrays.asList(values));
    }
}
