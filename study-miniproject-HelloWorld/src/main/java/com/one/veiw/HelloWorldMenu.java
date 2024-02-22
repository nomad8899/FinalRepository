package com.one.veiw;

import com.one.model.dto.PersonDTO;
import com.one.controller.HelloWorldManager;
import com.one.model.dto.GyroDrop;
import com.one.model.dto.MerryGoRound;
import com.one.model.dto.Viking;

import java.util.Scanner;

public class HelloWorldMenu {
    /*
    *기능구현 : 1. 스캐너로 입장 인원의 이름 (String)  / 나이 (int)  / 키 (double) 받기
    *          2. 입장 현황을 displayAll 오름차순 정렬으로 보이기
    *          3. 놀이기구의 인원 별 입장/제한
    *            1) 이름으로 인덱스 찾기
    *            2) 3종 놀이기구 중 고르기 (스캐너)
    *            3) 키로 입장 제한두기
    *          4. 퇴장
    *            1) 이름으로 인덱스 찾기
    *            2) 인덱스 지우기 */

    private Scanner sc = new Scanner(System.in);

    HelloWorldManager hm = new HelloWorldManager();
    GyroDrop gyroDrop = new GyroDrop();


    public HelloWorldMenu() {
    }


    public void menuPopup() {
        label:
        while (true) {

            System.out.println("******Hello World******");
            System.out.println("1. 입장인원 등록");
            System.out.println("2. 놀이공원 입장현황");
            System.out.println("3. 놀이기구 탑승");
            System.out.println("4. 집가기");
            System.out.println("5. 놀이공원 폐장");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("이름을 입력 하세요 : ");
                    String name = sc.next();
                    System.out.println("나이를 입력 하세요 : ");
                    int age = sc.nextInt();
                    System.out.println("키를 입력하세요 : ");
                    double height = sc.nextDouble();

                    PersonDTO personDTO = new PersonDTO(name, age, height);
                    hm.insertPerson(personDTO);

                    break;
                case 2:
                    hm.allPrint();

                    break;

                case 3:
                    ride();

                    break;
                case 4:
                    goHome();

                    break;
                case 5 :
                    System.out.println("이제는 우리가 헤어져야 할시간~ 내일 또 만나요~");

                    break label;
                default:
                    System.out.println("다른 번호를 입력하셨습니다.");
                    break;
            }
        }
    }


    public void ride() {

        while(true){

            hm.allPrint();
            System.out.print("탑승할 사람의 이름을 입력하세요 : ");
            String name = sc.next();
            PersonDTO person = hm.selectPerson(name);
            System.out.print("1. 회전목마 2. 자이로드롭 3. 바이킹");
            int input = sc.nextInt();


            if(input == 1) {
                MerryGoRound merryGoRound = new MerryGoRound();
                merryGoRound.merryGoRoundLimit(person);
            } else if(input == 2) {
                GyroDrop gyroDrop = new GyroDrop();
                gyroDrop.gyroDropLimit(person);
            } else if (input == 3) {
                Viking viking = new Viking();
                viking.vikingLimit(person);
            } else {
                System.out.println("집에 갈래!!!!!!!!!!!!!");
            }
            break;
        }

    }

    public void goHome() {
        hm.allPrint();
        System.out.print("집에 갈 사람의 이름을 입력하세요 : ");
        String name2 = sc.next();
        PersonDTO person2 = hm.selectPerson(name2);
        hm.goHomePerson(person2);
    }


}
