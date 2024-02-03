package com.yuil.handler.order;


import com.menu.AbstractMenuHandler;
import com.util.Prompt;
import com.yuil.dao.OrderDao;
import com.yuil.handler.PrintType;
import com.yuil.vo.Order;

public class OrderModifyHandler extends AbstractMenuHandler {

  private OrderDao orderDao;
  PrintType c = new PrintType(prompt);
  public OrderModifyHandler(OrderDao orderDao, Prompt prompt) {
    super(prompt);
    this.orderDao = orderDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Order old = orderDao.findBy(no);
    if (old == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Order order = new Order();
    order.setOrderNo(old.getOrderNo()); // 기존 게시글의 번호를 그대로 설정한다.
    order.setClassification(c.getTypeChoice());
    order.setProductName(this.prompt.input("변경 제품(%s)? ", old.getProductName()));
    order.setCount(this.prompt.inputInt("변경 수량(%s)? ", old.getCount()));
    order.setOrderDate(old.getOrderDate());

    orderDao.update(order);
    System.out.println("게시글을 변경했습니다.");
  }
}
