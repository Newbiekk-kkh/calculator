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
            Calculator.resultData.add(result);

            // while 문 반복 실행 및 종료를 위해 repeat 값 입력받기
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
        // getter 메서드 사용
        System.out.println("계산된 결과 값을 모두 보시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
        String selectGet = sc.nextLine();
        if (selectGet.equals("네")) {
            System.out.println(Calculator.getResultData());
        }
        // setter 메서드 사용
        System.out.println("계산된 결과 값을 수정하시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
        String selectSet = sc.nextLine();
        if (selectSet.equals("네")) {
            System.out.println("구현중입니다.");
        }
        // 가장 첫번째로 저장된 데이터값을 삭제하는 removeResultData 메서드 사용
        System.out.println("저장된 첫번째 데이터값을 삭제하시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
        String selectRemove = sc.nextLine();

        while (true) {
            if (selectSet.equals("아니오")) {
                break;
            } else if (selectSet.equals("네")) {
                if (Calculator.resultData.isEmpty()) {
                    System.out.println("삭제할 데이터가 존재하지 않습니다.");
                    break;
                } else {
                    Calculator.removeResultData();
                    System.out.println("데이터가 삭제되었습니다.");
                    System.out.println("현재 결과 데이터: " + Calculator.getResultData());
                    System.out.println("추가적으로 첫번째 데이터값을 삭제하시겠습니까?");
                    selectRemove = sc.nextLine();
                }
            } else {
                System.out.println("잘못된 입력입니다. '네' 또는 '아니오'를 입력해주세요.");
                System.out.println("저장된 첫번째 데이터값을 삭제하시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
                selectRemove = sc.nextLine();
            }
        }
        System.out.println("계산기를 종료합니다.");
    }


    public static class Calculator {
        private static Queue<Integer> resultData = new LinkedList<>();

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

        public static Queue<Integer> getResultData() {
            return resultData;
        }

        public void setResultsData() {
            this.resultData = resultData;
        }

        public static void removeResultData() {
            resultData.remove();
        }
    }
}