package calculator.src.calculator.lv2;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String repeat = "네"; // repeat 을 "네"로 설정해주어야 다음의 반복문이 작동

        //계산 반복을 위해 while 문을 사용
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
                    sc.nextLine();
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
                    sc.nextLine();
                }
            }

            // 사칙연산 기호 입력
            System.out.println("계산하고 싶은 사칙연산 기호를 입력해주세요.");
            String operation = sc.nextLine();

            // 입력 받은 결과를 calculate 메서드를 통해 result 값에 대입 및 resultData 에 값 저장
            // try ~ catch 문을 사용해 예외가 발생하면 result 값을 저장하지 않음
            try {
                int result = Calculator.calculate(num1, num2, operation);
                Calculator.getResultData().add(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

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

        // getter 메서드 사용 (데이터 불러오기)
        System.out.println("계산된 결과 값을 모두 보시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
        String selectGet = sc.nextLine();
        if (selectGet.equals("네")) {
            System.out.println(Calculator.getResultData());
        }

        // setter 메서드 사용 (데이터 수정하기)
        System.out.println("계산된 결과 값을 수정하시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
        String selectSet = sc.nextLine();
        while (true) {
            if (selectSet.equals("네")) {
                System.out.println("몇번째 데이터를 수정하시겠습니까? (숫자로만 입력해주세요.)");
                int index = sc.nextInt();
                System.out.println("어떤 값으로 수정하시겠습니까?");
                int newValue = sc.nextInt();
                sc.nextLine();
                Calculator.setResultData(index - 1, newValue);
                System.out.println("추가적으로 수정하시겠습니까?");
                selectSet = sc.nextLine();
            } else if (selectSet.equals("아니오")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. '네' 또는 '아니오'를 입력해주세요.");
                System.out.println("다시 입력해주세요. 수정하시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
                selectSet = sc.nextLine();
            }
        }

        // 가장 첫번째로 저장된 데이터값을 삭제하는 removeResultData 메서드 사용
        System.out.println("저장된 첫번째 데이터값을 삭제하시겠습니까? '네' 또는 '아니오'를 입력해주세요.");
        String selectRemove = sc.nextLine();

        // 삭제할 데이터가 없을때 오류가 나는것을 방지하기 위해 isEmpty 로 데이터가 존재하는지 확인
        while (true) {
            if (selectRemove.equals("아니오")) {
                break;
            } else if (selectRemove.equals("네")) {
                if (Calculator.getResultData().isEmpty()) {
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
        // 계산기 종료
        System.out.println("계산기를 종료합니다.");
    }
}
