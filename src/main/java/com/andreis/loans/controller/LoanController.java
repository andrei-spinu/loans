package com.andreis.loans.controller;

import com.andreis.loans.config.LoanServiceConfig;
import com.andreis.loans.model.Customer;
import com.andreis.loans.model.Loan;
import com.andreis.loans.model.Properties;
import com.andreis.loans.repository.LoanRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@AllArgsConstructor
public class LoanController {

    private final LoanRepository loanRepository;
    private final LoanServiceConfig loanServiceConfig;

    @PostMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestBody Customer customer) {
        return loanRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());

    }

    @GetMapping("/properties")
    public String getPropertyDetails() throws JsonProcessingException {

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Properties properties = Properties.builder()
                .mgs(loanServiceConfig.getMsg())
                .buildVersion(loanServiceConfig.getBuildVersion())
                .mailDetails(loanServiceConfig.getMailDetails())
                .activeBranches(loanServiceConfig.getActiveBranches())
                .build();

        return objectWriter.writeValueAsString(properties);
    }
}
