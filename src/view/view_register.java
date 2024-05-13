package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controller.logic_view_register;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class view_register extends JFrame {

	private static final long serialVersionUID = 1L;
	//Crear la refencia al Panel
	private JPanel contentPane;
	public JTextField txt_names;
	public JTextField txt_cedula;
	//Agrupar los radio button de la intefaz
	public ButtonGroup genero;
	public JSpinner sp_age;
	public JRadioButton rbtn_male;
	public JRadioButton rbtn_female;
	public JCheckBox chb_playSoccer;
	public JCheckBox chb_playGames;
	public JCheckBox chb_readBooks;
	public JCheckBox chb_watchMovies;
	public JCheckBox chb_songMusic;
	public JCheckBox chb_toCamp;
	public JButton btn_photo;
	public JButton btn_save;
	public JLabel lbl_photo;
	public JComboBox cbn_level;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_register frame = new view_register();
					//Visualizar la ventana
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		//Retirar la opcion para cambiar la dimension de una ventana
		setResizable(false);
		//Agregar un titulo en la ventana
		setTitle("Register");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_register = new JPanel();
		pn_register.setBorder(new TitledBorder(null, "Registro de usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pn_register.setBackground(Color.WHITE);
		pn_register.setBounds(0, 0, 486, 363);
		contentPane.add(pn_register);
		pn_register.setLayout(null);
		
		JLabel lbl_etiqueta1 = new JLabel("NOMBRES:");
		lbl_etiqueta1.setBounds(10, 21, 102, 13);
		lbl_etiqueta1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_etiqueta1.setForeground(Color.BLUE);
		lbl_etiqueta1.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1);
		
		JLabel lbl_etiqueta1_1 = new JLabel("EDAD:");
		lbl_etiqueta1_1.setBounds(10, 56, 102, 13);
		lbl_etiqueta1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_etiqueta1_1.setForeground(Color.BLUE);
		lbl_etiqueta1_1.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1_1);
		
		JLabel lbl_etiqueta1_2 = new JLabel("CEDULA:");
		lbl_etiqueta1_2.setBounds(10, 96, 102, 13);
		lbl_etiqueta1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_etiqueta1_2.setForeground(Color.BLUE);
		lbl_etiqueta1_2.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1_2);
		
		JLabel lbl_etiqueta1_3 = new JLabel("GENERO:");
		lbl_etiqueta1_3.setBounds(10, 140, 102, 13);
		lbl_etiqueta1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_etiqueta1_3.setForeground(Color.BLUE);
		lbl_etiqueta1_3.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1_3);
		
		JLabel lbl_etiqueta1_4 = new JLabel("HOBBIES:");
		lbl_etiqueta1_4.setBounds(10, 181, 102, 13);
		lbl_etiqueta1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_etiqueta1_4.setForeground(Color.BLUE);
		lbl_etiqueta1_4.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1_4);
		
		JLabel lbl_etiqueta1_5 = new JLabel("NIVEL DE ESTUDIOS:");
		lbl_etiqueta1_5.setBounds(10, 269, 169, 13);
		lbl_etiqueta1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_etiqueta1_5.setForeground(Color.BLUE);
		lbl_etiqueta1_5.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1_5);
		
		JPanel pn_photo = new JPanel();
		pn_photo.setBounds(346, 21, 130, 149);
		pn_photo.setBackground(Color.BLACK);
		pn_register.add(pn_photo);
		pn_photo.setLayout(null);
		
		lbl_photo = new JLabel("");
		
		lbl_photo.setIcon(new ImageIcon(view_register.class.getResource("/view/multimedia/images/usuario.png")));
		lbl_photo.setBounds(10, 10, 110, 129);
		pn_photo.add(lbl_photo);
		
		txt_names = new JTextField();
		txt_names.setBounds(122, 10, 214, 28);
		txt_names.setFont(new Font("Century", Font.PLAIN, 12));
		pn_register.add(txt_names);
		txt_names.setColumns(10);
		
		txt_cedula = new JTextField();
		txt_cedula.setToolTipText("Formato: 1716975501 o 171697550-1");
		txt_cedula.setBounds(122, 90, 214, 28);
		txt_cedula.setFont(new Font("Century", Font.PLAIN, 12));
		txt_cedula.setColumns(10);
		pn_register.add(txt_cedula);
		
		sp_age = new JSpinner();
		sp_age.setBounds(122, 50, 45, 20);
		sp_age.setFont(new Font("Century", Font.PLAIN, 12));
		pn_register.add(sp_age);
		
		JLabel lbl_etiqueta1_1_1 = new JLabel("");
		lbl_etiqueta1_1_1.setBounds(177, 56, 39, 13);
		lbl_etiqueta1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_etiqueta1_1_1.setForeground(Color.BLUE);
		lbl_etiqueta1_1_1.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1_1_1);
		
		JLabel lbl_etiqueta1_1_2 = new JLabel("años");
		lbl_etiqueta1_1_2.setBounds(170, 57, 45, 13);
		lbl_etiqueta1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_etiqueta1_1_2.setForeground(Color.BLUE);
		lbl_etiqueta1_1_2.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(lbl_etiqueta1_1_2);
		
		rbtn_male = new JRadioButton("Masculino");
		rbtn_male.setBounds(128, 137, 103, 21);
		rbtn_male.setBackground(Color.WHITE);
		rbtn_male.setFont(new Font("Century", Font.PLAIN, 12));
		pn_register.add(rbtn_male);
		
		rbtn_female = new JRadioButton("Femenino");
		rbtn_female.setBounds(128, 160, 103, 21);
		rbtn_female.setFont(new Font("Century", Font.PLAIN, 12));
		rbtn_female.setBackground(Color.WHITE);
		pn_register.add(rbtn_female);
		//Permitir que se agrupo en un objeto
		genero=new ButtonGroup();
		genero.add(rbtn_female);
		genero.add(rbtn_male);
		
		chb_playSoccer = new JCheckBox("Jugar futbol");
		chb_playSoccer.setBounds(41, 200, 130, 21);
		chb_playSoccer.setFont(new Font("Century", Font.PLAIN, 12));
		chb_playSoccer.setBackground(Color.WHITE);
		pn_register.add(chb_playSoccer);
		
		chb_playGames = new JCheckBox("Jugar video juegos");
		chb_playGames.setBounds(41, 239, 130, 21);
		chb_playGames.setFont(new Font("Century", Font.PLAIN, 12));
		chb_playGames.setBackground(Color.WHITE);
		pn_register.add(chb_playGames);
		
		chb_readBooks = new JCheckBox("Leer ");
		chb_readBooks.setBounds(189, 201, 130, 21);
		chb_readBooks.setFont(new Font("Century", Font.PLAIN, 12));
		chb_readBooks.setBackground(Color.WHITE);
		pn_register.add(chb_readBooks);
		
		chb_watchMovies = new JCheckBox("Ver Peliculas");
		chb_watchMovies.setBounds(189, 240, 130, 21);
		chb_watchMovies.setFont(new Font("Century", Font.PLAIN, 12));
		chb_watchMovies.setBackground(Color.WHITE);
		pn_register.add(chb_watchMovies);
		
		chb_songMusic = new JCheckBox("Escuchar Musica");
		chb_songMusic.setBounds(328, 201, 130, 21);
		chb_songMusic.setFont(new Font("Century", Font.PLAIN, 12));
		chb_songMusic.setBackground(Color.WHITE);
		pn_register.add(chb_songMusic);
		
		chb_toCamp = new JCheckBox("Acampar");
		chb_toCamp.setBounds(328, 240, 130, 21);
		chb_toCamp.setFont(new Font("Century", Font.PLAIN, 12));
		chb_toCamp.setBackground(Color.WHITE);
		pn_register.add(chb_toCamp);
		
		cbn_level = new JComboBox();
		cbn_level.setBounds(189, 265, 287, 21);
		cbn_level.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pn_register.add(cbn_level);
		
		btn_save = new JButton("");
		btn_save.setToolTipText("Guardar");
		
		btn_save.setIcon(new ImageIcon(view_register.class.getResource("/view/multimedia/images/save.png")));
		btn_save.setBounds(406, 297, 50, 50);
		btn_save.setFont(new Font("Century", Font.BOLD, 12));
		pn_register.add(btn_save);
		
		btn_photo = new JButton("Foto");
		btn_photo.setFont(new Font("Century", Font.BOLD, 12));
		btn_photo.setBounds(403, 177, 73, 21);
		pn_register.add(btn_photo);
		
		//Declarar e instanciar al controlador
		logic_view_register lvr=new logic_view_register(this);
	}
}
