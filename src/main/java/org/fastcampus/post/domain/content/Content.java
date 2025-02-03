package org.fastcampus.post.domain.content;

import org.fastcampus.post.domain.common.DateTimeInfo;

public abstract class Content {
  //다형성 활용을 위해 추상클래스 작성
  //추상화를 하지 않았다면 -> Post객체에서 if(Post) if(content) 검증내용들이 생성자에 포함되었을것
  // 이렇게되면 테스트가 어려워지고 하나의 메소드에서 하는 로직이 복잡해지고 if문 뎁스지옥에 빠질수 있음
   // 역할단위로 객체를 나누기!


  String contentText;
  final DateTimeInfo dateTimeInfo;

  protected Content(String contentText) {
    checkText(contentText);
    this.contentText = contentText;
    this.dateTimeInfo = new DateTimeInfo();
  }

  public void updateContent(String updateContent) {
    checkText(updateContent);
    this.contentText = updateContent;
    this.dateTimeInfo.updateEditDatetime();
  }

  protected abstract void checkText(String contents);

  public String getContentText() {
    return contentText;
  }

}
