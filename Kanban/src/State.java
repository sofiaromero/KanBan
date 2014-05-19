enum State {
	
	BACKLOG("PENDIENTE"), TO_DO("TO DO"), IN_PROGRESS("IN PROGRESS"), DONE("DONE");
	
	private String description;
	State (String description){
		this.description=description;
	}
	public String toString(){
		return description;
	}
	
}
//