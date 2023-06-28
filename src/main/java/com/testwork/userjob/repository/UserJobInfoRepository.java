package com.testwork.userjob.repository;

import com.testwork.userjob.model.UserJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJobInfoRepository extends JpaRepository<UserJobInfo, Long> {
        List<UserJobInfo> findAllByUserId(Long userId);
}
