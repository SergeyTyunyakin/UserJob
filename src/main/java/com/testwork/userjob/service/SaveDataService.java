package com.testwork.userjob.service;

import com.testwork.userjob.model.UserJobInfo;
import com.testwork.userjob.model.Users;
import com.testwork.userjob.repository.CompanyRepository;
import com.testwork.userjob.repository.UserJobInfoRepository;
import com.testwork.userjob.repository.UsersRepository;
import com.testwork.userjob.transfer.UsersFullDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaveDataService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserJobInfoRepository userJobInfoRepository;

    private Long id;
    private String familyName;
    private String middleName;
    private String firstName;
    private LocalDate birthdate;
    private Integer age;
    private String description;
    private Boolean isBlocked;


    public void saveData(UsersFullDTO usersFullDTO) {

        List<UserJobInfo> userJobInfoList = new ArrayList<UserJobInfo>();

        Users user = new Users(usersFullDTO.getUsers().getId(),
                usersFullDTO.getUsers().getFamilyName(),
                usersFullDTO.getUsers().getMiddleName(),
                usersFullDTO.getUsers().getFirstName(),
                usersFullDTO.getUsers().getBirthdate(),
                usersFullDTO.getUsers().getAge(),
                usersFullDTO.getUsers().getDescription(),
                usersFullDTO.getUsers().getIsBlocked(),
                userJobInfoList);

        usersRepository.save(user);
    }

    ;

}
