package teme.w07_comparable.ex2_media_library;

import java.util.Objects;

class Mp3 extends MediaEntity {

    private String singer;
    private String album;

    Mp3(String title, String singer, String album, int noOfDownloads) {
        super(MediaType.MP3, title, noOfDownloads);
        this.album = album;
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mp3)) return false;
        if (!super.equals(o)) return false;
        Mp3 mp3 = (Mp3) o;
        return Objects.equals(singer, mp3.singer) &&
                Objects.equals(album, mp3.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), singer, album);
    }

    @Override
    public String toString() {
        return "Mp3{" +
                "singer='" + singer + '\'' +
                ", album='" + album + '\'' +
                '}';
    }
}
