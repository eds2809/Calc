package com.company;

public enum OperationType {
    addition("+"),subtraction("-"),multiplication("*"),division("/");

    String name;

    OperationType(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toEString(){
        return name.replace(name,"\\"+name);
    }
}
