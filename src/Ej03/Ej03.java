package Ej03;


import java.util.Scanner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Ej03 {
	
	static Scanner entrada;
	static String[] valores = new String[3];
	public static int menu() {
		System.out.println("1. Rellenar menu 1");
		System.out.println("2. Rellenar menu 2");
		System.out.println("3. Rellenar menu 3");
		System.out.println("4. Salir");
		int opcion=entrada.nextInt();entrada.nextLine();
		return opcion;
	}
	
	public static String[] fill() {
	
		System.out.println("Introduce el nombre del plato");
		valores[0]=entrada.nextLine();
		System.out.println("Introduce el precio del plato");
		valores[1]=entrada.nextLine();
		System.out.println("Introduce las calorias del plato");
		valores[2]=entrada.nextLine();
		return valores;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		 entrada=new Scanner(System.in);
		
		try {
			Document DOM=UtilidadesDOM.generararbolDOMvacio();
			
			Element root=DOM.createElement("restaurante");
			DOM.appendChild(root);
			
			root.setAttribute("web", "https://mirestaurante.org");
			
			
			Element fiscal=DOM.createElement("datosfiscales");
			root.appendChild(fiscal);
			
			Element egerente=DOM.createElement("gerente");
			Element edireccion=DOM.createElement("direccion");
			Element enif=DOM.createElement("nif");
			
			egerente.setTextContent("Alicia Abad");
			edireccion.setTextContent("Plaza de la duquesa 12");
			enif.setTextContent("11222333A");
			
			
			root.appendChild(fiscal);
			fiscal.appendChild(egerente);
			fiscal.appendChild(edireccion);
			fiscal.appendChild(enif);
			
			
			Element emenu1=DOM.createElement("menu");
			emenu1.setAttribute("ID","1");
			
			Element emenu2=DOM.createElement("menu");
			emenu2.setAttribute("ID", "2");
			
			Element emenu3=DOM.createElement("menu");
			emenu3.setAttribute("ID", "3");
			
			root.appendChild(emenu1);
			root.appendChild(emenu2);
			root.appendChild(emenu3);
			
			
				
			boolean fin=false;
			while(fin!=true) {
				
				switch(menu()) {
				case 1:
					fill();
					
					Element enombre=DOM.createElement("nombre");
					Element eprecio=DOM.createElement("precio");
					Element ecalorias=DOM.createElement("calorias");
					
					emenu1.appendChild(enombre);
					emenu1.appendChild(eprecio);
					emenu1.appendChild(ecalorias);
					
					enombre.setTextContent(valores[0]);
					eprecio.setTextContent(valores[1]);
					ecalorias.setTextContent(valores[2]);
					break;
				case 2:
					fill();
					Element enombre2=DOM.createElement("nombre");
					Element eprecio2=DOM.createElement("precio");
					Element ecalorias2=DOM.createElement("calorias");
					
					emenu2.appendChild(enombre2);
					emenu2.appendChild(eprecio2);
					emenu2.appendChild(ecalorias2);
					
					enombre2.setTextContent(valores[0]);
					eprecio2.setTextContent(valores[1]);
					ecalorias2.setTextContent(valores[2]);
					break;
				case 3:
					fill();
					
					Element enombre3=DOM.createElement("nombre");
					Element eprecio3=DOM.createElement("precio");
					Element ecalorias3=DOM.createElement("calorias");
					
					
					emenu3.appendChild(enombre3);
					emenu3.appendChild(eprecio3);
					emenu3.appendChild(ecalorias3);
					
					enombre3.setTextContent(valores[0]);
					eprecio3.setTextContent(valores[1]);
					ecalorias3.setTextContent(valores[2]);
					break;
				case 4:
					fin=true;
					System.out.println("");
					System.out.println("Carta creada");
					break;
					default:
						break;
				}
			}
			
			UtilidadesDOM.crearficheroxml(DOM, "DOM3.xml");
			
			
		} catch (Exception e) {e.printStackTrace();}
		

	}

}
