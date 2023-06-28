package com.testwork.userjob.transfer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJobInfoDTO {
    private String description;
    private Boolean isActivity;
}
