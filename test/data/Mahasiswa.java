package data;

public class Mahasiswa {
  private String name;
  private int age;

  Mahasiswa() {
  }

  public Mahasiswa(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}