package com.stackroute.controller;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="api/v1")

public class TrackController {

    @Autowired
    private TrackRepository trackRepository;
    @GetMapping("/track")

    public List<Track> retrieveAllTracks() {

        return trackRepository.findAll();
    }

    @GetMapping("/track/{id}")
    public Track retrieveTrack(@PathVariable int id)
    {
        Optional<Track> track = trackRepository.findById(id);
        return track.get();
    }
    @DeleteMapping("/track/{id}")
    public void deleteTrack(@PathVariable int id)
    {

        trackRepository.deleteById(id);
    }

    @PostMapping("/track")

    public ResponseEntity<Object> createTrack(@RequestBody Track track) {

        ResponseEntity responseEntity;
        try
        {
            trackRepository.save(track);

            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        }catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @PutMapping("/track/{id}")
    public ResponseEntity<Object> updateTrack(@RequestBody Track track, @PathVariable int id) {

        Optional<Track> trackOptional = trackRepository.findById(id);
        if (!trackOptional.isPresent())
            return ResponseEntity.notFound().build();
        track.setTrackId(id);
        trackRepository.save(track);
        return ResponseEntity.noContent().build();

    }

}

