package com.jblaski.unihelpermodel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class KISCourseId implements Serializable {
    private String UKPRN;
    private String KISCOURSEID;
    private String KISMODE;
}
