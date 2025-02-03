package org.fastcampus.user.domain;

public class UserInfo {

  /**
   * User 의 유효성 검증을 위한 VO
   */
  private final String name;

  private final String profileImageUrl;

  public UserInfo(String name, String profileImageUrl) {

    if(name == null || name.isEmpty()) {
      throw new IllegalArgumentException();
    }

    this.name = name;
    this.profileImageUrl = profileImageUrl;
  }


}
