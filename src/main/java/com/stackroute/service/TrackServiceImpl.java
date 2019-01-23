package com.stackroute.service;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Service Implementation

@Service
public class TrackServiceImpl implements TrackService{

   private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if( trackRepository.existsById(track.getTrackId()))
        {
            throw new TrackAlreadyExistsException("Track Already Exist");
        }
        Track savedTrack=trackRepository.save(track);

        if( savedTrack == null )
        {
            throw new TrackAlreadyExistsException("Track Already Exist");
        }
        return savedTrack;
    }
//ALL TRACKS
    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public int deleteTrack(int id) throws TrackNotFoundException {

        if( !trackRepository.existsById(id) )
        {
            throw new TrackNotFoundException("ID is not found");
        }
        trackRepository.deleteById(id);

        return 0;
    }
//UPDATE OF TRACKS
    @Override
    public Track updateTrack(Track track){
        Track updateTrack= trackRepository.save(track);
        return updateTrack;
    }
//GET THE TRACK BY ITS ID
    @Override
    public Optional<Track> getTrackById(int id) throws TrackNotFoundException{


        if(trackRepository.existsById(id))
        {
            return trackRepository.findById(id);
        }
        else
        {

            throw new TrackNotFoundException("Given ID is not there");
        }
    }
//GET THE TRACK BY IT'S NAME
    @Override
    public List<Track> getTrackByName(String name) throws TrackNotFoundException {

        if( trackRepository.getTrackByName(name) == null )
        {
            throw new TrackNotFoundException("TrackName doesn't Exist");
        }
        return trackRepository.getTrackByName(name);
    }

}