package cl.ejerciciojava.adminpanel.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.ejerciciojava.adminpanel.models.Role;
import cl.ejerciciojava.adminpanel.models.User;
import cl.ejerciciojava.adminpanel.repositories.RoleRepository;
import cl.ejerciciojava.adminpanel.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

    // 2
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }

    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void updateUser(User user) {
        user.setUpdatedAt(new Date());
        userRepository.save(user);
    }

    public List<User> allAdmins() {
        List<Role> role = roleRepository.findByName("ROLE_ADMIN");
        return role.get(0).getUsers();
    }

    public ArrayList<User> allUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public void makeAdmin(Long id) {
        Optional<User> user = userRepository.findById(id);
        List<Role> roles = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(roles);
        uRepo.save(user);
    }

    public User userAt(Long id) {
        return uRepo.findOne(id);
    }

    public void destroyUser(Long id) {
        uRepo.delete(id);
    }
}
