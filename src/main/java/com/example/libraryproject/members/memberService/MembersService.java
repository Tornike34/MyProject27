package com.example.libraryproject.members.memberService;

import com.example.libraryproject.members.membersRepository.MembersRepository;
import com.example.libraryproject.members.users.Users;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersService {
    private final MembersRepository membersRepository;
    @Autowired

    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }
    public List<Users> getAllUsers(){
        return membersRepository.findAll();
    }
    public void addUser(@NotNull Users users){
        Users user = new Users(users.getName(),
                users.getPersonalNumber(),
                users.getEmail(),
                users.getPhoneNumber());
        membersRepository.save(user);
    }

    public void deleteUserById(Long id) {
        membersRepository.deleteById(id);
    }

    public Users updateUsers(Users updatedUsers) {
        return membersRepository.save(updatedUsers);
    }
}
