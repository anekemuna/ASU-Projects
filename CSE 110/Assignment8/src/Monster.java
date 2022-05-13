/*-------------------------------------------------------------------------
// Name: CSE110 instructor
// Title: Monster.java
// Description : A Monster for each element of Dungeon's  monsters[][]
// Date: Fall 2021
//----------------------------------------------------------------------*/
public class Monster{
	private String name; // Monster's name
	private int level;   // Monster's level

	// Default constructor used in 'a' command of the Assignment8.java
	public Monster(){
		name = "";		// default case = no name
		level = -1;		// defualt case = -1
	}
	//Cutsom constructor used in 'b' command of the Assignment8.java
	public Monster (String _name, int _level){
		name = _name;
		level = _level;
	}
	// Setter and Getter methods
	public String getName(){ return name;}
	public int getLevel() {return level;}
	public void setName(String _name) {name=_name;}
	public void setLevel(int _level) {level =_level;}

	// Checks whether the monster is equal to the other monster
	// Use this method in the Dungeon's updateMonster()
	public boolean equals(Monster other){
		if(name.equals(other.getName()) && level==other.getLevel()) return true;
		else return false;
	}
	// Returns the initial and level as a string data
	// Use this method in the Dungeon's printInfo()
	public String getInfo(){
		if(getLevel() == -1) return "*  ";
		else return getName().charAt(0) + "-"+ getLevel();
	}
}