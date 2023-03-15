package 文字对战游戏;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
/*需求:
 1.英雄进行对战，对战时显示xx打了xx一下，造成了xx伤害，xx还剩xx点血
 2.英雄数值可由玩家自行输入
 3.伤害可以闪避，也可以暴击
 */
public class Role {
  private int HP;//血量
  private String name;
  private int hurt;//伤害
    public int getHP(){
        return HP;
    }

    public int getHurt() {
        Random r=new Random();
        int a=r.nextInt(3);
        if(a==0)
            return 0;
        if(a==1)
            return hurt;
        if(a==2)
            return 2*hurt;
        else
            return 404;
    }

    public String getName(){
         return name;
    }
    public void setRole(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请按顺序输入你的英雄数值");
        System.out.print("名字:");
        String name=sc.next();
        this.name=name;
        System.out.print("血量:");
        int HP=sc.nextInt();
        this.HP=HP;
        System.out.print("伤害:");
        int hurt=sc.nextInt();
        this.hurt=hurt;
        System.out.println("创建英雄成功!");
        System.out.println("\n");
    }

    public void getRole(int i){
        System.out.println("英雄"+(i+1)+":");
        System.out.print("名字:"+this.name+"\n");
        System.out.print("血量:"+this.HP+"\n");
        System.out.print("伤害:"+this.hurt+"\n");
        System.out.println("\n");
    }

    public void battle(int a1,String c1,int a2,String c2,List<Role> RoleList,int input1,int input2) {
        System.out.println("\n");
        System.out.println("比赛开始!");
        while(true) {
            int b1=RoleList.get(input1).getHurt();
            int b2=RoleList.get(input2).getHurt();

            a2=a2-b1;
            if(a2<=0) {
                System.out.println(c1 + "变身蓝色妖姬," + c2 + "瞬间气势大减," + c1 +"乘胜追击,造成了" + b1 + "伤害," + c2 + "临死前说道:小黑子有本事别吃我鸽鸽下的蛋");
                System.out.println(c2 + "含泪倒下了");
                break;
            }

            if(b1!=0&&b1==2*b1)
                System.out.println(c1 + "对着" + c2 + "的要害就是一拳,造成了" + b1 + "点伤害," + c2 + "被打的嗷嗷大叫,还剩" + a2+ "点血");
            if(b1==0)
                System.out.println(c1 + "弱弱地捏了捏" + c2 + "的肉肉,造成了" + b1 + "点伤害," + c2 + "不痛不痒,还剩" + a2+ "点血");
            else
                System.out.println(c1 + "给了" + c2 + "一个DBD,造成了" + b1 + "点伤害," + c2 + "大喊:你干嘛~,还剩" + a2+ "点血");

            a1=a1-b2;
            if(a1<=0) {
                System.out.println("\t\t\t"+c2 + "对" + c1 + "发动了最后一击,造成了" + b2 + "点伤害," + c1 + "愤怒地说道:年轻人不讲武德");
                System.out.println(c1 + "含泪倒下了");
                break;
            }

            if(b2!=0&&b2==2*b2)
                System.out.println("\t\t\t"+c2 +"越想越气,晚上在被子里扎布娃娃,对" + c1 + "造成了成吨精神攻击,并附带" + b2 + "点伤害," + c1 + "晚上彻夜难眠,还剩"+ a1+ "点血");
            if(b2==0)
                System.out.println("\t\t\t"+c2 +"刚想出手肚子疼了起来,不仅" + c1 + "只受到了" + b2 + "点伤害而且还被"+c1+"疯狂嘲讽," + c1 + "捧腹大笑,还剩"+ a1 +"点血");
            else
                System.out.println("\t\t\t"+c2 + "反手也给了" + c1 + "一个DBD,造成了" + b2 + "点伤害," + c1 + "啧啧道:小黑子,还剩" + a1 + "点血");
        }
        System.out.println("比赛结束!");
        System.out.println("\n");
    }
}
