/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.yuil;

import com.menu.MenuGroup;
import com.util.Prompt;
import com.yuil.dao.InfoDao;
import com.yuil.dao.OrderDao;
import com.yuil.dao.StockDao;
import com.yuil.dao.mysql.InfoDaoImpl;
import com.yuil.dao.mysql.OrderDaoImpl;
import com.yuil.dao.mysql.StockDaoImpl;
import com.yuil.handler.info.InfoAddHandler;
import com.yuil.handler.info.InfoDeleteHandler;
import com.yuil.handler.info.InfoListHandler;
import com.yuil.handler.info.InfoModifyHandler;
import com.yuil.handler.info.InfoViewHandler;
import com.yuil.handler.stock.StockAddHandler;
import com.yuil.handler.stock.StockDeleteHandler;
import com.yuil.handler.stock.StockListHandler;
import com.yuil.handler.stock.StockModifyHandler;
import com.yuil.handler.stock.StockViewHandler;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {

    Prompt prompt = new Prompt(System.in);
    MenuGroup mainMenu;

    InfoDao infoDao;
    OrderDao orderDao;
    StockDao stockDao;

    App() {
        prepareDatabase();
        prepareMenu();
    }

    public static void main(String[] args) {
        System.out.println("[정육 관리 시스템]");
        new App().run();
    }

    void prepareDatabase() {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://db-ld28a-kr.vpc-pub-cdb.ntruss.com/meatdb",
                "meat", "Bitcamp!@#123");

            infoDao = new InfoDaoImpl(con);
            orderDao = new OrderDaoImpl(con);
            stockDao = new StockDaoImpl(con);

        } catch (Exception e) {
            System.out.println("통신 오류!");
            e.printStackTrace();
        }
    }

    void prepareMenu() {
        mainMenu = MenuGroup.getInstance("메인");

        MenuGroup infoMenu = mainMenu.addGroup("상품 정보");
        infoMenu.addItem("등록", new InfoAddHandler(infoDao, prompt));
        infoMenu.addItem("조회", new InfoViewHandler(infoDao, prompt));
        infoMenu.addItem("변경", new InfoModifyHandler(infoDao, prompt));
        infoMenu.addItem("삭제", new InfoDeleteHandler(infoDao, prompt));
        infoMenu.addItem("목록", new InfoListHandler(infoDao, prompt));

        MenuGroup stockMenu = mainMenu.addGroup("재고 관리");
        stockMenu.addItem("등록", new StockAddHandler(stockDao, infoDao ,prompt));
        stockMenu.addItem("조회", new StockViewHandler(stockDao, prompt));
        stockMenu.addItem("변경", new StockModifyHandler(stockDao, prompt));
        stockMenu.addItem("삭제", new StockDeleteHandler(stockDao, prompt));
        stockMenu.addItem("목록", new StockListHandler(stockDao, prompt));

//        MenuGroup orderMenu = mainMenu.addGroup("주문 관리");
//        orderMenu.addItem("등록", new OrderAddHandler(orderDao, prompt));
//        orderMenu.addItem("조회", new OrderViewHandler(orderDao, prompt));
//        orderMenu.addItem("변경", new OrderModifyHandler(orderDao, prompt));
//        orderMenu.addItem("삭제", new OrderDeleteHandler(orderDao, prompt));
//        orderMenu.addItem("목록", new OrderListHandler(orderDao, prompt));


    }

    void run() {
        while (true) {
            try {
                mainMenu.execute(prompt);
                prompt.close();
                break;
            } catch (Exception e) {
                System.out.println("예외 발생!");
            }
        }
    }
}
