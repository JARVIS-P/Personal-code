package com.example.countertest02;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private String str;
    private EditText editText;
    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();//隐藏自带标题
        actionBar.hide();
        editText=(EditText) findViewById(R.id.edit_text);
        editText.setInputType(InputType.TYPE_NULL);//不呼出软键盘
        //获取按钮实例
        Button button0=(Button) findViewById(R.id.button0);
        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
        Button button4=(Button) findViewById(R.id.button4);
        Button button5=(Button) findViewById(R.id.button5);
        Button button6=(Button) findViewById(R.id.button6);
        Button button7=(Button) findViewById(R.id.button7);
        Button button8=(Button) findViewById(R.id.button8);
        Button button9=(Button) findViewById(R.id.button9);
        Button button_clear=(Button) findViewById(R.id.button_clear);
        Button button_delete=(Button) findViewById(R.id.button_delete);
        Button button_point=(Button) findViewById(R.id.button_point);
        Button button_div=(Button) findViewById(R.id.button_div);
        Button button_x=(Button) findViewById(R.id.button_x);
        Button button_sub=(Button) findViewById(R.id.button_sub);
        Button button_add=(Button) findViewById(R.id.button_add);
        Button button_left=(Button) findViewById(R.id.button_left);
        Button button_right=(Button) findViewById(R.id.button_right);
        Button button_equal=(Button) findViewById(R.id.button_equal);
        //注册监听器
        button0.setOnClickListener((View.OnClickListener) this);
        button1.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
        button5.setOnClickListener((View.OnClickListener) this);
        button6.setOnClickListener((View.OnClickListener) this);
        button7.setOnClickListener((View.OnClickListener) this);
        button8.setOnClickListener((View.OnClickListener) this);
        button9.setOnClickListener((View.OnClickListener) this);
        button_clear.setOnClickListener((View.OnClickListener) this);
        button_delete.setOnClickListener((View.OnClickListener) this);
        button_point.setOnClickListener((View.OnClickListener) this);
        button_div.setOnClickListener((View.OnClickListener) this);
        button_x.setOnClickListener((View.OnClickListener) this);
        button_sub.setOnClickListener((View.OnClickListener) this);
        button_add.setOnClickListener((View.OnClickListener) this);
        button_left.setOnClickListener((View.OnClickListener) this);
        button_right.setOnClickListener((View.OnClickListener) this);
        button_equal.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button0:
                if(!flag){//判断是第一次输入还是等号后输入
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);//前面是0的情况
                editText.append("0");
                break;
            case R.id.button1:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("1");
                break;
            case R.id.button2:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("2");
                break;
            case R.id.button3:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("3");
                break;
            case R.id.button4:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("4");
                break;
            case R.id.button5:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("5");
                break;
            case R.id.button6:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("6");
                break;
            case R.id.button7:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("7");
                break;
            case R.id.button8:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("8");
                break;
            case R.id.button9:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                judge0(editText);
                editText.append("9");
                break;
            case R.id.button_clear:
                editText.setText("");
                break;
            case R.id.button_delete:
                str=editText.getText().toString();
                int num=str.length();
                if(num==0){
                    break;
                }else  editText.getText().delete(num-1,num);
                break;
            case R.id.button_point:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                str=editText.getText().toString();
                int num4=str.length()-1;
                if(num4==-1){
                    editText.append(".");
                    break;
                }
                int m=1;
                for(int i=num4;i>=0;i--){//限制一个数字内只能出现一个.
                    if(str.charAt(i)=='.') m=0;
                    if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/') break;
                }
                if(m==1){
                    editText.append(".");
                }
                break;
            case R.id.button_div:
                if(!flag){
                    flag=!flag;
                }
                str=editText.getText().toString();
                int num1=str.length()-1;
                if(num1==-1) break;//限制/前是+-*的情况
                else if(str.charAt(num1)=='0'||str.charAt(num1)=='1'||str.charAt(num1)=='2'||str.charAt(num1)=='3'||str.charAt(num1)=='4' ||
                        str.charAt(num1)=='5'|| str.charAt(num1)=='6'|| str.charAt(num1)=='7'||str.charAt(num1)=='8'||str.charAt(num1)=='9'||
                        str.charAt(num1)=='.'||str.charAt(num1)==')'){
                    editText.append("/");
                }else if(str.charAt(num1)=='+'||str.charAt(num1)=='-'||str.charAt(num1)=='*'){
                    editText.getText().delete(num1,num1+1);
                    if(str.charAt(num1)=='0'||str.charAt(num1)=='1'||str.charAt(num1)=='2'||str.charAt(num1)=='3'||str.charAt(num1)=='4' ||
                            str.charAt(num1)=='5'|| str.charAt(num1)=='6'|| str.charAt(num1)=='7'||str.charAt(num1)=='8'||str.charAt(num1)=='9'||
                            str.charAt(num1)=='.'||str.charAt(num1)==')') {
                        editText.append("/");
                    }
                }
                break;
            case R.id.button_x:
                if(!flag){
                    flag=!flag;
                }
                str=editText.getText().toString();
                int num2=str.length()-1;
                if(num2==-1) break;
                else if(str.charAt(num2)=='0'||str.charAt(num2)=='1'||str.charAt(num2)=='2'||str.charAt(num2)=='3'||str.charAt(num2)=='4' ||
                        str.charAt(num2)=='5'|| str.charAt(num2)=='6'|| str.charAt(num2)=='7'||str.charAt(num2)=='8'||str.charAt(num2)=='9'||
                        str.charAt(num2)=='.'||str.charAt(num2)==')'){
                    editText.append("*");
                }else if(str.charAt(num2)=='+'||str.charAt(num2)=='-'||str.charAt(num2)=='/') {
                    editText.getText().delete(num2, num2 + 1);
                    if(str.charAt(num2)=='0'||str.charAt(num2)=='1'||str.charAt(num2)=='2'||str.charAt(num2)=='3'||str.charAt(num2)=='4' ||
                            str.charAt(num2)=='5'|| str.charAt(num2)=='6'|| str.charAt(num2)=='7'||str.charAt(num2)=='8'||str.charAt(num2)=='9'||
                            str.charAt(num2)=='.'||str.charAt(num2)==')') {
                        editText.append("/");
                    }
                }
                break;
            case R.id.button_sub:
                if(!flag){
                    flag=!flag;
                }
                str=editText.getText().toString();
                if(str.length()!=0&&str.charAt(str.length()-1)=='-'){//-号前不可以是-号
                    break;
                } else if(str.length()!=0&&str.charAt(str.length()-1)=='+'){//当-号前面是+号是把+变为-
                    editText.getText().delete(str.length()-1,str.length());
                }
                editText.append("-");
                break;
            case R.id.button_add:
                if(!flag){
                    flag=!flag;
                }
                str=editText.getText().toString();
                int num3=str.length()-1;
                if(num3==-1) break;
                else if(str.charAt(num3)=='0'||str.charAt(num3)=='1'||str.charAt(num3)=='2'||str.charAt(num3)=='3'||str.charAt(num3)=='4' ||
                        str.charAt(num3)=='5'|| str.charAt(num3)=='6'|| str.charAt(num3)=='7'||str.charAt(num3)=='8'||str.charAt(num3)=='9'||
                        str.charAt(num3)=='.'||str.charAt(num3)==')'){
                    editText.append("+");
                }else if(str.charAt(num3)=='/'||str.charAt(num3)=='-'||str.charAt(num3)=='*') {
                    editText.getText().delete(num3, num3+ 1);
                    if(str.charAt(num3)=='0'||str.charAt(num3)=='1'||str.charAt(num3)=='2'||str.charAt(num3)=='3'||str.charAt(num3)=='4' ||
                            str.charAt(num3)=='5'|| str.charAt(num3)=='6'|| str.charAt(num3)=='7'||str.charAt(num3)=='8'||str.charAt(num3)=='9'||
                            str.charAt(num3)=='.'||str.charAt(num3)==')') {
                        editText.append("/");
                    }
                }
                break;
            case R.id.button_left:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                editText.append("(");
                break;
            case R.id.button_right:
                if(!flag){
                    editText.setText("");
                    flag=!flag;
                }
                str=editText.getText().toString();
                int n2=0;
                int m2=0;
                for(int i=0;i<str.length();i++){//当左括号小于右括号时，禁止输入
                    if(str.charAt(i)==')') m2++;
                    if(str.charAt(i)=='(') n2++;
                }
                if(m2<n2&&str.charAt(str.length()-1)!='(') editText.append(")");
                break;
            case R.id.button_equal:
                str=editText.getText().toString();
                if(str.length()==0) break;
                Operationallogic operationallogic=new Operationallogic();
                try {
                    int n3=0;
                    int m3=0;
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i)==')') m3++;
                        if(str.charAt(i)=='(') n3++;
                    }//限制括号内最后一位为/*-+
                    if(str.charAt(str.length()-1)==')'&&(str.charAt(str.length()-2)=='-'||str.charAt(str.length()-2)=='+'||
                            str.charAt(str.length()-2)=='*'|| str.charAt(str.length()-2)=='/')){
                        Toast.makeText(MainActivity.this,"表达式错误", Toast.LENGTH_SHORT).show();
                        break;
                    }//限制表达式的最后一位是/*-+(
                    if(str.charAt(str.length()-1)=='+'||str.charAt(str.length()-1)=='-'||str.charAt(str.length()-1)=='*'||
                            str.charAt(str.length()-1)=='/'||str.charAt(str.length()-1)=='('){
                        Toast.makeText(MainActivity.this,"表达式错误", Toast.LENGTH_SHORT).show();
                        break;
                    }//判断简单除0错误
                    if(judgediv0(editText)){
                        editText.setText("");
                        Toast.makeText(MainActivity.this,"除0错误",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    str=add0(str);//当以-号开头或-前是(时往-前补0
                    if(n3!=m3&&str.charAt(str.length()-1)!='('){//当左右括号不对等时不上)
                        for(int i=0;i<n3-m3;i++){
                            str=str+")";
                        }
                    }
                    str=addx(str);//当数字与()紧挨及)(情况时补上*
                    String temp1 ="";
                    for(int i=0;i<str.length();i++){//判断计算后有除0错误的情况
                        if(str.charAt(i)=='/'&&str.charAt(i+1)=='('){
                            int j=0;
                            for(j=i+1;str.charAt(j)!=')'&&j<str.length()-1;j++);
                            temp1=str.substring(i+2,j);
                            temp1=operationallogic.equal(operationallogic.forSuffix(temp1));
                        }
                    }
                    if(temp1.equals("0")){
                        editText.setText("");
                        Toast.makeText(MainActivity.this,"除0错误",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    str=operationallogic.forSuffix(str);//中缀表达式转后缀表达式
                    str=operationallogic.equal(str);//用后缀表达式进行运算
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this,"表达式错误", Toast.LENGTH_SHORT);
                }
                if(str.equals("表达式错误")){
                    editText.setText("");
                    Toast.makeText(MainActivity.this,"表达式错误", Toast.LENGTH_SHORT).show();
                }else {
                    editText.setText("");
                    editText.append(str);
                    flag=false;
                }
                break;
            default:
                break;
        }
    }
    public String addx(String str){//递归补*函数
        int m=str.length();
        boolean flag=true;
        for(int i=0;i<m;i++){
           if(i!=0&&str.charAt(i)=='('&&(str.charAt(i-1)=='0'||str.charAt(i-1)=='1'||str.charAt(i-1)=='2'||str.charAt(i-1)=='3'||
                     str.charAt(i-1)=='4'||str.charAt(i-1)=='5'||str.charAt(i-1)=='6'||str.charAt(i-1)=='7'||str.charAt(i-1)=='8'||
                     str.charAt(i-1)=='9')){
               flag=false;
           }
           if(i!=str.length()-1&&str.charAt(i)==')'&&str.charAt(i+1)=='('){
               flag=false;
           }
           if(i!=str.length()-1&&str.charAt(i)==')'&&(str.charAt(i+1)=='0'||str.charAt(i+1)=='1'||str.charAt(i+1)=='2'||str.charAt(i+1)=='3'||
                   str.charAt(i+1)=='4'||str.charAt(i+1)=='5'||str.charAt(i+1)=='6'||str.charAt(i+1)=='7'||str.charAt(i+1)=='8'||
                   str.charAt(i+1)=='9')){
               flag=false;
           }
        }
        if(flag) return str;
        for(int i=0;i<m;i++){
            if(i!=0&&str.charAt(i)=='('&&(str.charAt(i-1)=='0'||str.charAt(i-1)=='1'||str.charAt(i-1)=='2'||str.charAt(i-1)=='3'||
                    str.charAt(i-1)=='4'||str.charAt(i-1)=='5'||str.charAt(i-1)=='6'||str.charAt(i-1)=='7'||str.charAt(i-1)=='8'||
                    str.charAt(i-1)=='9')){
                StringBuilder temp;
                temp=new StringBuilder(str);
                temp.insert(i,"*");
                str=temp.toString();
            }
            if(i!=str.length()-1&&str.charAt(i)==')'&&str.charAt(i+1)=='('){
                StringBuilder temp;
                temp=new StringBuilder(str);
                temp.insert(i+1,"*");
                str=temp.toString();
            }
            if(i!=str.length()-1&&str.charAt(i)==')'&&(str.charAt(i+1)=='0'||str.charAt(i+1)=='1'||str.charAt(i+1)=='2'||str.charAt(i+1)=='3'||
                    str.charAt(i+1)=='4'||str.charAt(i+1)=='5'||str.charAt(i+1)=='6'||str.charAt(i+1)=='7'||str.charAt(i+1)=='8'||
                    str.charAt(i+1)=='9')){
                StringBuilder temp;
                temp=new StringBuilder(str);
                temp.insert(i+1,"*");
                str=temp.toString();
            }
        }
        return addx(str);
    }
    public String add0(String str){//递归补0函数
        int m=str.length();
        boolean flag=true;
        for(int i=0;i<m;i++){
            if(str.charAt(0)=='-'){
                flag=false;
            }else if(str.charAt(i)=='('&&str.charAt(i+1)=='-') {
                flag=false;
            }
        }
        if(flag) return str;
        for(int i=0;i<m;i++){
            if(str.charAt(0)=='-'){
                str="0"+str;
            }else if(str.charAt(i)=='('&&str.charAt(i+1)=='-'&&i+1!=m-1) {
                StringBuilder temp;
                temp=new StringBuilder(str);
                temp.insert(i+1,"0");
                str=temp.toString();
            }
        }
        return add0(str);
    }
    public boolean judgediv0(EditText editText){//判断简单除0错误函数
        str=editText.getText().toString();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='/'&&str.charAt(i+1)=='0'&&i+2==str.length()){
                return true;
            }else if(str.charAt(i)=='/'&&str.charAt(i+1)=='0'&&(str.charAt(i+2)=='+'||str.charAt(i+2)=='-'||str.charAt(i+2)=='*'||
                    str.charAt(i+2)=='/')){
                return true;
            }
        }
        return false;
    }
    public void judge0(EditText editText){//0为首位及0前为(情况的处理
        str=editText.getText().toString();
        int num=editText.getText().length();
        if(num==1){
            if(str.charAt(num-1)=='0'){
                editText.setText("");
            }
        }
        if(num!=1&&num!=0){
            if(str.charAt(num-1)=='0'&&(str.charAt(num-2)=='-'||str.charAt(num-2)=='+'||str.charAt(num-2)=='*'||str.charAt(num-2)=='/'||
                    str.charAt(num-2)=='('||str.charAt(num-2)==')')){
                editText.getText().delete(num-1,num);
            }
        }
    }
}