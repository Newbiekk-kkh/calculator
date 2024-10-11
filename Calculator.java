package calculator;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        String repeat = "네";

        //"더 계산하시겠습니까? (네 or 아니오)" 에서 네를 입력하면 처음으로 돌아와 다시 계산 수행

        while (Objects.equals(repeat, "네")) {
            // 첫번째 숫자 입력
            System.out.println("계산하고 싶은 첫번째 양의 정수를 입력해주세요.");
            int inputNumber1 = sc.nextInt();
            sc.nextLine();

            // 두번째 숫자 입력
            System.out.println("계산하고 싶은 두번째 양의 정수를 입력해주세요.");
            int inputNumber2 = sc.nextInt();
            sc.nextLine();

            // 사칙연산 기호 입력
            System.out.println("계산하고 싶은 사칙연산 기호를 입력해주세요.");
            String inputOperation = sc.nextLine();

            // 계산식
            if (Objects.equals(inputOperation, "+")) {
                result = inputNumber1 + inputNumber2;
                System.out.println("결과값: " + result);
            }

            if (Objects.equals(inputOperation, "-")) {
                result = inputNumber1 - inputNumber2;
                System.out.println("결과값: " + result);
            }

            if (Objects.equals(inputOperation, "*")) {
                result = inputNumber1 * inputNumber2;
                System.out.println("결과값: " + result);
            }

            if (Objects.equals(inputOperation, "/") && inputNumber2 != 0) {
                // 나누기에 소숫점까지 보여주기위한 형변환
                double input1 = (double) inputNumber1;
                double input2 = (double) inputNumber2;
                double doubleResult;
                doubleResult = input1 / input2;

                System.out.println("결과값: " + doubleResult);
            } else if (Objects.equals(inputOperation, "/") && inputNumber2 == 0) {
                System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
            }

            //종료 할건지
            System.out.println("더 계산하시겠습니까? (네 or 아니오)");
            repeat = sc.nextLine();
            if (Objects.equals(repeat, "아니오")){
                System.out.println("계산기를 종료합니다.");
            }
        }
    }
}
