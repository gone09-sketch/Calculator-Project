package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Calculator 인스턴스 생성
        Calculator calculator = new Calculator();
        // 객체 선언
        Scanner scanner = new Scanner(System.in);

        // exit을 위한 변수 추가
        boolean isRunning = true;

        // 계산기 반복문(while)
        while (isRunning) {
            // 첫 번째 양의 정수(0포함) 입력받기
            int firstNum = 0;
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                firstNum = scanner.nextInt(); // 데이터 입력 받기

                if (firstNum >= 0) {
                    break;
                } else if (firstNum < 0) {
                    System.out.println("!입력오류: 0 이상의 숫자를 다시 입력하세요: ");
                }
            }

            // 두 번째 양의 정수(0포함) 입력받기
            int secondNum = 0;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                secondNum = scanner.nextInt(); // 데이터 입력 받기
                if (secondNum >= 0) {
                    break;
                } else if (secondNum < 0) {
                    System.out.println("!입력오류: 0 이상의 숫자를 다시 입력하세요: ");
                } else {
                    System.out.println("!입력오류: 0 이상의 숫자를 다시 입력하세요: ");
                }
            }

            scanner.nextLine(); // 버퍼 소비해주기 nextInt은 개행문자를 소비하지 않는다.

            // 사칙연산 기호 입력받기
            // charAt(0) 사용하기 => 문자열(String)에서 특정 위치의 한 글자만 꺼내는 함수 => 인덱스는 0부터 시작!
            char mathSymbol;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                mathSymbol = scanner.nextLine().charAt(0); // 데이터 입력 받기

                if (mathSymbol == '+' || mathSymbol == '-' || mathSymbol == '*' || mathSymbol == '/') {
                    break;
                } else {
                    System.out.println("!입력오류: 올바른 연산 기호를 다시 입력하세요: ");
                }
            }

            // 분모 0 검증하기
            if (mathSymbol == '/' && secondNum == 0) {
                System.out.println("!입력오류: 0으로 나눌 수 없습니다.\n");
                continue;
            }


            //결과값 받기
            int result = calculator.calculate(firstNum, secondNum, mathSymbol);


            // 계산 종료 여부 묻기
            System.out.println("\n계산을 종료하시겠습니까? 예: exit / 메뉴보기: 1");
            String exitCal;
            exitCal = scanner.nextLine();
            if (exitCal.equals("exit")) {
                isRunning = false;
                System.out.print("프로그램을 종료합니다.");
                break;
            }


            // 계산기 메뉴
            while (true) {
                System.out.println("\n==계산기 메뉴==");
                System.out.println("1. 계산 종료: exit \n2. 결과값 확인하기: result \n3. 첫 번째 결과값 삭제: delete \n4. 계산기 시작: 0");
                /* 만약 사용자가 exist 입력하지 않으면 어차피 루프가 끝나지 않기 때문에 다시 맨 처음으로 돌아가서 첫 번재 숫자를 입력하라고 한다.
                여기에서 if문으로 사용자가 exist 입력하면 끝난다고 설정을 한다. (break 사용) */

                exitCal = scanner.nextLine();
                if (exitCal.equals("0")) {
                    System.out.print("===계산기를 다시 실행합니다===\n");
                    break;

                } else if (exitCal.equals("result")) {
                    // 게터: 저장된 값 불러오기
                    ArrayList<Integer> allResults = calculator.getAllResults();
                    System.out.println("\n저장된 값 확인: " + allResults);


                } else if (exitCal.equals("delete")) {
                    // 가장 먼저 저장된 데이터 삭제
                    /* ArrayList 의 요소 삭제 방법은 allResults.remove("")이다.
                        이렇게 되면 특정 값을 입력을 해야하는데 아직 값을 모른다.
                        사용자가 데이터를 모두 입력 후 결과값을 받을 때 어떤 값이 맨 먼저 있는지 알 수 있다.
                        이럴 때에는 어떻게 해야할까? remove "값"안에 result값을 넣으면 어떨까?
                        그러면 맨 처음이 아니라 나중에 입력되는 result값이 들어갈 수 있다. 혹은 저기에는 "값"만 넣을 수 있고 변수는 넣을 수 없지 않을까?
                        단건 조회 get(0)통해 맨 처음값을 알고 그것을 활용하여 삭제할 수 있지 않을까?
                        => [튜터님 힌트]: Calculator 클래스에서 메서드를 생성하기!
                     */
                    calculator.removeFirstResult();
                    System.out.println("첫 번째 값이 삭제되었습니다.");
                    ArrayList<Integer> allResults = calculator.getAllResults();
                    System.out.println("수정된 값 확인: " + allResults);



                } else if (exitCal.equals("exit")) {
                    isRunning = false; // 프로그램 종료 (반복X)
                    System.out.print("프로그램을 종료합니다.");
                    break;
                }
            }



        }
    }
}

