package calculator.src.calculator.lv2;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public class Caculator {
        int[] results;

        public static int calculate(int num1, int num2, String operation) {
            int result = 0;

            switch (operation) {
                // 더하기
                case "+":
                    result = num1 + num2;
                    System.out.println("결과값: " + result);
                    break;
                // 빼기
                case "-":
                    result = num1 - num2;
                    System.out.println("결과값: " + result);
                    break;
                // 곱하기
                case "*":
                    result = num1 * num2;
                    System.out.println("결과값: " + result);
                    break;
                // 나누기
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("결과값: " + result);
                    } else if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    }
                    break;
                // +, -, *, / 가 아닌 다른입력을 받았을때
                default:
                    System.out.println("잘못된 연산기호를 입력하셨습니다.");
                    break;
            }
            return result;
        }
    }

}