package teme.w07_comparable.ex2_media_library;

import java.util.Objects;

class Video extends MediaEntity {

    private int duration;
    private boolean fullHD;

    Video(String title, int duration, boolean fullHD, int noOfDownloads) {
        super(MediaType.VIDEO, title, noOfDownloads);
        this.duration = duration;
        this.fullHD = fullHD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Video video = (Video) o;
        return duration == video.duration &&
                fullHD == video.fullHD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration, fullHD);
    }

    @Override
    public String toString() {
        return "Video{" +
                "duration=" + duration +
                ", fullHD=" + fullHD +
                '}';
    }
}
