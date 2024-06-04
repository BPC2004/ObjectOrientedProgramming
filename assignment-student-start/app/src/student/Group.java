/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Gebruiker
 */
public class Group {
    private Student[] all;
    private int numStud;

    public Group(int amount) {
        all = new Student[amount];
        numStud = 0;
    }
    
    public void addStudent (Student name, int place) {
        all[place] = name;
    }

    public String toString(){
        numStud = all.length;
        String list = "";
        for (int i = 0; i < numStud; i++){
            String temp = all[i].toString() + "\n";
            list += temp;
        }
        return list;
    }

    public void editStudent(Student name, int stNumber){
        numStud = all.length;
        for(int i = 0; i < numStud; i++){
            if(all[i].toInt() == stNumber){
                all[i] = name;
                return;
            }
        }
    }
}
