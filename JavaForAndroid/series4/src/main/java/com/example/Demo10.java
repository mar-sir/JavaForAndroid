package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 接口有什么用
 * 使用场景:你叫舍友给你收一下衣服，收完之后给你说一声；
 * 建模: CallBack(收完衣服的结果) Sheyou(舍友)  You(你)
 * 接口回调
 */
public class Demo10 {
    public static void main(String[] args) {
        You you = new You();//创建一个你
        Sheyou leifeng = new Sheyou("雷锋");  //创建一个雷锋同学
        you.requestShouyifu(leifeng);//委托雷锋舍友收衣服
    }
}


interface CallBack {
    void result(String msg);
}

class You implements CallBack {
    /**
     * 请求舍友帮你收衣服(客气点)
     *
     * @param sheyou
     */
    public void requestShouyifu(Sheyou sheyou) {
        System.out.println(sheyou.name + "请帮我收一下衣服，要下雨了");
        sheyou.shouyifu(this);
    }

    @Override
    public void result(String msg) {
        System.out.println("我知道" + msg);
    }
}

class Sheyou {
    String name;

    public Sheyou(String name) {
        this.name = name;
    }

    //收衣服
    public void shouyifu(CallBack callBack) {
        System.out.println(this.name + "收衣服中...");
        callBack.result("衣服已经收好了。" + "\t" + this.name + "收的.");
    }
}
