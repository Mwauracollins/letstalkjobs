package org.letstalkjobs.letstalkjobs.repositories;

import org.letstalkjobs.letstalkjobs.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByCompanyName(String companyName);

    @Override
    List<Company> findAll();
}
