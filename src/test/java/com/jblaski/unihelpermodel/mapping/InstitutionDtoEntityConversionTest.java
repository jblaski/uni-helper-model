package com.jblaski.unihelpermodel.mapping;

import com.jblaski.unihelpermodel.model.Institution;
import com.jblaski.unihelpermodel.resource.InstitutionDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

public class InstitutionDtoEntityConversionTest {

    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void shouldConvertFromDtoToEntity() {
        long publicationUkprn = 100078569;
        long ukprn = 10007856;
        String country = "XI";
        String publicationUkprnCountry = "XF";
        String teachingExcellenceFrameworkOutcome = "Gold";
        String annualProviderReviewOutcome = "none";
        String studentUnionUrl = "http://www.abersu.co.uk/";
        String studentUnionUrlWelsh = "http://www.umaber.co.uk/";

        // the row in the csv
        // 10007856,10007856,XI,XI,Gold,,http://www.abersu.co.uk/,http://www.umaber.co.uk/
        InstitutionDTO institutionDTO = InstitutionDTO.builder()
                                            .publicationUkprn(publicationUkprn) // not real, but different for mapping test
                                            .ukprn(ukprn)
                                            .country(country)
                                            .publicationUkprnCountry(publicationUkprnCountry) // again, not real
                                            .teachingExcellenceFrameworkReviewOutcome(teachingExcellenceFrameworkOutcome)
                                            .annualProviderReviewOutcome(annualProviderReviewOutcome)
                                            .studentUnionUrl(studentUnionUrl)
                                            .studentUnionUrlWelsh(studentUnionUrlWelsh)
                                            .build();

        Institution institution = institutionDTO.toEntity();

        assertEquals(publicationUkprn + "", institution.getPUBUKPRN());
        assertEquals(ukprn + "", institution.getUKPRN());
        assertEquals(country, institution.getCOUNTRY());
        assertEquals(publicationUkprnCountry, institution.getPUBUKPRNCOUNTRY());
        assertEquals(teachingExcellenceFrameworkOutcome, institution.getTEFOutcome());
        assertEquals(annualProviderReviewOutcome, institution.getAPROutcome());
        assertEquals(studentUnionUrl, institution.getSUURL());
        assertEquals(studentUnionUrlWelsh, institution.getSUURLW());
    }

    @Test
    public void shouldConvertFromEntityToDto() {
        String PUBUKPRN = "100078569";
        String UKPRN = "10007856";
        String COUNTRY = "XI";
        String PUBUKPRNCOUNTRY = "XF";
        String TEFOutcome = "Gold";
        String APROutcome = "none";
        String SUURL = "http://www.abersu.co.uk/";
        String SUURLW = "http://www.umaber.co.uk/";

        Institution institution = Institution.builder()
                                    .PUBUKPRN(PUBUKPRN)
                                    .UKPRN(UKPRN)
                                    .COUNTRY(COUNTRY)
                                    .PUBUKPRNCOUNTRY(PUBUKPRNCOUNTRY)
                                    .TEFOutcome(TEFOutcome)
                                    .APROutcome(APROutcome)
                                    .SUURL(SUURL)
                                    .SUURLW(SUURLW)
                                    .build();

        InstitutionDTO institutionDto = institution.toDto();

        assertEquals(PUBUKPRN, institutionDto.getPublicationUkprn() + "");
        assertEquals(UKPRN, institutionDto.getUkprn() + "");
        assertEquals(COUNTRY, institutionDto.getCountry());
        assertEquals(PUBUKPRNCOUNTRY, institutionDto.getPublicationUkprnCountry());
        assertEquals(TEFOutcome, institutionDto.getTeachingExcellenceFrameworkReviewOutcome());
        assertEquals(APROutcome, institutionDto.getAnnualProviderReviewOutcome());
        assertEquals(SUURL, institutionDto.getStudentUnionUrl());
        assertEquals(SUURLW, institutionDto.getStudentUnionUrlWelsh());
    }
}
