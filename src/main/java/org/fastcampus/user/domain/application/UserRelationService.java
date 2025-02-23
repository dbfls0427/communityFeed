package org.fastcampus.user.domain.application;

import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.application.dto.FollowUserRequestDto;
import org.fastcampus.user.domain.application.interfaces.UserRelationRepository;

public class UserRelationService {

  private final UserService userService;

  private final UserRelationRepository userRelationRepository;

  public UserRelationService(UserService userService,
      UserRelationRepository userRelationRepository) {
    this.userService = userService;
    this.userRelationRepository = userRelationRepository;
  }

  public void follow(FollowUserRequestDto dto) {
    User user = userService.getUser(dto.userId());
    User targetUser = userService.getUser(dto.targetUserId());

    if(userRelationRepository.isAlreadyFollow(user,targetUser)) {
      throw new IllegalArgumentException();
    }

    user.follow(targetUser);
    userRelationRepository.save(user, targetUser);
  }

  public void unfollow(FollowUserRequestDto dto) {
    User user = userService.getUser(dto.userId());
    User targetUser = userService.getUser(dto.targetUserId());

    if(userRelationRepository.isAlreadyFollow(user,targetUser)) {
      throw new IllegalArgumentException();
    }

    user.follow(targetUser);
    userRelationRepository.delete(user, targetUser);
  }

}
