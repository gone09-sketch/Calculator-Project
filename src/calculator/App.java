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

            // 나눗셈 시, 분모 0 검증하기
            if (mathSymbol == '/' && secondNum == 0) {
                System.out.println("!입력오류: 0으로 나눌 수 없습니다.\n");
                continue;
            }

            //결과값 받기
            int result = calculator.calculate(firstNum, secondNum, mathSymbol);
            System.out.println("==계산 결과==");
            System.out.println(firstNum + " " + mathSymbol + " " + secondNum + " = " + result);
            System.out.println("결과값: " + result);


            // 계산 종료 여부 묻기
            String exitCal;
            while (isRunning) {
                System.out.println("\n계산을 종료하시겠습니까? 예: exit / 계산하기: 0 / 메뉴보기: 1");
                exitCal = scanner.nextLine();

                if (exitCal.equals("exit")) {
                    isRunning = false;
                    System.out.print("프로그램을 종료합니다.");
                    break;

                } else if (exitCal.equals("0")) {
                    continue; // 계속 계산 (첫 번째 피연산자 입력으로 이동)

                } else if (exitCal.equals("1")) {
                    // 계산기 메뉴
                    while (isRunning) {
                        System.out.println("\n==계산기 메뉴==");
                        System.out.println("1. 계산 종료: exit \n2. 결과값 확인하기: result \n3. 첫 번째 결과값 삭제: delete \n4. 계산기 시작: 0");
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
                            calculator.removeFirstResult();
                            System.out.println("첫 번째 값이 삭제되었습니다.");
                            ArrayList<Integer> allResults = calculator.getAllResults();
                            System.out.println("수정된 값 확인: " + allResults);

                        } else if (exitCal.equals("exit")) {
                            isRunning = false; // 프로그램 종료 (반복X)
                            System.out.print("프로그램을 종료합니다.");
                            break;

                        } else {
                            System.out.println("!입력오류: 다시 입력하세요.");
                        }
                    }

                } else {
                    System.out.println("!입력오류: 다시 입력하세요.");
                }
            }
        }
    }
}

