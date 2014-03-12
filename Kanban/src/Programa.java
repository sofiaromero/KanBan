
public class Programa {

	public static void main(String[] args){
		
		Source tarea = new Source();
		tarea.setDescripcion("Completar el programa");
		tarea.setEstado(estado.DO_TO);
		
		IDashboard dashboard = new Mochila();
		if (dashboard.Agregar(tarea)){
			System.out.println("Added");
		}
		
		
		Mochila lista = new Mochila();
		if (lista.Agregar(tarea)){
			System.out.println("Agregada");
		}
		
	}
	
}
