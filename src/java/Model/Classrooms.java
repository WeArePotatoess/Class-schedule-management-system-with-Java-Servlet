/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Classrooms {

    private String id, name, buidingName, description;

    public Classrooms() {
    }

    public Classrooms(String id, String name, String buidingName, String description) {
        this.id = id;
        this.name = name;
        this.buidingName = buidingName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuidingName() {
        return buidingName;
    }

    public void setBuidingName(String buidingName) {
        this.buidingName = buidingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
