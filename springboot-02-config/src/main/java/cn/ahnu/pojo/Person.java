package cn.ahnu.pojo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
@Validated  //数据校验
public class Person {
    private int id;
    @Email(message = "email格式错误")
    private String name;
    private Dog dog;
    private Map<String, Object> maps;
    private List<String> list;

    public Person() {
    }

    public Person(int id, String name, Dog dog, Map<String, Object> maps, List<String> list) {
        this.id = id;
        this.name = name;
        this.dog = dog;
        this.maps = maps;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                ", maps=" + maps +
                ", list=" + list +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
