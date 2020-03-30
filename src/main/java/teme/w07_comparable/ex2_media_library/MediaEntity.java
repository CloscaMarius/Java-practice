package teme.w07_comparable.ex2_media_library;

import java.util.Objects;

abstract class MediaEntity /*implements Comparable<MediaEntity>*/ {

    private MediaType type;
    private String title;
    private int noOfDownloads;

    MediaEntity(MediaType type, String title, int noOfDownloads) {
        this.type = type;
        this.title = title;
        this.noOfDownloads = noOfDownloads;
    }

    String getTitle() {
        return title;
    }

    public MediaType getType() {
        return type;
    }

    public int getNoOfDownloads() {
        return noOfDownloads;
    }

    public void setNoOfDownloads(int noOfDownloads) {
        this.noOfDownloads = noOfDownloads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MediaEntity)) return false;
        MediaEntity that = (MediaEntity) o;
        return noOfDownloads == that.noOfDownloads &&
                type == that.type &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, noOfDownloads);
    }

    @Override
    public String toString() {
        return "MediaEntity{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", noOfDownloads=" + noOfDownloads +
                '}';
    }
}
