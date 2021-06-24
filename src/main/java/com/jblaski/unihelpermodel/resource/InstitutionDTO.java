package com.jblaski.unihelpermodel.resource;

import com.jblaski.unihelpermodel.model.Institution;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InstitutionDTO {
    private long ukprn;
    private long publicationUkprn;
    private String country;
    private String publicationUkprnCountry;
    private String teachingExcellenceFrameworkReviewOutcome;
    private String annualProviderReviewOutcome;
    private String studentUnionUrl;
    private String studentUnionUrlWelsh;

    public Institution toEntity() {
        return Institution.builder()
                .UKPRN(ukprn + "")
                .PUBUKPRN(publicationUkprn + "")
                .COUNTRY(country)
                .PUBUKPRNCOUNTRY(publicationUkprnCountry)
                .APROutcome(annualProviderReviewOutcome)
                .TEFOutcome(teachingExcellenceFrameworkReviewOutcome)
                .SUURL(studentUnionUrl)
                .SUURLW(studentUnionUrlWelsh)
                .build();
    }
}
