package Ej02;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ej02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fentrada;
		DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db=factoria.newDocumentBuilder();
			fentrada=new FileInputStream("DOM2.xml");
			Document DOM=db.parse(fentrada);
			Element raiz=DOM.getDocumentElement();
			NodeList lista=raiz.getElementsByTagName("Vendedor");
			
			for (int i = 0; i < lista.getLength(); i++) {
				Element evendedor=(Element) lista.item(i);
				Element enombre=(Element) evendedor.getElementsByTagName("Nombre").item(0);
				Element eapellido=(Element) evendedor.getElementsByTagName("Apellidos").item(0);
				Element eventa=(Element) evendedor.getElementsByTagName("Ventas").item(0);
				
				double venta=Double.valueOf(eventa.getTextContent());
				double comision=venta*0.07;
				System.out.println("Comercial : "+enombre.getTextContent()+" "+eapellido.getTextContent()+" | Ventas = "+eventa.getTextContent()+" | comision = "+comision);
				
			}
		} catch (Exception e) {e.printStackTrace();}
		

	}

}
