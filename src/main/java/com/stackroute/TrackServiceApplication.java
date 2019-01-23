
package com.stackroute;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class TrackServiceApplication implements ApplicationListener<ContextRefreshedEvent> , CommandLineRunner {

        @Autowired
        TrackRepository trackRepository;
        public static void main(String[] args) {
                SpringApplication.run(TrackServiceApplication.class, args);
        }


        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
                trackRepository.save(new Track(1,"hima","error"));
        }

        @Override
        public void run(String...args) throws Exception {
                trackRepository.save(new Track(12,"prabha","highfive"));
        }
}


