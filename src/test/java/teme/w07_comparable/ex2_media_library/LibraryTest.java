package teme.w07_comparable.ex2_media_library;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.*;

/**
 * MAX GRADE: 30p
 */
@RunWith(GradeRunner.class)
public class LibraryTest {

    @Test
    @Grade(3)
    public void testEquals() {

        //these should be seen as equal (all fields the same)
        assertEquals(
                new Book("book15", "auth1", "pub1", 15),
                new Book("book15", "auth1", "pub1", 15));
        assertEquals(
                new Mp3("mp31", "singer1", "album1", 1),
                new Mp3("mp31", "singer1", "album1", 1));
        assertEquals(
                new Video("video1", 10, true, 1),
                new Video("video1", 10, true, 1));

        //these should be seen as not equal (at least 1 field is different)
        assertNotEquals(
                new Book("book15", "auth1", "pub1", 15),
                new Book("!book15", "auth1", "pub1", 15));
        assertNotEquals(
                new Book("book15", "auth1", "pub1", 15),
                new Book("book15", "!auth1", "pub1", 15));
        assertNotEquals(
                new Book("book15", "auth1", "pub1", 15),
                new Book("book15", "auth1", "!pub1", 15));
        assertNotEquals(
                new Book("book15", "auth1", "pub1", 15),
                new Book("book15", "auth1", "pub1", 16));

        assertNotEquals(
                new Mp3("mp31", "singer1", "album1", 1),
                new Mp3("!mp31", "singer1", "album1", 1));
        assertNotEquals(
                new Mp3("mp31", "singer1", "album1", 1),
                new Mp3("mp31", "!singer1", "album1", 1));
        assertNotEquals(
                new Mp3("mp31", "singer1", "album1", 1),
                new Mp3("mp31", "singer1", "!album1", 1));
        assertNotEquals(
                new Mp3("mp31", "singer1", "album1", 1),
                new Mp3("mp31", "singer1", "album1", 2));

        assertNotEquals(
                new Video("video1", 10, true, 1),
                new Video("!video1", 10, true, 1));
        assertNotEquals(
                new Video("video1", 10, true, 1),
                new Video("video1", 99, true, 1));
        assertNotEquals(
                new Video("video1", 10, true, 1),
                new Video("video1", 10, false, 1));
        assertNotEquals(
                new Video("video1", 10, true, 1),
                new Video("video1", 10, true, 2));
    }

    @Test
    @Grade(1)
    public void testHashCode() {

        //these should be considered equal, so should have exactly the same hashCode
        assertEquals(
                new Book("book15", "auth1", "pub1", 1).hashCode(),
                new Book("book15", "auth1", "pub1", 1).hashCode());
        assertEquals(
                new Mp3("mp31", "singer1", "album1", 1).hashCode(),
                new Mp3("mp31", "singer1", "album1", 1).hashCode());
        assertEquals(
                new Video("video1", 10, true, 1).hashCode(),
                new Video("video1", 10, true, 1).hashCode());
    }

    @Test
    @Grade(2)
    public void testEmptyLib() {
        Library lib = new Library();
        assertTrue(lib.getTop20().isEmpty());
        assertTrue(lib.getArchive().isEmpty());
        assertTrue(lib.findByType(MediaType.MP3).isEmpty());
        assertTrue(lib.findByNoOfDownloads(0, 1000).isEmpty());
        assertTrue(lib.findByTitle("video1").isEmpty());
        lib.updateDownloads("video1", 10);
        assertTrue(lib.findByNoOfDownloads(0, 1000).isEmpty());
    }


    @Test
    @Grade(3)
    public void testAddMedia() {
        Library lib = new Library();
        lib.addMedia(new Book("book1", "auth1", "pub1", 10));

        assertTrue(lib.findByType(MediaType.MP3).isEmpty());
        assertFalse(lib.findByType(MediaType.BOOK).isEmpty());

        assertFalse(lib.findByNoOfDownloads(0, 1000).isEmpty());
        assertTrue(lib.findByNoOfDownloads(0, 5).isEmpty());

        assertTrue(lib.findByTitle("video1").isEmpty());
        assertFalse(lib.findByTitle("book1").isEmpty());

        assertEquals(1, lib.getTop20().size());
        assertEquals("book1", lib.getTop20().get(0).getTitle());
    }

    @Test
    @Grade(2)
    public void testArchive_remainsEmptyWhenNotNeeded() {
        Library lib = new Library();
        assertTrue(lib.getTop20().isEmpty());
        assertTrue(lib.getArchive().isEmpty());

        lib.addMedia(new Book("book1", "auth1", "pub1", 10));
        lib.addMedia(new Book("book2", "auth1", "pub1", 15));

        assertTrue(lib.getTop20().size() < 20);
        assertTrue("while top20 is not full, archive should remain empty", lib.getArchive().isEmpty());
    }

