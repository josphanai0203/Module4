package app.service;

import app.entity.User;
import app.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService<User>{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public void add(User user) {
        iUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }
}
