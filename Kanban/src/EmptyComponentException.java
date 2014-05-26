import javax.swing.JComponent;


public class EmptyComponentException extends Exception{
	
	private JComponent component;
	
	public JComponent getComponent(){
		return component;
	}
	
	public EmptyComponentException(String message, JComponent component){
		super(message);
		this.component=component;}
	
}
