package calculator.src.calculator.lv1;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        String repeat = "네";  // repeat 을 "네"로 설정해주어야 다음의 반복문이 작동


        //계산 반복을 위해 while문을 사용
        while (Objects.equals(repeat, "네")) {
            //첫번째 숫자 입력
            int inputNumber1;
            while (true) {
                System.out.println("계산하고 싶은 첫번째 양의 정수를 입력해주세요.");
                if (sc.hasNextInt()) {
                    inputNumber1 = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    sc.next();
                }
            }

            // 두번째 숫자 입력
            int inputNumber2;
            while (true) {
                System.out.println("계산하고 싶은 두번째 양의 정수를 입력해주세요.");
                if (sc.hasNextInt()) {
                    inputNumber2 = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    sc.next();
                }
            }

            // 사칙연산 기호 입력
            System.out.println("계산하고 싶은 사칙연산 기호를 입력해주세요.");
            String inputOperation = sc.nextLine();

            // 입력 받은 사칙연산 기호에 따라 계산식 작성 (switch 문으로 케이스별 작성)
            switch (inputOperation) {
                // 더하기
                case "+":
                    result = inputNumber1 + inputNumber2;
                    System.out.println("결과값: " + result);
                    break;
                // 빼기
                case "-":
                    result = inputNumber1 - inputNumber2;
                    System.out.println("결과값: " + result);
                    break;
                // 곱하기
                case "*":
                    result = inputNumber1 * inputNumber2;
                    System.out.println("결과값: " + result);
                    break;
                // 나누기
                case "/":
                    if (inputNumber2 != 0) {
                        // 나누기에 소숫점까지 보여주기위한 형변환
                        double input1 = (double) inputNumber1;
                        double input2 = (double) inputNumber2;
                        double doubleResult;
                        doubleResult = input1 / input2;

                        System.out.println("결과값: " + doubleResult);
                    } else if (inputNumber2 == 0) {
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    }
                    break;
                // +, -, *, / 가 아닌 다른입력을 받았을때
                default:
                    System.out.println("잘못된 연산기호를 입력하셨습니다.");
                    break;
            }

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
}
