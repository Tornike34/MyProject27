package com.example.libraryproject.members.membersRepository;

import com.example.libraryproject.members.users.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MembersRepository extends JpaRepository<Users,Long> {
    Optional<Users> getAllByName(String name);
}
