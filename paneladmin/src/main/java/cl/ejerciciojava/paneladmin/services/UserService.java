package cl.ejerciciojava.paneladmin.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.ejerciciojava.paneladmin.models.Role;
import cl.ejerciciojava.paneladmin.models.User;
import cl.ejerciciojava.paneladmin.repositories.RoleRepo;
import cl.ejerciciojava.paneladmin.repositories.UserRepo;

@Service
public class UserService {
    private UserRepo uRepo;
    private RoleRepo rRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepo uRepo, RoleRepo rRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.uRepo = uRepo;
        this.rRepo = rRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(rRepo.findByName("ROLE_USER"));
        uRepo.save(user);
    }

    // 2
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(rRepo.findByName("ROLE_ADMIN"));
        uRepo.save(user);
    }

    public User findByEmail(String email) {
        return uRepo.findByEmail(email);
    }

    public void updateUser(User user) {
        user.setUpdatedAt(new Date());
        uRepo.save(user);
    }

    public List<User> allAdmins() {
        List<Role> role = rRepo.findByName("ROLE_ADMIN");
        return role.get(0).getUsers();
    }

    public ArrayList<User> allUsers() {
        return (ArrayList<User>) uRepo.findAll();
    }

    public void makeAdmin(Long id) {
        Optional<User> oUser = uRepo.findById(id);
        List<Role> roles = rRepo.findByName("ROLE_ADMIN");
        if (oUser.isPresent()) {
            User user = oUser.get();
            user.setRoles(roles);
            uRepo.save(user);
        }
    }

    public Optional<User> userAt(Long id) {
        return uRepo.findById(id);
    }

    public void destroyUser(Long id) {
        uRepo.deleteById(id);
    }
}