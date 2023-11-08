package com.chuwa.CitizenService.Controller;

import com.chuwa.CitizenService.Entity.Citizen;
import com.chuwa.CitizenService.Repository.CitizenRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/citizen")
public class CitizenController {

    private CitizenRepository citizenRepository;

    @RequestMapping("/Vaccination_id/{id}")
    public ResponseEntity<List<Citizen>>  getById(@PathVariable Long id) {
        List<Citizen> citizens = citizenRepository.findAllByVaccinationCenterId(id);
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Citizen> createCitizen(@RequestBody Citizen citizen) {
        citizenRepository.save(citizen);
        return new ResponseEntity<>(citizen,HttpStatus.CREATED);
    }
}
