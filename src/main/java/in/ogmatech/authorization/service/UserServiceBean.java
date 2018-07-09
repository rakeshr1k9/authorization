package in.ogmatech.authorization.service;

import in.ogmatech.authorization.exception.AlreadyExistsException;
import in.ogmatech.authorization.model.User;
import in.ogmatech.authorization.model.UserRole;
import in.ogmatech.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceBean implements UserDetailsService,UserService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {



        user = userRepository.findByUsername(userId);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public boolean isExist(User user) {
        return findById(user.getIdUser())!=null;
    }

    @Override
    public User save(User user) {

        User existing = userRepository.findOne(user.getIdUser());

        if (existing != null) {
            throw new AlreadyExistsException(
                    String.format("There already exists a user with id = %s", user.getIdUser()));
        }

        return userRepository.save(user);
    }

    @Override
    public User findById(Integer idUser) {
        return userRepository.findOne(idUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        /*if (!entityManager.contains(user))
            user = entityManager.merge(user);*/
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer idUser) {
        userRepository.delete(idUser);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
