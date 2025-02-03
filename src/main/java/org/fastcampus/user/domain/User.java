package org.fastcampus.user.domain;

import java.util.Objects;
import org.fastcampus.common.domain.PositiveIntegerCounter;

public class User {

  private final Long id;

  private final UserInfo info;

  private final PositiveIntegerCounter followingCount;

  private final PositiveIntegerCounter followerCount;

  public Long getId() {
    return id;
  }

  public User(Long id, UserInfo info, PositiveIntegerCounter followingCount,
      PositiveIntegerCounter followerCount) {
    this.id = id;
    this.info = info;
    this.followingCount = followingCount;
    this.followerCount = followerCount;
  }

  public void follow(User targetUser) {
    if(targetUser.equals(this)) {
      throw new IllegalArgumentException();
    }

    followerCount.increase();
    //targetUser.followerCount.increase(); //캡슐화 깨어질수있음
    targetUser.increaseFollowerCount();

  }

  private  void increaseFollowerCount() {
    followerCount.increase();
  }

  private void decreaseFollowerCount() {
    followerCount.decrease();
  }
  public void unfollow(User targetUser) {
    if (this.equals(targetUser)) {
      throw new IllegalArgumentException();
    }

    followingCount.decrease();
    //targetUser.followerCount.decrease();
    targetUser.decreaseFollowerCount();
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
