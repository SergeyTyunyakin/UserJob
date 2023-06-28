package com.testwork.userjob.transfer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.testwork.userjob.model.UserJobInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private String companyName;
    private String description;
    @JsonIgnore
    private Boolean isActivity;

    private List<UserJobInfoDTO> userJobInfo=new ArrayList<>();
}
