package com.andreis.loans.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class Properties {

    private String mgs;
    private String buildVersion;
    private Map<String,String> mailDetails;
    private List<String> activeBranches;

}
