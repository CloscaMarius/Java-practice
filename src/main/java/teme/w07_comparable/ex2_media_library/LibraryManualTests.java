package teme.w07_comparable.ex2_media_library;

public class LibraryManualTests {

    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        Library lib = getPopulatedLibrary();

        System.out.println("--- Top 20 ---");
        lib.getTop20().forEach(System.out::println);

        System.out.println("--- Archive ---");
        lib.getArchive().forEach(System.out::println);

        System.out.println("video1: " + lib.findByTitle("video1"));
        System.out.println("video_invalid: " + lib.findByTitle("video_invalid"));

        System.out.println("With 10-12 downloads: " + lib.findByNoOfDownloads(10, 12));

        System.out.println("All mp3: " + lib.findByType(MediaType.MP3));

        lib.updateDownloads("video1", 100);
        System.out.println("After updating video1 to 100 downloads:");
        System.out.println("--- Top 20 ---");
        lib.getTop20().forEach(System.out::println);
    }

    //just a helper method used for tests manual and junit test, it builds and populates a demo library
    static Library getPopulatedLibrary() {
        Library lib = new Library();
        lib.addMedia(
                new Book("book1", "auth1", "pub1", 301),
                new Book("book2", "auth1", "pub1", 302),
                new Book("book3", "auth1", "pub1", 303),
                new Book("book4", "auth1", "pub1", 304),
                new Book("book5", "auth1", "pub1", 305),
                new Book("book6", "auth1", "pub1", 306),
                new Book("book7", "auth1", "pub1", 307),
                new Book("book8", "auth1", "pub1", 308),
                new Book("book9", "auth1", "pub1", 309),
                new Book("book10", "auth1", "pub1", 10),
                new Book("book11", "auth1", "pub1", 11),
                new Book("book12", "auth1", "pub1", 12),
                new Book("book13", "auth1", "pub1", 13),
                new Book("book14", "auth1", "pub1", 14),
                new Book("book15", "auth1", "pub1", 15));
        lib.addMedia(
                new Mp3("mp31", "singer1", "album1", 201),
                new Mp3("mp32", "singer1", "album1", 202),
                new Mp3("mp33", "singer1", "album1", 203),
                new Mp3("mp34", "singer1", "album1", 204),
                new Mp3("mp35", "singer1", "album1", 205),
                new Mp3("mp36", "singer1", "album1", 6),
                new Mp3("mp37", "singer1", "album1", 7));
        lib.addMedia(
                new Video("video1", 120, true, 101),
                new Video("video2", 110, true, 102),
                new Video("video3", 180, true, 103),
                new Video("video4", 60, true, 104),
                new Video("video5", 90, true, 105),
                new Video("video6", 90, true, 5));
        return lib;
    }
}