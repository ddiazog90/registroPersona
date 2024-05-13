package model;

import java.util.Arrays;

import libreriaVersion2.generic;

public class person {
 
	private generic<String,String>dt_p;
	private generic<Integer,String>dte_p;
	public person() {
		dt_p=new generic<>();
		dte_p=new generic<>();
	}
	public person(String names, int age, String dni, String gender,String studiesLevel,String path,String...hobbies) {
	dt_p=new generic<>(names,gender,studiesLevel,dni);
		dt_p.loadElements(hobbies);
		dte_p=new generic<>(age,path);
	}
	public String getNames() {
		return dt_p.getAttribute1();
	}
	public String getGender() {
		return dt_p.getAttribute2();
	}
	public String getStudiesLevel() {
		return dt_p.getAttribute3();
	}
	public String[] getHobbies() {
		return dt_p.getAttribute5();
	}
	public void setNames(String names) {
		dt_p.setAttribute1(names);
	}
	public void setGender(String gender) {
		dt_p.setAttribute2(gender);
	}
	public void setStudiesLevel(String level) {
		dt_p.setAttribute3(level);
	}
	public void setHobbies(String...hobbies) {
		dt_p.loadElements(hobbies);
	}
	public int getAge() {
		return dte_p.getAttribute1();
	}
	public String getDNI() {
		return dt_p.getAttribute4();
	}
	public void setAge(int age) {
		dte_p.setAttribute1(age);
	}
	public void setDNI(String dni) {
		dt_p.setAttribute4(dni);
	}
	public String getPathImage() {
		return dte_p.getAttribute3();
	}
	public void setPathImage(String path) {
		dte_p.setAttribute3(path);
	}
	@Override
	public String toString() {
		return "person [getNames()=" + getNames() + ", getGender()=" + getGender() + ", getStudiesLevel()="
				+ getStudiesLevel() + ", getHobies()=" + Arrays.toString(getHobbies()) + ", getAge()=" + getAge()
				+ ", getDNI()=" + getDNI() + "]";
	}

	public String personalInfo() {
		String hobbies="";
		for(String h:getHobbies()) {
			hobbies+=h;
		}
		return String.format("%s;%d;%s;%s;%s;%s;%s",getNames(),getAge(),getDNI(),getGender(),getStudiesLevel(),hobbies,getPathImage());
	}
	



}
