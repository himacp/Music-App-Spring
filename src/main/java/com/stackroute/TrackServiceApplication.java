
package com.stackroute;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;



@PropertySource("classpath:application.properties")
@Component
@SpringBootApplication
public class TrackServiceApplication implements ApplicationListener<ContextRefreshedEvent> , CommandLineRunner {


    @Value("${trackId}")
        private int trackId;


        @Value("${trackName}")
        private String trackName;


        @Value("${trackComments}")
        private String trackComments;

        @Autowired
        TrackRepository trackRepository;


        public static void main(String[] args) {
            SpringApplication.run(TrackServiceApplication.class, args);
        }


        @Autowired
        private Environment ev;

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            trackRepository.save(new Track(Integer.parseInt(ev.getProperty("trackId")),ev.getProperty("trackName"),ev.getProperty("trackComments")));

        }


        @Override
        public void run(String...args){
            trackRepository.save(new Track(trackId,trackName,trackComments));


        }
}


