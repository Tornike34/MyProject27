package com.example.libraryproject.members.memberController;

import com.example.libraryproject.members.memberService.MembersService;
import com.example.libraryproject.members.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MembersController {
    @Autowired
    private MembersService membersService;

    @GetMapping
    public ResponseEntity<List<Users>> getUsers(){
        List<Users> users = membersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody Users users){
        membersService.addUser(users);
        return new ResponseEntity<>("User was added successfully", HttpStatus.OK);

    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
            membersService.deleteUserById(id);
        return new ResponseEntity<>("User was deleted successfully",HttpStatus.OK);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUsers){
        updatedUsers.setId(id);
        Users updateUserData = membersService.updateUsers(updatedUsers);
        return ResponseEntity.ok(updateUserData);

    }

}
