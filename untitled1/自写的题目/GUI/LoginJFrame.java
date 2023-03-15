package GUI;

import javax.swing.*;
//登录页面
public class LoginJFrame extends JFrame {
    public LoginJFrame(){
        this.setSize(488,430);//this表示当前调用者的地址值
        this.setTitle("登录界面");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
}
