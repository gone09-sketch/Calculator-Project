package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 객체 선언
        Scanner scanner = new Scanner(System.in);

        // 계산기 반복문(while)
        while (true) {
            // 첫 번째 양의 정수(0포함) 입력받기
            int firstNum = 0;
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                firstNum = scanner.nextInt(); // 데이터 입력 받기

                if (firstNum >= 0) {
                    break;
                } else if (firstNum < 0) {
                    System.out.println("!입력오류: 0 이상의 숫자를 다시 입력하세요: ");
                } else {
                    System.out.println("!입력오류: 0 이상의 숫자를 다시 입력하세요: ");
                }
            }

            // 두 번째 양의 정수(0포함) 입력받기
            int secondNum = 0;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                secondNum = scanner.nextInt(); // 데이터 입력 받기
                if (firstNum >= 0) {
                    break;
                } else if (firstNum < 0) {
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

                if (mathSymbol == '+' || mathSymbol == '-' || mathSymbol == '*' || mathSymbol == '/')
                {
                    break;
                } else {
                    System.out.println("!입력오류: 올바른 연산 기호를 다시 입력하세요: ");
                }
            }


            //위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력
            int result = 0; // 결과값 초기화
            switch (mathSymbol) {

                case '+':
                    result = firstNum + secondNum;
                    System.out.println("결과값: " + result);
                    break;

                case '-':
                    result = firstNum - secondNum;
                    System.out.println("결과값: " + result);
                    break;

                case '*':
                    result = firstNum * secondNum;
                    System.out.println("결과값: " + result);
                    break;

                case '/':
                    if (secondNum > 0) {
                        result = firstNum / secondNum;
                        System.out.println("결과값: " + result);
                    } else if (secondNum == 0) {
                        System.out.println("!입력 오류: 나눗셈 연산에서 분모(두 번째 숫자)에 0이 입력될 수 없습니다.");
                    } else {
                        System.out.println("!입력 오류: 적절한 사칙연산 기호가 아닙니다.");
                    }
                    break;

            }
                /* switch문에서 두 번째 숫자가 0 혹은 사칙연산 기호가 제대로 입력되지 않았을 경우, 위와 같은 문구가 출력된다.
                내가 원하는 것은 다시 한번 그 숫자 혹은 사칙연산 기호를 입력할 수 있도록 하는 것 => 과제에는 기재되어 있지 않기 때문에 우선 넘어가보자.
                 */

            System.out.println("계산 종료: 'exit'입력, 계산을 처음부터 하시려면 엔터를 입력하세요.");
                /* 만약 사용자가 exit 입력하지 않으면 어차피 루프가 끝나지 않기 때문에 다시 맨 처음으로 돌아가서 첫 번재 숫자를 입력하라고 한다.
                여기에서 if문으로 사용자가 exit 입력하면 끝난다고 설정을 한다. (break 사용) */

            String exitCal = scanner.nextLine();
            if (exitCal.equals("exit")) {
                System.out.print("프로그램을 종료합니다.");
                break;
            }

        }

    }
}
