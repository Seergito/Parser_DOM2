package Ej04;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Ej04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fentrada;
		DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db=factoria.newDocumentBuilder();
			fentrada=new FileInputStream("DOM4.xml");
			Document DOM=db.parse(fentrada);
			Element raiz=DOM.getDocumentElement();
			NodeList lista=raiz.getElementsByTagName("producto");
			
			Element eliminar=null;
			boolean del=false;
			
			for (int i = 0; i < lista.getLength(); i++) {
				Element producto=(Element) lista.item(i);
				
				if(producto.getAttribute("codigo").equals("926-FH")) {
					del=true;
					eliminar=producto;
				}
			}
			if(del==true) {
				System.out.println("Eliminando producto...");
				raiz.removeChild(eliminar);
			}else {System.out.println("No se ha encontrado el producto");}
			
		
			Element eproducto_n=DOM.createElement("producto");
			eproducto_n.setAttribute("codigo","930-AH");
			raiz.appendChild(eproducto_n);
			
			Element enombre=DOM.createElement("nombre");
			enombre.setTextContent("MotoSierra");
			eproducto_n.appendChild(enombre);
			
			Element ecantidad=DOM.createElement("cantidad");
			ecantidad.setTextContent("2");
			eproducto_n.appendChild(ecantidad);
			
			Element eprecio=DOM.createElement("precio");
			eprecio.setTextContent("354.78");
			eproducto_n.appendChild(eprecio);
			
			UtilidadesDOM.crearficheroxml(DOM, "pedidomodificado.xml");
			
		} catch (Exception e) {e.printStackTrace();}
		
		
	}
}
