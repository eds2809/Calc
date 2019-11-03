package com.company;


class Calc {

    private String expression;
    private String[] expressionArr;
    private OperationType operationType;
    private boolean romanNum = false;
    private int num1, num2;

    Calc(String s){
        this.expression = s;
        clear();
    }

    private String clear(){
        return expression.replace(" ","");
    }

    void verification() {
        if (expression.contains("0")) {
            throw new IllegalArgumentException("The entered data is not correct: " + expression);
        } else if (!expression.isEmpty()) {
            boolean f = true;
            for (OperationType e : OperationType.values()) {
                if (expression.contains(e.toString())) {
                    f = false;
                    expressionArr = expression.split(String.format("\\%s", e.toString()));
                    operationType = e;
                    break;
                }
            }
            if (f) {
                throw new IllegalArgumentException("no operation sign: " + expression);
            } else if (expressionArr.length != 2) {
                throw new IllegalArgumentException("Less or more than two specified operands: " + expression);
            } else if (expressionArr[0].matches("[123456789]+") && expressionArr[1].matches("[123456789]+")) {
                if (Integer.parseInt(expressionArr[0]) > 10
                        && Integer.parseInt(expressionArr[1]) > 10) {
                    throw new IllegalArgumentException("The entered data is not correct: " + expression);
                }

                num1 = Integer.parseInt(expressionArr[0]);
                num2 = Integer.parseInt(expressionArr[1]);
            } else if (!"[1-10]".matches(expressionArr[0]) && !"[1-10]".matches(expressionArr[1])) {
               if (!expressionArr[0].matches("[VIXvix]+") || !expressionArr[1].matches("[VIXvix]+")){
                   throw new IllegalArgumentException("The entered data is not correct: " + expression);
               }
               romanNum = true;
               num1 = RomanToDecimal.romanToDecimal(expressionArr[0]);
               num2 = RomanToDecimal.romanToDecimal(expressionArr[1]);
            }

        }

    }

    String result(){
        switch (operationType){
            case subtraction:
                return romanNum ?  RomanNumber.toRoman(num1-num2): String.valueOf(num1-num2);
            case addition:
                return romanNum ?  RomanNumber.toRoman(num1+num2): String.valueOf(num1+num2);
            case division:
                return romanNum ?  RomanNumber.toRoman(num1/num2): String.valueOf(num1/num2);
            case multiplication:
                return romanNum ?  RomanNumber.toRoman(num1*num2): String.valueOf(num1*num2);
        }
        return null;
    }


}



