import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Procesos {
	 HashMap<String, ArrayList<String>>map;
	 ArrayList<String>ciudades;
	 
	 
	 
public Procesos() {
		map=new  HashMap<String, ArrayList<String>>();
		iniciar();
	}
	
	
public void iniciar() {
	
		String menu="Menu \n";
		menu+="1. registrar paises y ciudades\n";
		menu+="2. consultar por pais la lista de ciudades asociadas\n";
		menu+="3. consultar ciudad\n";
		menu+="4. salir\n";
		
		int op=0;
		
		do {
			
			 op=Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarOpcion(op);
		}while(op!=4);
		
		
		
}

public void validarOpcion(int op) {
		switch(op) {
		case 1: String preg;
			do {
			registrarDatos();
			   preg=JOptionPane.showInputDialog("desea registrar mas paises ing si ");
			}while(preg.equalsIgnoreCase("si"));
		break;
		case 2:consultarCiudadesAsociadas();
		break;
		case 3:consultarCiudad();
		break;
		case 4:System.out.println("chao");
			default:JOptionPane.showMessageDialog(null, "no existe la opcion");
				break;
		}
		
		
}
			   
			   
			 
	


private void consultarCiudad() {

	
	 String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad:");

	    String paisEncontrado = null;

	  
	    for (String pais : map.keySet()) {
	        ArrayList<String> ciudades = map.get(pais);

	       
	        if (ciudades.contains(ciudad)) {
	            paisEncontrado = pais;
	            break;
	        }
	    }

	    if (paisEncontrado != null) {
	        JOptionPane.showMessageDialog(null, "La ciudad " + ciudad + " pertenece al país " + paisEncontrado);
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontró el país al que pertenece la ciudad especificada.");
	    }
	

	
	
	
	
	
}


private void consultarCiudadesAsociadas() {

	  String pais = JOptionPane.showInputDialog("Ingrese el país:");

	    ArrayList<String> ciudadesAsociadas = map.get(pais);

	    if (ciudadesAsociadas != null) {
	        System.out.println("Ciudades asociadas a " + pais + ":");
	        Iterator<String> iterator = ciudadesAsociadas.iterator();
	        while (iterator.hasNext()) {
	            String ciudad = iterator.next();
	            System.out.println(ciudad);
	        }
	    } else {
	        System.out.println("No se encontró el país especificado.");
	    }
}


private void registrarDatos() {
		
		ciudades=new ArrayList<String>();
				
		String pais =JOptionPane.showInputDialog("ingrese el pais");
		
		int cant=Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de ciudades"));
		
		for (int i = 0; i < cant; i++) {
			String ciudad=JOptionPane.showInputDialog("ingrese la ciudad: "+ (i+1));
			ciudades.add(ciudad);
		}
		
		map.put(pais,ciudades);
		
		System.out.println(map);
		
	}
	
	
}
