package com.example.tms_app;

public class SampleClass {
    private Integer Result = null;

    public int getResult(){
        return Result;
    }

    public void setResult(int result){
        Result = result;
    }
    public void Add(Integer input1, Integer input2){
        setResult(input1 + input2);
    }
}
