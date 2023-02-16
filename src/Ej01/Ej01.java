package Ej01;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ej01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fentrada;
		DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
		
		
		try {
			DocumentBuilder db=factoria.newDocumentBuilder();
			fentrada=new FileInputStream("DOM1.xml");
			Document DOM=db.parse(fentrada);
			Element raiz=DOM.getDocumentElement();
			NodeList lista=raiz.getElementsByTagName("alumno");
			
			double media_general=0;
			double nota1=0;
			double nota2=0;
			
			for (int i = 0; i < lista.getLength(); i++) {
				Element ealumno=(Element) lista.item(i);
				Element enombre=(Element) ealumno.getElementsByTagName("nombre").item(0);
				Element enota1=(Element) ealumno.getElementsByTagName("programacion").item(0);
				Element enota2=(Element) ealumno.getElementsByTagName("acceso").item(0);
				
				String nombre_alumno=enombre.getTextContent();
				nota1=Double.valueOf(enota1.getTextContent());
				nota2=Double.valueOf(enota2.getTextContent());
				double media_alumno=(nota1+nota2)/2;
				media_general=(media_general+media_alumno);
				nota1=0;
				nota2=0;

				System.out.println("Nota media de "+nombre_alumno+" = "+media_alumno);
				
			}
			
			media_general=media_general/lista.getLength();
			System.out.println("Media general: "+media_general);
			
			
			
		} catch (Exception e) {e.printStackTrace();}
		

	}

}
