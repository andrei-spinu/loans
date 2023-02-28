package com.andreis.loans.repository;

import com.andreis.loans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    List<Loan> findByCustomerIdOrderByStartDateDesc(Long customerId);
}
