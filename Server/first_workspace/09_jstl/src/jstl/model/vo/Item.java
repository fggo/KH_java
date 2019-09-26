package jstl.model.vo;

public class Item {

  private String name;
  private int level;
  private int defense;
  
  public Item() {
    // TODO Auto-generated constructor stub
  }

  public Item(String name, int level, int defense) {
    super();
    this.name = name;
    this.level = level;
    this.defense = defense;
  }
  
  @Override
  public String toString() {
    return "Item [name=" + name + ", level=" + level + ", defense=" + defense + "]";
  }

  public String getName() { return name; } 
  public void setName(String name) { this.name = name; } 
  public int getLevel() { return level; } 
  public void setLevel(int level) { this.level = level; } 
  public int getDefense() { return defense; } 
  public void setDefense(int defense) { this.defense = defense; } 
}
