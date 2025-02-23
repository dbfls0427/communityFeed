package org.fastcampus.user.domain.application;

import java.util.IllegalFormatException;
import java.util.IllformedLocaleException;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.fastcampus.user.domain.application.dto.CreateUserRequestDto;
import org.fastcampus.user.domain.application.interfaces.UserRepository;

public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(CreateUserRequestDto dto) {
    UserInfo info = new UserInfo(dto.name(), dto.profileImageUrl());
    User user = new User(0L, info);
    return userRepository.save(user);
  }

  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow(IllformedLocaleException::new);
  }
}
