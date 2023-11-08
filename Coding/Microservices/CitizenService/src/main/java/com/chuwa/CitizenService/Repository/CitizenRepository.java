package com.chuwa.CitizenService.Repository;

import com.chuwa.CitizenService.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {

    public List<Citizen> findAllByVaccinationCenterId(Long id);
}
