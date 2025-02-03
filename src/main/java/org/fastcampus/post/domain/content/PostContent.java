package org.fastcampus.post.domain.content;

import org.fastcampus.post.domain.content.Content;
import org.fastcampus.user.domain.User;

public class PostContent extends Content {

  private static final int MIN_POST_LENGTH = 5;
  private static final int MAX_POST_LENGTH = 500;

  public PostContent(String content) {
    super(content);
  }

  @Override
  protected void checkText(String contents) {
    if(contents == null || contents.isEmpty()) {
      throw new IllegalArgumentException();
    }

    if(contents.length() < MIN_POST_LENGTH) {
      throw new IllegalArgumentException();
    }

    if(contents.length() > MAX_POST_LENGTH) {
      throw new IllegalArgumentException();
    }
  }

  //private final User author;

  //User 객체자체를 비교하면 가독성자체는 좋다, 하지만 테스트 셋팅을 할때 번거롭다.
  // 하지만 행동기반의 책임을 생각했을때 Long을 받는것은 객체지향에 가깝지 않다.
  // 현재 객체를 주입하는데에는 큰 문제가 없으므로 객체를 주입받는식으로 진행
/*  private final Long id;

  private final User author;
  private final PostContent content;

  public PostContent(Long id, User author, PostContent content) {
    if(content == null ) {
      throw new IllegalArgumentException();
    }

    //this.author = author;
    this.id = id;
    this.author = author;
    this.content = content;
  }*/


}
