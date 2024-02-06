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

    public List<Users> getUserByName(String name, Integer sortedId) {
        if(sortedId==1){
            return membersRepository.findByNameASC(name);
        }
        if(sortedId==2){
            return membersRepository.findByNameDESC(name);
        }
        return membersRepository.findAll();
    }

    public List<Users> getUserByPersonalNumber(String personalNumber) {
        if(personalNumber!=null){
            return membersRepository.getUserByPersonalNumber(personalNumber);
        }
        return membersRepository.findAll();
    }

    public List<Users> getUserByEmail(String email) {
        if (email!=null){
            return membersRepository.getUserByEmail(email);
        }
        return membersRepository.findAll();
    }

    public List<Users> getUserByPhoneNumber(String phoneNumber) {
        if(phoneNumber!=null){
            return membersRepository.getUserByPhoneNumber(phoneNumber);
        }
        return membersRepository.findAll();
    }
}
