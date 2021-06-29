package com.jblaski.unihelpermodel;

import com.jblaski.unihelpermodel.model.KISCourse;
import com.jblaski.unihelpermodel.parsing.KISCourseParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringBootApplication
public class UniHelperModelApplication {

	@Autowired
	private Environment env;

	@Autowired
	private KISCourseRepository kisCourseRepository;

	public static void main(String[] args) {
		SpringApplication.run(UniHelperModelApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {
		if (env.getProperty("initializeDatabases").equals("true")) {
			log.info("initializeDatabase set to TRUE");
			List<KISCourse> kisCourses = KISCourseParser.readAllFromFile("data/KISCOURSE.csv");
			kisCourses.forEach(course -> {
				kisCourseRepository.save(course);
			});
			log.info("Finished initializing KISCOURSE table - saved " + kisCourses.size() + " KISCourses");
		} else {
			log.info("initializeDatabase set to FALSE");
		}
		List<KISCourse> byUKPRN = kisCourseRepository.findByUKPRN("10001143");
		System.out.println(byUKPRN.size());
	}
}
