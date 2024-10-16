package calculator.src.calculator.lv2;

import java.util.LinkedList;
import java.util.Queue;

// Calculator 클래스
public class Calculator {
    // 컬렉션 필드 타입을 Queue 로 지정
    private static Queue<Integer> resultData = new LinkedList<>();

    // calculate 메서드 ( 계산기능 : 더하기 / 빼기 / 곱하기 / 나누기 )
    public static int calculate(int num1, int num2, String operation) throws Exception {
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
                    // 분모가 0일때 예외처리
                    throw new Exception("0으로 나눌수 없습니다.");
                }
                break;

            default:
                // +, -, *, / 가 아닌 다른입력을 받았을때 예외처리
                throw new Exception("잘못된 연산 기호를 입력하셨습니다.");
        }
        return result;
    }

    // 데이터를 받아오는 getter
    public static Queue<Integer> getResultData() {
        return resultData;
    }

    // 데이터를 수정하는 setter, Queue 로 저장한 값을 직접 수정하는 방법을 찾지 못해
    // tempList 를 통해 Queue 를 List 로 저장하고 특정 index 의 값을 수정한뒤 다시 Queue 로 변환
    public static void setResultData(int index, int newValue) {
        if (index >= 0 && index < resultData.size()) {
            LinkedList<Integer> tempList = new LinkedList<>(resultData);
            tempList.set(index, newValue);
            resultData = new LinkedList<>(tempList);
            System.out.println("값이 수정되었습니다.");
            System.out.println("현재 결과 데이터: " + Calculator.getResultData());
        } else {
            System.out.println("잘못된 인덱스입니다.");
        }
    }

    // 데이터 삭제 메서드
    public static void removeResultData() {
        resultData.remove();
    }
}
