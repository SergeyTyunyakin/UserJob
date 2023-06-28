package com.testwork.userjob.controller;

import com.testwork.userjob.model.Company;
import com.testwork.userjob.model.Users;
import com.testwork.userjob.repository.CompanyRepository;
import com.testwork.userjob.repository.UsersRepository;
import com.testwork.userjob.service.SaveDataService;
import com.testwork.userjob.transfer.UsersFullDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SaveDataService saveDataService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/create-userjob", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUserJob(@RequestBody UsersFullDTO usersFullDTO) {
        if (!usersRepository.findOneById(Optional.ofNullable(usersFullDTO.getUsers().getId())).isEmpty()) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        if (!companyRepository.findOneById(Optional.ofNullable(usersFullDTO.getUsers().getId())).isEmpty()) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        saveDataService.saveData(usersFullDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping(value = "/update-userjob", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUserJob(@RequestBody Users user, @RequestBody Company company) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/get-userjob")
    public <T> ResponseEntity<List<T>> getUserJob(@RequestParam("userid") Optional<Long> userId, @RequestParam("companyid") Optional<Long> companyId) {

        if (!userId.isEmpty()) {
            if (usersRepository.findOneById(userId) != null) {
                return new ResponseEntity(usersRepository.getAllInfoByUserId(userId), HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } else if (!companyId.isEmpty()) {
            if (companyRepository.findOneById(companyId) != null) {
                return new ResponseEntity(companyRepository.findAllById(companyId), HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
