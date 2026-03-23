package calculator;

import java.util.ArrayList;

public class Calculator {
    //결과값을 저장하기 위한 컬렉션 ArrayList(여러값 저장 가능/중복값 가능)
    private ArrayList<Integer> allResults = new ArrayList<>();

    // 사칙연산 수행 후 반환 메서드 calculate 구현
    public int calculate(int firstNum, int secondNum, char mathSymbol) {

        // 결과값 result 초기화
        int result = 0;

        switch (mathSymbol) {

            case '+':
                result = firstNum + secondNum;
                System.out.println("==계산 결과==");
                System.out.println("첫 번째 숫자: " + firstNum);
                System.out.println("두 번째 숫자: " + secondNum);
                System.out.println("사칙연산 기호: " + mathSymbol);
                System.out.println("결과값: " + result);
                break;

            case '-':
                result = firstNum - secondNum;
                System.out.println("==계산 결과==");
                System.out.println("첫 번째 숫자: " + firstNum);
                System.out.println("두 번째 숫자: " + secondNum);
                System.out.println("사칙연산 기호: " + mathSymbol);
                System.out.println("결과값: " + result);
                break;

            case '*':
                result = firstNum * secondNum;
                System.out.println("==계산 결과==");
                System.out.println("첫 번째 숫자: " + firstNum);
                System.out.println("두 번째 숫자: " + secondNum);
                System.out.println("사칙연산 기호: " + mathSymbol);
                System.out.println("결과값: " + result);
                break;

            case '/':
                if (secondNum == 0) {
                    System.out.println("!입력 오류: 나눗셈 연산에서 분모(두 번째 숫자)에 0이 입력될 수 없습니다.");
                } else {
                    result = firstNum / secondNum;
                    System.out.println("==계산 결과==");
                    System.out.println("첫 번째 숫자: " + firstNum);
                    System.out.println("두 번째 숫자: " + secondNum);
                    System.out.println("사칙연산 기호: " + mathSymbol);
                    System.out.println("결과값: " + result);
                }
                break;
        }
        // 결과값을 저장
        allResults.add(result);

        // 결과값 반환
        return result;

    }

    //게터
    public ArrayList<Integer> getAllResults() {
        return allResults;
    }


    //세터 (전체 리스트 변경)
    public void setAllResults(ArrayList<Integer> newResults) {
        this.allResults = newResults;
    }

    // 가장 먼저 저장된 데이터 삭제 (.isEmpty 메서드 사용)
    public void removeFirstResult() {
        if (!allResults.isEmpty()){
            allResults.remove(0);
        }
    }





}
