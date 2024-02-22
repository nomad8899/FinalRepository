package com.one.model.dto;


public class GyroDrop extends PersonDTO {

    PersonDTO personDTO = new PersonDTO();
    public GyroDrop() {

    }


    public GyroDrop(String name, int age, double height) {
        super(name, age, height);
    }

    public void gyroDropLimit(PersonDTO person) {
        double heightLimit = 170.0;

        if(heightLimit <= person.getHeight()) {
            System.out.println("탑승 할 수 있습니다.");
        } else {
            System.out.println("회전목마나 타세요");
        }
    }

}
