package teme.w08_streams.ex4_person_registry;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.*;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 20p
 */
@SuppressWarnings({"ConstantConditions", "RedundantCast"})
@RunWith(GradeRunner.class)
public class PersonsRegistryWithStreamsTest {
    private final static double DELTA = 0.001; //precision used for comparing doubles

    @Test
    @Grade(1)
    public void testPerson_constructors_equalsAndHashCode() {
        List<Person> persons = new ArrayList<>();
        for (int cnp : Arrays.asList(20, 111)) {
            for (String name : Arrays.asList("Ion", "ion", "true")) {
                for (int age : Arrays.asList(20, 21)) {
                    for (boolean voted : Arrays.asList(true, false)) {
                        Person p1 = new Person(cnp, name, age, voted);
                        Person p2 = new Person(cnp, name, age, voted);
                        assertEquals("should be equal", p1, p2);
                        assertEquals("should have same hashCode: p1=" + p1 + ", p2=" + p2, p1.hashCode(), p2.hashCode());
                        persons.add(p1);
                    }
                }
            }
        }
        assertEquals(24, persons.size());
        assertEquals(24, persons.stream().distinct().count()); //seems to use hashCode only
        for (Person p1 : persons) {
            for (Person p2 : persons) {
                if (p1 != p2) {
                    assertNotEquals("should not be equal: p1=" + p1 + ",p2=" + p2, p1, p2);
                }
            }
        }
    }

    @Test
    @Grade(1)
    public void testRegisterAndCount() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();
        assertEquals(0, r.count());

        r.register(new Person(111, "aaa", 20, true));
        assertEquals(1, r.count());

        r.register(new Person(222, "aaa", 20, true));
        assertEquals(2, r.count());
    }

    @Test
    @Grade(1)
    public void testRegister_skipDuplicateCNP() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();
        r.register(new Person(111, "aaa", 20, true));
        r.register(new Person(222, "aaa", 20, true));
        r.register(new Person(333, "aaa", 20, true));
        assertEquals(3, r.count());

        r.register(new Person(333, "aaa", 20, true));
        assertEquals(3, r.count());
    }

    @Test
    @Grade(1)
    public void testUnregister() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();
        r.register(new Person(111, "aaa", 20, true));
        r.register(new Person(222, "aaa", 20, true));
        r.register(new Person(333, "aaa", 20, true));
        assertEquals(3, r.count());

        r.unregister(222);
        assertEquals(2, r.count());
        r.unregister(111);
        assertEquals(1, r.count());
        r.unregister(333);
        assertEquals(0, r.count());

        r.unregister(333);
        assertEquals(0, r.count());
    }

    @Test
    @Grade(1)
    public void test_getCnps() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();
        assertTrue(r.cnps().isEmpty());

        r.register(new Person(111, "aaa", 20, true));
        r.register(new Person(222, "aaa", 20, true));
        r.register(new Person(333, "aaa", 20, true));
        assertEquals(newSet(111, 222, 333), r.cnps());
    }

    @Test
    @Grade(2)
    public void test_findByCnp() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();
        assertNull(r.findByCnp(0));
        assertNull(r.findByCnp(111));

        r.register(new Person(111, "aaa", 20, true));
        r.register(new Person(222, "aaa", 20, true));
        r.register(new Person(333, "aaa", 20, true));
        assertNull(r.findByCnp(0));
        assertNull(r.findByCnp(444));

        assertEquals(new Person(333, "aaa", 20, true), r.findByCnp(333));
    }

    @Test
    @Grade(2)
    public void test_getUniqueNames() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();
        assertEquals(newSet(), r.cnps());

        r.register(new Person(111, "aaa", 20, true));
        r.register(new Person(222, "bbb", 20, true));
        r.register(new Person(333, "aaa", 20, true));
        assertEquals(newSet("aaa", "bbb"), r.uniqueNames());
    }

    @Test
    @Grade(2)
    public void test_findByName() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();
        assertEquals(newSet(), r.findByName("aaa"));

        r.register(new Person(111, "aaa", 20, true));
        r.register(new Person(222, "bbb", 20, true));
        r.register(new Person(333, "aaa", 20, true));

        assertEquals(
                newSet(new Person(111, "aaa", 20, true),
                        new Person(333, "aaa", 20, true)),
                r.findByName("aaa"));
        assertEquals(
                newSet(new Person(222, "bbb", 20, true)),
                r.findByName("bbb"));
        assertEquals(newSet(), r.findByName("ccc"));
    }

    @Test
    @Grade(1)
    public void test_findByName_isCaseInsensitive() {
        PersonsRegistry r = (PersonsRegistry) new PersonsRegistryWithStreams();

        r.register(new Person(111, "Aaa", 20, true));
        r.register(new Person(222, "bbb", 20, true));
        r.register(new Person(333, "aaA", 20, true));

        assertEquals(
                newSet(new Person(111, "Aaa", 20, true),
                        new Person(333, "aaA", 20, true)),
                r.findByName("AAA"));
    }

    @Test
    @Grade(1)
    public void test_averageAge() {
        assertEquals(16.6, sampleRegistry().averageAge(), DELTA);
    }

    @Test
    @Grade(1)
    public void test_averageAge_empty() {
        assertEquals(0, ((PersonsRegistry) new PersonsRegistryWithStreams()).averageAge(), DELTA);
    }

    @Test
    @Grade(2)
    public void adultsPercentage() {
        assertEquals(40.0, sampleRegistry().adultsPercentage(), DELTA);
    }

    @Test
    @Grade(1)
    public void adultsPercentage_empty() {
        assertEquals(0, ((PersonsRegistry) new PersonsRegistryWithStreams()).adultsPercentage(), DELTA);
    }

    @Test
    @Grade(2)
    public void adultsWhoVotedPercentage() {
        assertEquals(50.0, sampleRegistry().adultsWhoVotedPercentage(), DELTA);
    }

    @Test
    @Grade(1)
    public void adultsWhoVotedPercentage_empty() {
        assertEquals(0, ((PersonsRegistry) new PersonsRegistryWithStreams()).adultsWhoVotedPercentage(), DELTA);
    }

    private PersonsRegistry sampleRegistry() {
        PersonsRegistry reg = (PersonsRegistry) new PersonsRegistryWithStreams();
        reg.register(new Person(1234, "Ion", 14, false));
        reg.register(new Person(2233, "Ana", 12, false));
        reg.register(new Person(2678, "Ana", 3, false));
        reg.register(new Person(1235, "Costel", 21, false));
        reg.register(new Person(2367, "Maria", 33, true));
        return reg;
    }

    //helper method for easy building a new Set with some given elements (of a custom type)
    private static Set<Object> newSet(Object... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }
}
