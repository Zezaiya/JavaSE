package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;


//主页面
public class GameJFrame extends JFrame implements KeyListener, ActionListener {//继承了JFrame后相当于定义了一个窗口
    String path = "E:\\IDEA\\Basic-code\\untitled1\\Image\\";//简化代码
    int[][] arr = new int[4][4];//加载图片时用数组中的数据
    int[][] rightarr = {{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16},};
    String[] photoshop1 = {"xiugou",  "squirrel"};//动物
    String[] photoshop2 = {"personA", "personB", "personC"};//人物
    String[] photoshop3 = {"viewA", "viewB", "viewC"};//风景
    StringBuilder sb = new StringBuilder();//存放当前图片
    int x, y;//记录空白图片的位置
    int m=0;
    int b=0;
    int count = 0;//步数
    //创建条目对象(更换图片)(重新开始)(重新登录)(关闭游戏) | (作者信息)
    JMenu jMenu3 = new JMenu("重新开始");//因为有二级菜单
    JMenuItem jMenuItem2 = new JMenuItem("重新登录");
    JMenuItem jMenuItem3 = new JMenuItem("关闭游戏");

    JMenuItem jMenuItem4 = new JMenuItem("作者信息");
    JMenuItem jMenuItem5 = new JMenuItem("动物");
    JMenuItem jMenuItem6 = new JMenuItem("人物");//添加二级目录5,6,7
    JMenuItem jMenuItem7 = new JMenuItem("风景");

    public GameJFrame() {//空参构造
        initJFrame(); //初始化窗体

        initMenuBar();//初始化菜单

        initData();//打乱顺序

        initImage(randomphoto(1));//将打乱后的图片进行显示,默认为动物类

        this.setVisible(true);//显示方法,true为显示，false为隐藏,一般放在最后
    }

