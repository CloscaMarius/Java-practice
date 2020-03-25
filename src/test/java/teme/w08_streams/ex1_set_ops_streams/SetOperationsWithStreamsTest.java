package teme.w08_streams.ex1_set_ops_streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * MAX GRADE: 15p
 */
@RunWith(GradeRunner.class)
public class SetOperationsWithStreamsTest {

    @Test
    @Grade(5)
    public void union() {
        assertEquals(setOf(), SetOperationsWithStreams.union(setOf(), setOf()));
        assertEquals(setOf("ab"), SetOperationsWithStreams.union(setOf(), setOf("ab")));
        assertEquals(setOf("ab", "cd"), SetOperationsWithStreams.union(setOf("ab"), setOf("cd")));
        assertEquals(setOf("ab", "cd", "ef"), SetOperationsWithStreams.union(setOf("ab", "cd"), setOf("cd", "ef")));
    }

    @Test
    @Grade(5)
    public void intersection() {
        assertEquals(setOf(), SetOperationsWithStreams.intersection(setOf(), setOf()));
        assertEquals(setOf(), SetOperationsWithStreams.intersection(setOf("ab"), setOf("cd")));
        assertEquals(setOf("cd"), SetOperationsWithStreams.intersection(setOf("ab", "cd"), setOf("cd")));
        assertEquals(setOf("cd", "ef"), SetOperationsWithStreams.intersection(setOf("ab", "cd", "ef"), setOf("cd", "ef", "gf")));
    }

    @Test
    @Grade(5)
    public void difference() {
        assertEquals(setOf(), SetOperationsWithStreams.difference(setOf(), setOf()));
        assertEquals(setOf(), SetOperationsWithStreams.difference(setOf(), setOf("ab")));
        assertEquals(setOf("ab"), SetOperationsWithStreams.difference(setOf("ab"), setOf()));
        assertEquals(setOf("ab"), SetOperationsWithStreams.difference(setOf("ab"), setOf("cd")));
        assertEquals(setOf("cd"), SetOperationsWithStreams.difference(setOf("cd"), setOf("ab")));
        assertEquals(setOf("ab"), SetOperationsWithStreams.difference(setOf("ab", "cd"), setOf("cd", "ef")));
        assertEquals(setOf("ef"), SetOperationsWithStreams.difference(setOf("cd", "ef"), setOf("ab", "cd")));
        assertEquals(setOf("ab"), SetOperationsWithStreams.difference(setOf("ab", "cd", "ef"), setOf("cd", "ef", "gf")));
    }

    private static Set<String> setOf(String... values) {
        return new HashSet<>(Arrays.asList(values));
    }
}