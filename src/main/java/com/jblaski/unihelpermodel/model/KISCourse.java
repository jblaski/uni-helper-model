package com.jblaski.unihelpermodel.model;

//  from https://www.hesa.ac.uk/collection/c20061/unistats_dataset_file_structure
//        KISCourse.ASSURL 	URL explaining assessment methods of the course 	1/1 	255
//        KISCourse.ASSURLW 	URL explaining assessment methods of the course in Welsh 	0/1 	255
//        KISCourse.CRSECSTURL 	The URL for the course cost page 	1/1 	255
//        KISCourse.CRSECSTURLW 	The URL for the course cost page in Welsh 	0/1 	255
//        KISCourse.CRSEURL 	The URL for the course page 	1/1 	255
//        KISCourse.CRSEURLW 	The URL for the course page in Welsh 	0/1 	255
//        KISCourse.DISTANCE 	Whether the course is offered wholly through distance learning 	1/1 	255
//        KISCourse.EMPLOYURL 	URL for further details on employment opportunities 	1/1 	255
//        KISCourse.EMPLOYURLW 	URL for further details on employment opportunities in Welsh 	0/1 	255
//        KISCourse.FOUNDATION 	Foundation year availability 	1/1 	1
//        KISCourse.HONOURS 	Honours degree availability 	1/1 	1
//        KISCourse.HECOS 	HECOS code 	0/5 	6
//        KISCourse.KISCOURSEID 	An identifier which uniquely identifies a course within a provider 	1/1 	30
//        KISCourse.KISMODE 	The mode of the KIS course (full-time, part-time, both) 	1/1 	1
//        KISCourse.LDCS 	LDCS (Learn Direct Classification System) code 	0/3 	9
//        KISCourse.LOCCHNGE 	Indicator for if the teaching location changes during any part of the course 	0/1 	1
//        KISCourse.LTURL 	URL explaining Learning and Teaching methods 	1/1 	255
//        KISCourse.LTURLW 	URL explaining Learning and Teaching methods in Welsh 	0/1 	255
//        KISCourse.NHS 	Whether there are any NHS funded students on the course 	0/1 	1
//        KISCourse.NUMSTAGE 	Total number of stages for the course 	0/1 	1
//        KISCourse.SANDWICH 	Sandwich year availability 	1/1 	1
//        KISCourse.SUPPORTURL 	Link to further details on financial support 	1/1 	255
//        KISCourse.SUPPORTURLW 	Link to further details on financial support in Welsh 	0/1 	255
//        KISCourse.TITLE 	The title of the course 	0/1 	255
//        KISCourse.TITLEW 	The title of the course in Welsh 	0/1 	255
//        KISCourse.UCASPROGID 	UCAS programme code(s) for the KISCourse 	0/1 	7
//        KISCourse.UKPRNAPPLY 	UKPRNs through which students can apply to the course 	0/1 	8
//        KISCourse.YEARABROAD 	Study year abroad availability 	1/1 	1
//        KISCourse.KISAIM 	KIS Course qualification aim code 	1/1 	3
//        KISCourse.KISLEVEL 	KIS Course level 	1/1 	1
//        KISCourse.SBJ 	CAH Level subject code 	0/unbounded 	11
//
//  from csv PUBUKPRN,UKPRN,ASSURL,ASSURLW,CRSECSTURL,CRSECSTURLW,CRSEURL,CRSEURLW,DISTANCE,EMPLOYURL,EMPLOYURLW,FOUNDATION,HONOURS,HECOS,HECOS,HECOS,HECOS,HECOS,KISCOURSEID,KISMODE,LDCS,LDCS,LDCS,LOCCHNGE,LTURL,LTURLW,NHS,NUMSTAGE,SANDWICH,SUPPORTURL,SUPPORTURLW,TITLE,TITLEW,UCASPROGID,UKPRNAPPLY,YEARABROAD,KISAIMCODE,KISLEVEL

public class KISCourse {

    private String assessmentUrl;
    private String assessmentUrlWelsh;
    private String courseCostUrl;
    private String courseCostUrlWelsh;
    private String coursePageUrl;
    private String coursePageUrlWelsh;
    private String distance;
    private String employmentOpportunitiesUrl;
    private String employmentOpportunitiesUrlWelsh;
    private String foundation;
    private String honours;
    private String hecos;
    private String kisCourseId;
    private String mode;
    private String learnDirectClassificationSystem;
    private String locationChanges;
    private String learningAndTeachingMethods;
    private String learningAndTeachingMethodsWelsh;
    private String nhs;
    private String numberOfStages;
    private String sandwichAvailability;
    private String financialSupportUrl;
    private String financialSupportUrlWelsh;
    private String title;
    private String titleWelsh;
    private String ucasProgramCodes;
    private String ukprnApplyVia;
    private String yearAbroad;
    private String kisAimCode;
    private String kisLevel;
    private String sbjCahLevelSubjectCode;


}
