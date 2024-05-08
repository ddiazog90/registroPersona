package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.person;
import model.personDAO;
import view.view_register;

public class logic_view_register implements ActionListener{

	private view_register vr;
	private person p=new person();
	private personDAO pdao=new personDAO();
		
	public logic_view_register(view_register vr) {
		super();
		this.vr = vr;
		this.vr.btn_photo.addActionListener(this);
		this.vr.btn_save.addActionListener(this);
		//Cargar los niveles de estudio
		loadStudiesLevel();
	}
	private void loadStudiesLevel() {
		String [] studies= {"Primaria","Secundaria","Superior","Posgrado","Doctorado"};
		for(String st:studies) {
			vr.cbn_level.addItem(st);
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vr.btn_photo) {
			//Eventos para captura la foto
			JOptionPane.showMessageDialog(vr, "Cargar Foto");
		}else if(e.getSource()==vr.btn_save) {
			//Eventos para guardar los datos
//			JOptionPane.showMessageDialog(vr, "Boton para Guardar Datos");
			if(validate()) {
				p.setNames(vr.txt_names.getText());
				p.setAge(Integer.parseInt(vr.sp_age.getValue().toString()));
				p.setDNI(Long.parseLong(vr.txt_cedula.getText()));
				if(vr.rbtn_female.isSelected()) {
					p.setGender("Femenino");
				}else {
					p.setGender("Masculino");
				}
				p.setStudiesLevel(vr.cbn_level.getSelectedItem().toString());
				p.setHobbies("Leer","Programar");
				try {
					pdao.writerPerson(p);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(vr, "Campos Incorrectos");
			}
			
			
		}
		
	}
	//Validar el paso correcto de datos
	private boolean validate() {
		boolean estate=true;
		if(validateFields.validateNames(vr.txt_names.getText())) {
			vr.txt_names.setBackground(Color.green);
		}else {
			vr.txt_names.setBackground(Color.red);
			estate=false;
		}
		
		if(validateFields.validateDNI(Long.parseLong(vr.txt_cedula.getText()))) {
			vr.txt_cedula.setBackground(Color.green);
		}else {
			vr.txt_cedula.setBackground(Color.red);
			estate=false;
		}
		
		if(validateFields.validateAge(Integer.parseInt(vr.sp_age.getValue().toString()))) {
			vr.sp_age.setBackground(Color.green);
		}else {
			vr.sp_age.setBackground(Color.red);
			estate=false;
		}
		
		return estate;
	}

}
