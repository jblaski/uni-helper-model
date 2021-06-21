package com.jblaski.unihelpermodel.model;
// TODO work out how to handle this entity
//
//  from https://www.hesa.ac.uk/collection/c20061/unistats_dataset_file_structure
//        CourseLocation.LOCID 	Provider's own identifier for a teaching location 	0/1 	2
//        CourseLocation.UCASCOURSEID 	UCAS course code(s) for the KISCourse 	0/unbounded 	4
//
//  from csv
//        UBUKPRN,UKPRN,KISCOURSEID,KISMODE,LOCID

public class CourseLocation {
    private String locationId;
    private String ucasCourseCodes;

}
