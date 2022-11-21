package spring.boot.crud.service;

import spring.boot.crud.entity.UserEntity;
import spring.boot.crud.vo.user.UserVO;

public interface UserService {

    UserEntity registUser(UserVO params);
}
