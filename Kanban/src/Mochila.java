
public class Mochila implements IDashboard {

	private Source[] mochila;
	
	public boolean Agregar(Source tarea){
		return true;
	}
	
	public boolean Remover(Source tarea){
		return true;
	}

	public Source[] getMochila() {
		return mochila;
	}

	public void setMochila(Source[] mochila) {
		this.mochila = mochila;
	}
	
}
