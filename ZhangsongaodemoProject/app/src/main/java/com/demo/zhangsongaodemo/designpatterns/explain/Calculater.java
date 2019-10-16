package com.demo.zhangsongaodemo.designpatterns.explain;

import java.util.Stack;

/**
 * 计算的封装类
 * 避免 顶层和 实际计算部分耦合
 */
public class Calculater {

    public static int doCalculate(String input){
        char[] inputCharArray=input.toCharArray();
        Stack<Element> elements=new Stack<>();
        for (int i = 0; i < inputCharArray.length; i++) {
            char c = inputCharArray[i];
            switch (c) {
                case '+':
                    Element leftValue = elements.pop();
                    Element rightValue = new NumberElement(inputCharArray[i+1]);
                    i++;
                    AddElement addElement=new AddElement(leftValue,rightValue);
                    elements.push(addElement);
                    break;
                case '-':
                    Element leftValueSub = elements.pop();
                    Element rightValueSub = new NumberElement(inputCharArray[i+1]);
                    i++;
                    SubtractionElement subtractionElement=new SubtractionElement(leftValueSub,rightValueSub);
                    elements.push(subtractionElement);
                    break;
                default:
                    NumberElement numberElement=new NumberElement(c);
                    elements.push(numberElement);
                    break;
            }
        }
        return calculate(elements);
    }

    public static int calculate(Stack<Element> elements){
        int finalResult=0;
        for (Element element : elements) {
            finalResult = element.dealWidthData();
        }
        return finalResult;
    }

}
