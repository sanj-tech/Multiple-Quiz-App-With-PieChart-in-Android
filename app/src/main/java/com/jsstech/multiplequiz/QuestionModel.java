package com.jsstech.multiplequiz;

public class QuestionModel {
   public String ques;
   public String opt1,op2;
  public String ansResult;

    public QuestionModel(String ques,String opt1,String op2,String ansResult) {
        this.ques = ques;
        this.opt1 = opt1;
        this.op2 = op2;
        this.ansResult = ansResult;
    }

    public QuestionModel() {
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getAnsResult() {
        return ansResult;
    }

    public void setAnsResult(String ansResult) {
        this.ansResult = ansResult;
    }
}
