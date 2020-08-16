package com.example.countertest02;

import android.widget.ProgressBar;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operationallogic {
    private static Map<Character,Integer> priority=new HashMap<>();//定义符号优先级
    static{
        priority.put('-',1);
        priority.put('+',1);
        priority.put('*',2);
        priority.put('/',2);
        priority.put('(',0);
    }

    public String forSuffix(String str){//中缀表达式转后缀表达式
        List<String> number=new ArrayList<>();// 存储转化后的结果
        List<Character> stack=new ArrayList<>();//存储符合的栈

        char[] charAff=str.substring(0,str.length()).trim().toCharArray();
        char ch=' ';//存储循环中的当前字符
        int len=0;//用来记录长度
        for(int i=0;i<charAff.length;i++){
            char previous=' ';//存储前一个字符
            if(i>0) previous=charAff[i-1];
            ch=charAff[i];
            if(Character.isDigit(ch)){//当为数字时,len++
                len++;
            }else if (ch=='.'){//当为小数点时,len++
                len++;
            }else if(ch=='-'&&(previous=='*'||previous=='/'||i==0)){//减号当负号时的处理情况:len++且跳过本次循环
                len++;
                continue;
            }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'){//当遇到*-+/()时的情况
                if(len>0){//且有长度时
                    number.add(String.valueOf(Arrays.copyOfRange(charAff,i-len,i)));//将统计到的符号前的这个数存入number中且长度归0
                    len=0;
                }
                if(ch=='('){//当ch为(时将其入栈，并退出本次循环
                    stack.add(ch);
                    continue;
                }
                if(!stack.isEmpty()){//若栈不为空时
                    int last=stack.size()-1;//栈顶符号
                    boolean flag=false;
                    while(last>=0&&ch==')'&&stack.get(last)!='('){//当ch为)时一直将栈顶元素弹出存入number直到弹出(为止, 并始终保证last为栈顶
                        number.add(String.valueOf(stack.remove(last)));
                        last--;
                        flag=true;
                    }
                    if(ch==')'&&stack.get(last)=='('){
                        flag=true;
                    }
                    while(last>=0&&!flag&&priority.get(stack.get(last))>=priority.get(ch)){//如果符号不为(),且栈顶符号的优先级大于当前符号时，弹出栈顶元
                                                                                           //素将其存入number
                        number.add(String.valueOf(stack.remove(last)));
                        last--;
                    }
                }
                if(ch!=')'){//当前元素不为)，就保证其入栈，否则出栈
                    stack.add(ch);
                }else {
                    stack.remove(stack.size()-1);
                }
            }
            if(i==charAff.length-1){//当循环要结束时
                if(len>0){//如果len>0则存储数字进number
                    number.add(String.valueOf(Arrays.copyOfRange(charAff,i-len+1,i+1)));
                }
                int last=stack.size()-1;
                while(last>=0){//将栈中元素全部弹出并存入number,直到栈为空
                    number.add(String.valueOf(stack.remove(last)));
                    last--;
                }
            }
        }
        String temp=number.toString();//将后缀表达式转为字符串并返回
        return temp.substring(1,temp.length()-1);
    }
    public String equal(String str){
        String[] temp=str.split(",");//将后缀表达式按,分隔
        String[] arr=temp;
        for(int i=0;i<arr.length;i++){
            arr[i]=temp[i].replace(" ","");//去除多余的空格
        }
        List<String> list=new ArrayList<>();//存储数字及运算结果
        for (int i = 0; i < arr.length; i++) {
            int size = list.size();
            switch (arr[i]) {
                case "+": BigDecimal a = new BigDecimal(list.remove(size-2)).add(new BigDecimal(list.remove(size-2)));
                          list.add(String.valueOf(a));
                          break;
                case "-": BigDecimal b = new BigDecimal(list.remove(size-2)).subtract(new BigDecimal(list.remove(size-2)));
                          list.add(String.valueOf(b));
                          break;
                case "*": BigDecimal c = new BigDecimal(list.remove(size-2)).multiply(new BigDecimal(list.remove(size-2)));
                          list.add(String.valueOf(c));
                          break;
                case "/":
                          BigDecimal d = new BigDecimal(list.remove(size-2)).divide(new BigDecimal(list.remove(size-2)),
                                  10,BigDecimal.ROUND_HALF_UP);
                          list.add(String.valueOf(d));
                          break;
                default:  list.add(arr[i]);
                          break;
            }
        }
        return list.size() == 1 ? list.get(0) : "表达式错误";//正常情况下list中只有一个元素
    }
}
