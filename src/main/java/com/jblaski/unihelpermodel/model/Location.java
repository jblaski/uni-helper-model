package com.jblaski.unihelpermodel.model;

//  from https://www.hesa.ac.uk/collection/c20061/unistats_dataset_file_structure
//        Location.ACCOMURL 	URL explaining accommodation costs 	0/1 	255
//        Location.ACCOMURLW 	URL explaining accommodation costs in Welsh 	0/1 	255
//        Location.LOCCOUNTRY 	Country code for a teaching location 	0/1 	2
//        Location.LOCID 	Provider's own identifier for a teaching location 	1/1 	2
//        Location.LOCNAME 	Provider's own location descriptor for a teaching location 	1/1 	100
//        Location.LOCNAMEW 	Provider's own location descriptor for a teaching location in Welsh 	0/1 	100
//        Location.LATITUDE 	Latitude reference point for the teaching location 	1/1 	9
//        Location.LONGITUDE 	Longitude reference point for the teaching location 	1/1 	9
//        Location.LOCUKPRN 	UK Provider Reference Number (UKPRN) for the location of the course 	0/1 	8
//        Location.SUURL 	Student Union URL 	0/1 	255
//        Location.SUURLW 	Student Union URL in Welsh 	0/1 	255
//
//  from csv
//        UKPRN,ACCOMURL,ACCOMURLW,LOCID,LOCNAME,LOCNAMEW,LATITUDE,LONGITUDE,LOCUKPRN,LOCCOUNTRY,SUURL,SUURLW

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Builder
@Data
//@Entity
public class Location {
    private String UKPRN;
    private String ACCOMURL;
    private String ACCOMURLW;
    private String LOCCOUNTRY;
    private String LOCID;
    private String LOCNAME;
    private String LOCNAMEW;
    private String LATITUDE;
    private String LONGITUDE;
    private String LOCUKPRN;
    private String SUURL;
    private String SUURLW;

}
