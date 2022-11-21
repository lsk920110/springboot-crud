package spring.boot.crud.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import spring.boot.crud.entity.UserEntity;
import spring.boot.crud.vo.user.UserVO;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class UserServiceImplTest {

    @Test
    void registUser() {

//        UserEntity userEntity = new UserEntity();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String enc_pw = bCryptPasswordEncoder.encode("1111");
//        System.out.println(enc_pw);
        boolean matches = bCryptPasswordEncoder.matches("1111", enc_pw);
        assertEquals(matches,true);
    }
}