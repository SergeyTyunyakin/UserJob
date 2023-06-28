package com.testwork.userjob.transfer;

import com.testwork.userjob.model.Company;
import com.testwork.userjob.model.UserJobInfo;
import com.testwork.userjob.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@NoArgsConstructor
public class UsersFullDTO {

    private Users users = new Users();
    private UserJobInfo usersJobInfo = new UserJobInfo();
    private Company company = new Company();

    public UsersFullDTO(Users users){
        this.users = users;
    };

    public UsersFullDTO(Users users, Company company){
        this.users = users;
        this.company = company;
    };

    public UsersFullDTO(Users users, UserJobInfo userJobInfo, Company company){
        this.users = users;
        this.usersJobInfo = userJobInfo;
        this.company = company;
    };

}
