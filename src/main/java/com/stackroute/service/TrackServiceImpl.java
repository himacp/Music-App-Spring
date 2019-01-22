package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrackServiceImpl implements TrackService
{
        TrackRepository trackRepository;

        @Autowired
        public TrackServiceImpl(TrackRepository trackRepository) {
            this.trackRepository = trackRepository;
        }

        @Override
        public Track saveTrack(Track track)

        {

            Track savedTrack = trackRepository.save(track);

            return savedTrack;
        }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    }


