package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import libreriaVersion2.files;
import model.person;
import model.personDAO;
import view.view_register;

public class logic_view_register implements ActionListener{

	private view_register vr;
	private person p=new person();
	private personDAO pdao=new personDAO();
	private files photo = new files("");
	private List<person>persons=new ArrayList();

		
	public logic_view_register(view_register vr) {
		super();
		this.vr = vr;
		this.vr.btn_photo.addActionListener(this);
		this.vr.btn_save.addActionListener(this);
		this.vr.btn_search.addActionListener(this);
		//Cargar los niveles de estudio
		loadStudiesLevel();
	}
	private void loadStudiesLevel() {
		String [] studies= {"Primaria","Secundaria","Superior","Posgrado","Doctorado"};
		for(String st:studies) {
			vr.cbn_level.addItem(st);
		}
	}

	//Abrir un foto en un label
	private void loadPhoto(String path) {
		ImageIcon imgPhoto=new ImageIcon(path);
		vr.lbl_photo.setIcon(imgPhoto);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vr.btn_photo) {
			//Eventos para captura la foto
//			JOptionPane.showMessageDialog(vr, "Cargar Foto");
			
			photo.getFileChooser(vr, "jpeg");
			loadPhoto(photo.getFile().getAbsolutePath());
			
		}else if(e.getSource()==vr.btn_save) {
			//Eventos para guardar los datos
//			JOptionPane.showMessageDialog(vr, "Boton para Guardar Datos");
			if(validate()) {
				p.setNames(vr.txt_names.getText());
				p.setAge(Integer.parseInt(vr.sp_age.getValue().toString()));
				p.setDNI(vr.txt_cedula.getText());
				if(vr.rbtn_female.isSelected()) {
					p.setGender("Femenino");
				}else {
					p.setGender("Masculino");
				}
				p.setStudiesLevel(vr.cbn_level.getSelectedItem().toString());
				p.setHobbies(getHobbies());
				//Guardar Imagen
				saveFilePhoto();
				try {
					pdao.writerPerson(p);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(vr, "Campos Incorrectos");
			}
			
			
		}else if(e.getSource()==vr.btn_search) {
			p.setDNI(JOptionPane.showInputDialog(vr,"Ingrese el DNI?"));
			try {
				persons=pdao.readerPerson();
				for(person ps:persons) {
					if(ps.getDNI().equals(p.getDNI())) {
						this.p=ps;
						vr.txt_names.setText(p.getNames());
						vr.txt_cedula.setText(p.getDNI());
						loadPhoto(p.getPathImage());
						//terminar de implementar la carga de datos
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(vr, "Error al consultar los datos");
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
		
		if(validateFields.validateDNI(vr.txt_cedula.getText())) {
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

	//Obtener los hobbies seleccionados
	private String getHobbies() {
		String hobbies="";
		if(vr.chb_playGames.isSelected()) {
			hobbies+=vr.chb_playGames.getText()+",";
		}
		if(vr.chb_playSoccer.isSelected()) {
			hobbies+=vr.chb_playSoccer.getText()+",";
		}
		if(vr.chb_readBooks.isSelected()) {
			hobbies+=vr.chb_readBooks.getText()+",";
		}
		if(vr.chb_songMusic.isSelected()) {
			hobbies+=vr.chb_songMusic.getText()+",";
		}
		if(vr.chb_toCamp.isSelected()) {
			hobbies+=vr.chb_toCamp.getText()+",";
		}
		if(vr.chb_watchMovies.isSelected()) {
			hobbies+=vr.chb_watchMovies.getText()+",";
		}
		return hobbies;
	}

	//Copiar un archivo de imagen
	private void saveFilePhoto() {
		files photoDest=new files(pdao.mainPath+"/"+p.getDNI()+".jpeg");
//		p.setPathImage(photo.getFile().getAbsolutePath());
		try {
			Files.copy(photo.getFile().toPath(), photoDest.getFile().toPath());
			//copiar el path de la imagen
			p.setPathImage(photoDest.getFile().getAbsolutePath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
