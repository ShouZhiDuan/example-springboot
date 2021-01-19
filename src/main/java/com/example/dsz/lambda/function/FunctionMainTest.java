package com.example.dsz.lambda.function;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/15 15:06
 * @Description:
 */
public class FunctionMainTest {

    @FunctionalInterface
    interface Cat {
        String say();
        default String doTest(){
            return  "XXXXXX";
        }
    }

    public static String helpCatSay(Cat cat){
       return cat.say();
    }

    public static String helpDogSay(String word,Dog dog){
        return dog.dogSay(word);
    }

    public static void main(String[] args) {
        System.out.println(helpCatSay(()->{ return "喵喵"; }));
        System.out.println(
                helpDogSay("旺旺",(a)->{
                    return a;
                })
        );



    }


}
