package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String trackComments;

    public Track() {
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackComments() {
        return trackComments;
    }

    public void setTrackComments(String trackComments) {
        this.trackComments = trackComments;
    }

    public Track(String trackName, int trackId, String trackComments) {
        this.trackName = trackName;
        this.trackId = trackId;
        this.trackComments = trackComments;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackName='" + trackName + '\'' +
                ", trackId=" + trackId +
                ", trackComments='" + trackComments + '\'' +
                '}';
    }

}