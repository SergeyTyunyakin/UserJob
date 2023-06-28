package com.testwork.userjob.service;

import com.testwork.userjob.model.Company;
import com.testwork.userjob.model.UserJobInfo;
import com.testwork.userjob.model.Users;
import com.testwork.userjob.repository.CompanyRepository;
import com.testwork.userjob.repository.UserJobInfoRepository;
import com.testwork.userjob.repository.UsersRepository;
import com.testwork.userjob.transfer.UsersFullDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public void saveData(UsersFullDTO usersFullDTO) {

//        private Long id;
//        private String companyName;
//        private String description;
//        private LocalDateTime created;
//        private LocalDateTime updated;
//        private Boolean isActivity;
        Company company = new Company(usersFullDTO.getCompany().getId(),
                usersFullDTO.getCompany().getCompanyName(),
                usersFullDTO.getCompany().getDescription(),
                LocalDateTime.now(), null, true, null);
        company.setId(1L);
        companyRepository.save(company);

        List<UserJobInfo> userJobInfoList = new ArrayList<UserJobInfo>();

//        private Long id;
//        @Column(name = "id_company")
//        private Long idCompany;
//        @Column(name = "user_id")
//        private Long userId;
//        private String description;
//        private Boolean isActivity;
//        private LocalDateTime created;
//        private LocalDateTime updated;
        UserJobInfo userJobInfo = new UserJobInfo();


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
