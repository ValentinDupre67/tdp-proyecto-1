package gui;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textFieldLU;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldEMail;
	private JTextField textFieldGitHub;
	private JLabel lbImage;
	
	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.setVisible(true);
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(777, 330));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 525, 260);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(475, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLU.setBounds(20, 19, 82, 27);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblApellido.setBounds(20, 57, 82, 27);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setBounds(20, 95, 82, 27);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(20, 133, 82, 27);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("github URL");
		lblGithubUrl.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGithubUrl.setBounds(20, 171, 102, 27);
		tabInformation.add(lblGithubUrl);
		
		textFieldLU = new JTextField();
		textFieldLU.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldLU.setEditable(false);
		textFieldLU.setBackground(Color.WHITE);
		textFieldLU.setDisabledTextColor(Color.WHITE);
		textFieldLU.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldLU.setText(Integer.toString(studentData.getId()));
		textFieldLU.setBounds(138, 17, 355, 27);
		tabInformation.add(textFieldLU);
		textFieldLU.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setDisabledTextColor(Color.WHITE);
		textFieldApellido.setBorder(new LineBorder(Color.BLACK));
		textFieldApellido.setBackground(Color.WHITE);
		textFieldApellido.setEditable(false);
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldApellido.setText(studentData.getLastName());
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(138, 55, 355, 27);
		tabInformation.add(textFieldApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBorder(new LineBorder(Color.BLACK));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBackground(Color.WHITE);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNombre.setText(studentData.getFirstName());
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(138, 93, 355, 27);
		tabInformation.add(textFieldNombre);
		
		textFieldEMail = new JTextField();
		textFieldEMail.setBorder(new LineBorder(Color.BLACK));
		textFieldEMail.setBackground(Color.WHITE);
		textFieldEMail.setEditable(false);
		textFieldEMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEMail.setText(studentData.getMail());
		textFieldEMail.setColumns(10);
		textFieldEMail.setBounds(138, 134, 355, 27);
		tabInformation.add(textFieldEMail);
		
		textFieldGitHub = new JTextField();
		textFieldGitHub.setBorder(new LineBorder(Color.BLACK));
		textFieldGitHub.setEditable(false);
		textFieldGitHub.setBackground(Color.WHITE);
		textFieldGitHub.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldGitHub.setText(studentData.getGithubURL());
		textFieldGitHub.setColumns(10);
		textFieldGitHub.setBounds(138, 172, 355, 27);
		tabInformation.add(textFieldGitHub);
		contentPane.add(tabbedPane);
		
		lbImage = new JLabel("New label");
		lbImage.setBounds(547, 25, 206, 240);
		contentPane.add(lbImage);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource(studentData.getPathPhoto()));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(lbImage.getWidth(),
                lbImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
       lbImage.setIcon(iconoEscalado);
       
       Date objFecha = new Date();
       Date objTime = new Date();
       
       String strFechaFormat = " d/M/y";
       SimpleDateFormat objSDFFecha = new SimpleDateFormat(strFechaFormat);
       String strTimeFormat = "hh:mm:ss";
       SimpleDateFormat objSDFTime = new SimpleDateFormat(strTimeFormat);
    		   
       JLabel lblTime = new JLabel("Esta ventana fue generada el"+objSDFFecha.format(objFecha)+" a las "+objSDFTime.format(objTime));
       lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
       
       //objSDFTime.format(objTime)
       lblTime.setBounds(5, 265, 415, 25);
       contentPane.add(lblTime);
       
       
       
      
}}

