package Mealchoosing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MainPage extends JFrame implements MouseListener {
    String[] place = {"北苑一楼", "北苑二楼", "北苑三楼", "西苑一楼", "西苑二楼", "东苑一楼", "东苑二楼", "清真一楼", "清真二楼", "清真三楼"};
    String path = "E:\\IDEA\\Basic-code\\untitled1\\Image\\";

    public MainPage() {
        initJFram();//窗体初始化

        initMenuBar();//菜单初始化

        initImage(); //图片池初始化
    }

    JMenuItem jMenuItem2 = new JMenuItem("作者信息");

    private void initJFram() {
        JFrame jFrame = new JFrame();
        this.setSize(700, 530);
        this.setForeground(Color.CYAN);
        this.setTitle("随机食堂选择系统V1.0");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu1 = new JMenu("选项");
        JMenu jMenu2 = new JMenu("关于我们");
        jMenu2.add(jMenuItem2);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        this.setJMenuBar(jMenuBar);
        jMenuItem2.addMouseListener(this);
    }

    private void initImage() {
        JButton jButton = new JButton(new ImageIcon("E:\\IDEA\\Basic-code\\untitled2\\Mealchoosingimage\\img1.png"));
        jButton.setBounds(250, 340, 130, 50);
        this.getContentPane().add(jButton);
        jButton.addMouseListener(this);
        //背景图片
        JLabel jLabel = new JLabel(new ImageIcon("E:\\IDEA\\Basic-code\\untitled2\\Mealchoosingimage\\img2.png"));
        jLabel.setBounds(0, 0, 688, 458);
        this.getContentPane().add(jLabel);
        this.getContentPane().repaint();//很重要
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Random r = new Random();
        int a = r.nextInt(10);
        JDialog jDialog = new JDialog();
        jDialog.setTitle("Result");
        jDialog.setBounds(0, 0, 300, 300);
        jDialog.setForeground(Color.cyan);
        jDialog.setFont(new Font("仿宋", Font.BOLD, 50));
        jDialog.getContentPane().add(new JLabel("                    废话少说,快去" + place[a] + "吃饭!"));
        jDialog.setLocationRelativeTo(null);
        jDialog.setAlwaysOnTop(true);
        jDialog.setModal(true);
        jDialog.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object ob=e.getSource();
        if(ob==jMenuItem2){
            JLabel jLabel = new JLabel(new ImageIcon(path + "Zezai.png"));//插入图片
            jLabel.setBounds(0, -20, 350, 350);//此时位置是相对与弹窗而不是框体
            jLabel.setLayout(null);
            JDialog jDialog = new JDialog();//创建弹窗对象
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(400, 400);
            jDialog.setTitle("Zezaiya");
            jDialog.setModal(true);//不关闭弹窗无法用其他页面
            jDialog.setAlwaysOnTop(true);//保持窗口最前
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
