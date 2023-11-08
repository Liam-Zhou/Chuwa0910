package com.chuwa.VaccinationCenter.Controller;

import com.chuwa.VaccinationCenter.Entity.VaccinationCenter;
import com.chuwa.VaccinationCenter.Model.Citizen;
import com.chuwa.VaccinationCenter.Model.RequiredResponse;
import com.chuwa.VaccinationCenter.Repository.CenterRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
@AllArgsConstructor
public class VaccinationCenterController {

    private CenterRepository centerRepository;

    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {

        VaccinationCenter vaccinationCenter1 = centerRepository.save(vaccinationCenter);
        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RequiredResponse> getAllInfo(@PathVariable Long id) {
        RequiredResponse response = new RequiredResponse();

        VaccinationCenter center = centerRepository.findById(id).orElseThrow();
        response.setVaccinationCenter(center);

        List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
        response.setCitizens(citizens);

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

}
