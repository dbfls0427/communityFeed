package org.fastcampus.user.domain.application.interfaces;

import org.fastcampus.user.domain.User;

public interface UserRelationRepository {

  //id가아닌 도메인 객체 전체를 넘기는이유
  // User의 카운트도 같이 업데이트도 되어야하기때문
  // 트랜잭션 단위로 같이 변경되어야하면 객체를 같이 던져주는게 유지보수에 용이
  boolean isAlreadyFollow(User user, User targetUser);

  void save(User user, User targetUser);

  void delete(User user, User targetUser);


}
