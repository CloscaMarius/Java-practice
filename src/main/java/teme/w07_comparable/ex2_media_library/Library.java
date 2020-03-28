package teme.w07_comparable.ex2_media_library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Library {


    private List<MediaEntity> media = new ArrayList<MediaEntity>();

    public List<MediaEntity> getTop20() {
        if (media.isEmpty()) {
            return new ArrayList<MediaEntity>();
        }

        media.sort(new sortMedia());

        List<MediaEntity> listTop20 = new ArrayList<>();
        for (int i = 0; i < media.size(); i++) {
            if (i < 20) {

                listTop20.add(media.get(i));
            }
        }

        return listTop20;
    }


    public List<MediaEntity> getArchive() {
        if (media.isEmpty()) {
            return new ArrayList<MediaEntity>();
        }

        media.sort(new sortMedia());

        List<MediaEntity> outOfTop20 = new ArrayList<>();
        for (int i = 0; i < media.size(); i++) {
            if (i >= 20) {
                outOfTop20.add(media.get(i));
            }
        }
        return outOfTop20;
    }

    static class sortMedia implements Comparator<MediaEntity> {

        @Override
        public int compare(MediaEntity t0, MediaEntity t1) {
            return -Integer.compare(t0.getNoOfDownloads(), t1.getNoOfDownloads());
        }
    }

    void addMedia(MediaEntity... medias) { //using varargs params, you can handle 'medias' as an array of MediaEntity objects inside the function
        for (MediaEntity m : medias) {
            media.add(m);
        }
    }

    List<MediaEntity> findByType(MediaType type) {
        List<MediaEntity> mediaType = new ArrayList<>();
        for (MediaEntity m : media) {
            if (m.getType() == type) {
                mediaType.add(m);
            }
        }
        mediaType.sort(new sortMedia());
        return mediaType;
    }

    List<MediaEntity> findByTitle(String title) {
        List<MediaEntity> mediaTitle = new ArrayList<>();
        for (MediaEntity m : media) {
            if (m.getTitle() == title) {
                mediaTitle.add(m);
            }
        }
        return mediaTitle;
    }

    List<MediaEntity> findByNoOfDownloads(int min, int max) {
        List<MediaEntity> mediaDownloads = new ArrayList<>();
        for (MediaEntity m : media) {
            if (m.getNoOfDownloads() >= min && m.getNoOfDownloads() <= max) {
                mediaDownloads.add(m);
            }
        }
        mediaDownloads.sort(new sortMedia());
        return mediaDownloads;
    }

    void updateDownloads(String title, int downloads) {
        for (MediaEntity m : media) {
            if (m.getTitle().equals(title)) {
                m.setNoOfDownloads(downloads);
            }
        }
    }
}
