package com.jblaski.unihelpermodel.model;

//  TODO split entities into resources and entities (e.g. raw copy of csv in strings vs meaningful datatypes)
//  from https://www.hesa.ac.uk/collection/c20061/unistats_dataset_file_structure
//        Institution.UKPRN 	UK provider reference number, which is the unique identifier allocated to providers by the UK Register of Learning Providers (UKRLP) 	1/1 	8
//        Institution.PUBUKPRN 	Publication UK provider reference number for where the course is primarily taught 	1/1 	8
//        Institution.COUNTRY 	Country of provider (England, Wales, Northern Ireland, Scotland) 	1/1 	2
//        Institution.PUBUKPRNCOUNTRY 	Country of publication provider (England, Wales, Northern Ireland, Scotland) 	1/1 	2
//        Institution.APROutcome 	Outcome of Annual Provider Review (APR) 	0/1 	1
//        Institution.TEFOutcome 	Outcome of Provider's Teaching Excellence Framework (TEF) review 	0/1 	1
//        Institution.SUURL 	Student Union URL 	1/1 	255
//        Institution.SUURLW 	Student Union URL in Welsh 	0/1 	255
//
//  from csv
//        PUBUKPRN,UKPRN,COUNTRY,PUBUKPRNCOUNTRY,TEFOutcome,APROutcome,SUURL,SUURLW

public class Institution {
    private long ukprn;
    private long publicationUkprn;
    private String country;
    private String publicationCountry;
    private String annualProviderReviewOutcome;
    private String teachingExcellenceFramework;
    private String studentUnionUrl;
    private String studentUnionUrlWelsh;
}
