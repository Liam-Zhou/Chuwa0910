package com.chuwa.VaccinationCenter.Repository;

import com.chuwa.VaccinationCenter.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<VaccinationCenter,Long> {
}
