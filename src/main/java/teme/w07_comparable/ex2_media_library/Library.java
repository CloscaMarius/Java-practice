package teme.w07_comparable.ex2_media_library;

import java.util.List;

class Library {

    //TODO: add fields..

    public List<MediaEntity> getTop20() {
        //TODO
        return null;
    }

    public List<MediaEntity> getArchive() {
        //TODO
        return null;
    }

    void addMedia(MediaEntity... medias) { //using varargs params, you can handle 'medias' as an array of MediaEntity objects inside the function
        //TODO
    }

    List<MediaEntity> findByType(MediaType type) {
        //TODO
        return null;
    }

    List<MediaEntity> findByTitle(String title) {
        //TODO
        return null;
    }

    List<MediaEntity> findByNoOfDownloads(int min, int max) {
        //TODO
        return null;
    }

    void updateDownloads(String title, int downloads) {
        //TODO
    }
}
