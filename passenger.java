/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railwayticketmanagementsys;

/**
 *
 * @author ASUS
 */
public class passenger {
    static int id=1;
    String name;
    int age;
    String breathPreference;
    int passangerId;
    String alloted;
    int Snumber;
    passenger(String name,int age,String breathPreference)
    {
        this.name=name;
        this.age=age;
        this.breathPreference=breathPreference;
        this.passangerId=id++;
        alloted="";
        Snumber=-1;
    }
}
