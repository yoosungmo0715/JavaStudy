package bitcamp.myapp.handler.auth;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import bitcamp.util.Session;

public class LogoutHandler extends AbstractMenuHandler {

  protected void action(Prompt prompt) {
      prompt.getSession().invalidate();
      prompt.println("로그아웃 되었습니다.");
  }
}