    private void initData() {//初始化数据，打乱顺序
        int[] tempArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int a = r.nextInt(tempArr.length);
            int tmp = tempArr[i];
            tempArr[i] = tempArr[a];
            tempArr[a] = tmp;
        }
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tempArr[n] == 1) {
                    x = i;
                    y = j;//记录空白方块的坐标
                }
                arr[i][j] = tempArr[n];
                n++;
            }
        }
    }

    private void initImage(String photo) {
        //清空原有的所有图片,不然新生成的页面会出现在原图片后面被遮住
        this.getContentPane().removeAll();
        //判断是否已经拼好
        if (judge()) {
            //显示胜利的图片
            JLabel winlabel = new JLabel(new ImageIcon(path + "win.png"));
            winlabel.setBounds(110, 300, 620, 182);
            this.getContentPane().add(winlabel);
        }

        //统计步数
        JLabel steplabel = new JLabel("步数:" + count);//直接添加文字
        steplabel.setBounds(650, 0, 200, 50);
        this.add(steplabel);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个JLabel的对象(管理容器)
                int number = arr[i][j]; //并获取加载图片的序号
                JLabel jLabel = new JLabel(new ImageIcon(path + photo + number + ".png"));
                //指定图片位置
                jLabel.setBounds(180 * i + 58, 180 * j + 120, 180, 180);//整张图片定位是看图片左上角的坐标
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED) {//添加边框样式0或1
                });
                //把管理容器添加框体中
                this.getContentPane().add(jLabel);//此时这个框体并不是整个框体，菜单下面的一整块才是该框体，是专门给组件的框体
            }
        }

        //创建背景对象
        JLabel background = new JLabel(new ImageIcon(path + "Background.png"));
        background.setBounds(-60, -35, 950, 950);
        this.getContentPane().add(background);


        //重绘图片
        this.getContentPane().repaint();
    }

    private void initMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上两个选项的对象(功能)(关于我们)
        JMenu jMenu1 = new JMenu("功能");
        JMenu jMenu2 = new JMenu("关于我们");


        //将条目添加到选项中
        jMenu1.add(jMenu3);
        jMenu1.add(jMenuItem2);//将前三个条目添加到功能选项中
        jMenu1.add(jMenuItem3);
        jMenu2.add(jMenuItem4);//将作者信息这个条目添加到关于我们这个选项中

        //添加二级目录
        jMenu3.add(jMenuItem5);
        jMenu3.add(jMenuItem6);
        jMenu3.add(jMenuItem7);

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);//将两个选项添加到菜单里

        jMenu3.addActionListener(this);
        jMenuItem2.addActionListener(this);
        jMenuItem3.addActionListener(this);
        jMenuItem4.addActionListener(this);
        jMenuItem5.addActionListener(this);
        jMenuItem6.addActionListener(this);
        jMenuItem7.addActionListener(this);
        this.setJMenuBar(jMenuBar);//给整个界面设置菜单（把菜单jMenuBar这个整体放进框架里）

    }

    private void initJFrame() {
        //this表示当前调用者的地址值
        this.setSize(850, 950);//设置窗口宽高
        this.setTitle("拼图单机版 V1.0");//设置页面标题
        this.setAlwaysOnTop(true);//保持窗口最前
        this.setLocationRelativeTo(null);//保持页面居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//3--表示关闭一个窗口就结束程序   2--表示关闭最后一个程序才结束程序    (都需要在每一个页面都写上)
        this.setLayout(null);//取消图片默认居中
        this.addKeyListener(this); //为窗体创建键盘监听事件
        this.setVisible(true);
    }

    private boolean judge() {//判断当前数组是否和正确数组相同
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != rightarr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private String randomphoto(int n) {//表示需要随机选取哪一类的图片
        sb.delete(0,sb.length());//清空builder容器内数据
        Random r = new Random();
        if (n == 1) {
            int a = r.nextInt(photoshop1.length) ;
            sb.append(photoshop1[a]);
            return photoshop1[a];
        } else if (n == 2) {
            int a = r.nextInt(photoshop2.length) ;
            sb.append(photoshop2[a]);
            return photoshop2[a];
        } else if (n == 3) {
            int a = r.nextInt(photoshop3.length) ;
            sb.append(photoshop3[a]);
            return photoshop3[a];
        }
        return photoshop1[1];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {//按下不松查看原图片
        if (judge()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();//清空所有图片
            JLabel jLabel = new JLabel(new ImageIcon(path + sb.toString()+".png"));//加载完整图片
            jLabel.setBounds(55, 115, 720, 720);//设置完整图片大小
            jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
            this.getContentPane().add(jLabel);//放进框体里
            JLabel background = new JLabel(new ImageIcon(path + "Background.png"));//加载背景图片
            background.setBounds(-60, -35, 950, 950);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //当游戏胜利后不能再用键盘输入故需要再进行判断
        if (judge()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 37) {
            if (x != 3) {                //防止索引越界
                arr[x][y] = arr[x + 1][y];//左键--空白与右边方块位置互换
                arr[x + 1][y] = 1;
                x++;
                count++;
                initImage(sb.toString());
            }
                    /*else
                        return;*/
        } else if (code == 38) {
            if (y != 3) {
                arr[x][y] = arr[x][y + 1];//上键--空白与下边方块位置互换
                arr[x][y + 1] = 1;
                y++;
                count++;
                initImage(sb.toString());
            }
                    /*else
                        return;*/
        } else if (code == 39) {
            if (x != 0) {
                arr[x][y] = arr[x - 1][y];//右键--空白与左边方块位置互换
                arr[x - 1][y] = 1;
                x--;
                count++;
                initImage(sb.toString());
            }
                    /*else
                        return;*/
        } else if (code == 40) {
            if (y != 0) {
                arr[x][y] = arr[x][y - 1];//下键--空白与上边方块位置互换
                arr[x][y - 1] = 1;
                y--;
                count++;
                initImage(sb.toString());
            }
                    /*else
                        return;*/
        } else if (code == 65) {
            initImage(sb.toString());//表示按下a键松开后press方法结束触发release事件调用该方法实现返回上一级
        } else if (code == 87) {//作弊码w
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = rightarr[i][j];  //直接把正确顺序的数组给arr
                }
            }
            initImage(sb.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();//获取被点击的对象
        if (ob == jMenuItem2) {
            this.setVisible(false); //关闭当前游戏界面,removeAll只能把窗体内容抹去，无法关闭窗体
            new LoginJFrame(); //打开登录界面
        } else if (ob == jMenuItem3) {
            System.exit(0);//退出程序，使用visibel的话无法关闭程序，只能隐藏框体
        } else if (ob == jMenuItem4) {
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
        } else if (ob == jMenuItem5) {//动物
            initData();//打乱顺序
            initImage(randomphoto(1));
        } else if (ob == jMenuItem6) {
            initData();//打乱顺序
            initImage(randomphoto(2));
        } else if (ob == jMenuItem7) {
            initData();//打乱顺序
            initImage(randomphoto(3));
        }
    }
}
