package com.example.libraryproject.members.membersRepository;

import com.example.libraryproject.members.users.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MembersRepository extends JpaRepository<Users,Long> {
    Optional<Users> getAllByName(String name);

    @Query("SELECT u FROM Users u WHERE u.name = :name ORDER BY u.id ASC ")
    List<Users> findByNameASC(String name);
    @Query("SELECT u FROM Users u WHERE u.name = :name ORDER BY u.id DESC ")
    List<Users> findByNameDESC(String name);
    @Query("SELECT u FROM Users u WHERE u.personalNumber = :personalNumber")
    List<Users> getUserByPersonalNumber(String personalNumber);
    @Query("SELECT u FROM Users u WHERE u.email=:email")
    List<Users> getUserByEmail(String email);
    @Query("SELECT u FROM Users u WHERE u.personalNumber=:phoneNumber")
    List<Users> getUserByPhoneNumber(String phoneNumber);
}
