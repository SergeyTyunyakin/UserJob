package com.testwork.userjob.repository;

import com.testwork.userjob.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findOneById(Optional<Long> companyId);

    List<Company> findAllById(Optional<Long> companyId);
}