    @Test
    @Grade(2)
    public void testArchive_containsItemsOutsideTop20WhenNeeded() {
        Library lib = LibraryManualTests.getPopulatedLibrary();
        assertEquals(20, lib.getTop20().size());
        assertTrue(lib.getArchive().size() > 0);
        assertEquals(
                Arrays.asList("book14", "book13", "book12", "book11", "book10", "mp37", "mp36", "video6"),
                lib.getArchive().stream().map(MediaEntity::getTitle).collect(toList()));
    }

    @Test
    @Grade(3)
    public void testTop20() {
        Library lib = LibraryManualTests.getPopulatedLibrary();

        assertEquals(
                Arrays.asList("book9", "book8", "book7", "book6", "book5", "book4", "book3", "book2", "book1", "mp35", "mp34", "mp33", "mp32", "mp31", "video5", "video4", "video3", "video2", "video1", "book15"),
                lib.getTop20().stream().map(MediaEntity::getTitle).collect(toList()));
    }

    @Test
    @Grade(3)
    public void testUpdateDownloads() {

        Library lib = LibraryManualTests.getPopulatedLibrary();
        assertEquals(20, lib.getTop20().size());
        assertEquals(new Book("book9", "auth1", "pub1", 309), lib.getTop20().get(0));

        lib.updateDownloads("video1", 400);
        assertEquals(20, lib.getTop20().size());
        assertEquals(new Video("video1", 120, true, 400), lib.getTop20().get(0));
        assertEquals(new Book("book9", "auth1", "pub1", 309), lib.getTop20().get(1));
    }

    @Test
    @Grade(3)
    public void testFindByType_returnsRightSetOfResults() {
        Library lib = LibraryManualTests.getPopulatedLibrary();

        assertEquals(
                new HashSet<>(Arrays.asList("book9", "book8", "book7", "book6", "book5", "book4", "book3", "book2", "book1", "book15", "book14", "book13", "book12", "book11", "book10")),
                lib.findByType(MediaType.BOOK).stream().map(MediaEntity::getTitle).collect(toSet()));

        assertEquals(
                new HashSet<>(Arrays.asList("mp35", "mp34", "mp33", "mp32", "mp31", "mp37", "mp36")),
                lib.findByType(MediaType.MP3).stream().map(MediaEntity::getTitle).collect(toSet()));

        assertEquals(
                new HashSet<>(Arrays.asList("video5", "video4", "video3", "video2", "video1", "video6")),
                lib.findByType(MediaType.VIDEO).stream().map(MediaEntity::getTitle).collect(toSet()));
    }

    @Test
    @Grade(1)
    public void testFindByType_returnsResultsSortedDescendingByDownloads() {
        Library lib = LibraryManualTests.getPopulatedLibrary();

        assertEquals(
                Arrays.asList("book9", "book8", "book7", "book6", "book5", "book4", "book3", "book2", "book1", "book15", "book14", "book13", "book12", "book11", "book10"),
                lib.findByType(MediaType.BOOK).stream().map(MediaEntity::getTitle).collect(toList()));

        assertEquals(
                Arrays.asList("mp35", "mp34", "mp33", "mp32", "mp31", "mp37", "mp36"),
                lib.findByType(MediaType.MP3).stream().map(MediaEntity::getTitle).collect(toList()));

        assertEquals(
                Arrays.asList("video5", "video4", "video3", "video2", "video1", "video6"),
                lib.findByType(MediaType.VIDEO).stream().map(MediaEntity::getTitle).collect(toList()));
    }

    @Test
    @Grade(3)
    public void testFindByDownloads_returnsRightSetOfResults() {
        Library lib = LibraryManualTests.getPopulatedLibrary();

        assertTrue(lib.findByNoOfDownloads(400, 1000).isEmpty());

        assertEquals(
                new HashSet<>(Arrays.asList("book12", "book11", "book10", "mp37", "mp36", "video6")),
                lib.findByNoOfDownloads(1, 12).stream().map(MediaEntity::getTitle).collect(toSet()));
    }

    @Test
    @Grade(1)
    public void testFindByDownloads_returnsResultsSortedDescendingByDownloads() {
        Library lib = LibraryManualTests.getPopulatedLibrary();
        assertEquals(
                Arrays.asList("book12", "book11", "book10", "mp37", "mp36", "video6"),
                lib.findByNoOfDownloads(1, 12).stream().map(MediaEntity::getTitle).collect(toList()));
    }

    @Test
    @Grade(3)
    public void testFindByTitle() {
        Library lib = LibraryManualTests.getPopulatedLibrary();
        assertTrue(lib.findByTitle("book16").isEmpty());
        assertEquals(
                singletonList(new Book("book15", "auth1", "pub1", 15)),
                lib.findByTitle("book15"));
        assertEquals(
                singletonList(new Video("video1", 120, true, 101)),
                lib.findByTitle("video1"));
    }
}
