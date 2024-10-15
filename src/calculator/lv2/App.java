package calculator.src.calculator.lv2;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat = "네";

        while (Objects.equals(repeat, "네")) {
            //첫번째 숫자 입력
            int num1;
            while (true) {
                System.out.println("계산하고 싶은 첫번째 양의 정수를 입력해주세요.");
                if (sc.hasNextInt()) {
                    num1 = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    sc.next();
                }
            }

            // 두번째 숫자 입력
            int num2;
            while (true) {
                System.out.println("계산하고 싶은 두번째 양의 정수를 입력해주세요.");
                if (sc.hasNextInt()) {
                    num2 = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    sc.next();
                }
            }

            // 사칙연산 기호 입력
            System.out.println("계산하고 싶은 사칙연산 기호를 입력해주세요.");
            String operation = sc.nextLine();

            int result = Calculator.calculate(num1, num2, operation);
            Calculator.results.add(result);

            System.out.println("다시 계산하시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
            repeat = sc.nextLine();

            // repeat 에 잘못된 값이 입력되었을시 "네" 또는 "아니오" 가 입력될때 까지 반복
            while (true) {
                if (Objects.equals(repeat, "네") || Objects.equals(repeat, "아니오")) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. '네' 또는 '아니오'를 입력해주세요.");
                    repeat = sc.nextLine();
                }
            }
        }
        System.out.println("계산기를 종료합니다.");
    }


    public class Calculator {
        private static Queue<Integer> results = new LinkedList<>();

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