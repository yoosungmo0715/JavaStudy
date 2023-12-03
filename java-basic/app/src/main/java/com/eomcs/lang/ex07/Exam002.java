package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//#1. 별 앞에 공백출력 메서드 생성
//#2. 별 출력 
//#3. for문으로 바꾸기
//#4. 임시변수를 질의함수로 바꾸기
//#5. 프롬프트 메서드 생성
//#6. 프롬프트 매서드 일반화
public class Exam002 {
  static void printSpaces(int spaceLen){
      int spaceCnt = 1; 
      while (spaceCnt <= spaceLen) {
        System.out.print(" ");
        spaceCnt++;
    }
  }  
  static void printStars(int starLen){
    int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
    }
  }
  static int getSpaceLength(int len, int starLen){
    return (len - starLen) / 2;
  }

  static int promptInt(String question){
    Scanner keyScan = new Scanner(System.in);
    System.out.print(question);
    int len = keyScan.nextInt();
    keyScan.close();
    
    return len;
  }

  public static void main(String[] args) {
    int len = promptInt("밑변의 길이? ");
    for (int starLen = 1 ; starLen <= len ; starLen += 2) {
      printSpaces(getSpaceLength(len, starLen));
      printStars(starLen);
      // 출력 줄 바꾸기
      System.out.println();
      
    }
  }
}