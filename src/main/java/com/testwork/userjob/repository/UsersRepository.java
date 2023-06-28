package com.testwork.userjob.repository;

import com.testwork.userjob.model.Users;
import com.testwork.userjob.transfer.UsersFullDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query(value = "select u from Users u left join u.userJobInfo ui on u.id = ui.userId inner join Company c on c.id = ui.idCompany where u.id = ?1 ")
    List<UsersFullDTO> getAllInfoByUserId(Optional<Long> userId);

    Optional<Users> findOneById(Optional<Long> userId);
}
