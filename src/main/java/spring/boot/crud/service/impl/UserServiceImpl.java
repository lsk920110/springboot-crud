package spring.boot.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import spring.boot.crud.entity.UserEntity;
import spring.boot.crud.repository.UserRepository;
import spring.boot.crud.service.UserService;
import spring.boot.crud.vo.user.UserVO;

public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity registUser(UserVO params) {
        UserEntity userEntity = new UserEntity();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String enc_pw = bCryptPasswordEncoder.encode(params.getPassword());

        userEntity.setUser_id(params.getUser_id());
        userEntity.setUser_name(params.getUser_name());
        userEntity.setRole(params.getRole());
        userEntity.setPassword(enc_pw);

        userEntity = this.userRepository.save(userEntity);

        return userEntity;
    }
}
