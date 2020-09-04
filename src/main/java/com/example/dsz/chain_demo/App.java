package com.example.dsz.chain_demo;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/3 17:36
 * @Description:
 */
public class App {

    static IVacateAuth iVacateAuth;

    void setUp(){
        Teacher2Auth teacher2Auth = new Teacher2Auth();
        teacher2Auth.start();
        Teacher1Auth teacher1Auth = new Teacher1Auth(teacher2Auth);
        teacher1Auth.start();
        iVacateAuth = new SelfAuth(teacher1Auth);
        ((SelfAuth)iVacateAuth).start();
    }

    public static void main(String[] args) {
        App app = new App();
        app.setUp();
        Vacate vacate = new Vacate();
        iVacateAuth.next(vacate);
    }


}
