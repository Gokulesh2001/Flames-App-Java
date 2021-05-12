package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name1;
    EditText name2;
    Button enter;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        enter=findViewById(R.id.enter);
        result=findViewById(R.id.result);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=name1.getText().toString().trim().toLowerCase();
                String str2=name2.getText().toString().trim().toLowerCase();


                int a[]=new int[256];
                int b[]=new int[256];
                for(char c:str1.toCharArray()){
                    a[c]++;
                }
                for(char c:str2.toCharArray()){
                    b[c]++;
                }
                int count=0;
               for(int i=0;i<256;i++){
                   count+=Math.max(a[i],b[i])-Math.min(a[i],b[i]);
               }
                ArrayList<Character> flames=new ArrayList<>();
                flames.add('f');
                flames.add('l');
                flames.add('a');
                flames.add('m');
                flames.add('e');
                flames.add('s');


                char win = 0;
                int flag=0;
                int pos=0;
                while(flames.size()>1) {


                    int i,j=pos;
                    for(i=0;i<count;i++)
                    {

                        j++;
                        if(j>=flames.size())
                        { j=0; }

                    }
                    if(flag==0)
                    {
                        j-=1;
                        if(j==flames.size())
                            j=0;
                        if(j==-1)
                            j=(flames.size()-1);
                        flag++;
                    }

                    flames.remove(j);
                    j-=1;
                    if(j==flames.size())
                        j=0;
                    if(j==-1)
                        j=(flames.size()-1);
                    pos=j;


		/*
		val=count>flames.size()?count%flames.size():count;
		if(val==0)
		val=flames.size();
		val-=1;
		flames.remove(val);

		 ArrayList<String> temp = new ArrayList<String>();

		for(int i=0;i<flames.size();i++)
		 {
			temp.add(flames.get(val));
			val++;
			if(val==flames.size())
			val=0;
		}

		flames=temp;
		*/

                    //out.println(val);



                }



                win = flames.get(0);
                if(win=='f'){
                    result.setText("You both are good friends!!");
                }
                else if(win=='l'){
                    result.setText("You both are true lovers!!");
                }
                else if(win=='a'){
                    result.setText("Affection!!"+count);
                }
                else if(win=='m'){
                    result.setText("You are going to marry your partner!!");
                }
                else if(win=='e'){
                    result.setText("You both are like cat and rat!!");
                }
                else if(win=='s'){
                    result.setText("You both are brother and sister!!");
                }


            }
            public boolean isAllEmpty(ArrayList<Character> flames){
                int count=0;
                for(char c:flames){
                    if(c!=' '){
                        count++;
                    }
                }
                return count==1;
            }
        });

    }
}