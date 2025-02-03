package org.fastcampus.post.domain.content;

public class CommentContent extends Content{
  private static final int MAX_POST_LENGTH = 100;
  public CommentContent(String content) {
    super(content);
  }

  @Override
  protected void checkText(String contents) {
    if(contents == null || contents.isEmpty()) {
      throw new IllegalArgumentException();
    }

    if(contents.length() > MAX_POST_LENGTH) {
      throw new IllegalArgumentException();
    }
  }


}
