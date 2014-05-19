import java.util.Date;

public class Task {
//
	private final Object addSave = new Object();
	private String title;
	private String description;
	private State state;
	private String category;
	private String priority;
	private String owner;
	private String dueDate;
	private Date createDate;

	public Task (String title, String description, State state, String category, String priority, String owner, String dueDate){
		 this.title=title;
		 this.description=description;
		 this.state=state;
		 this.category=category;
		 this.priority=priority;
		 this.owner=owner;
		 this.dueDate=dueDate;
	}
	
	public Task() {
		this("");
		System.out.println("starting Task() ctor...");
	}

	public Task (String title) {
		this(title, State.BACKLOG, (String) "1");
		System.out.println("staring Task (String) ctor...");

	}

	public Task(String title, String priority) {
		this(title, State.BACKLOG, priority);
		System.out.println("starting Task(String, Priority) ctor...");
	}

	public Task(String title, State state){
		this(title, state, (String) "1");
		System.out.println("starting Task(String, State) ctor...");
	}

	public Task(String title, State state, String priority) {
		super();
		System.out.println("starting Task(String, State, Priority) ctor...");

		this.title = title;
		createDate = new Date();
		this.priority = priority;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null) {
			this.title = title;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String toString() {
		return this.title;
	}

	public boolean equals(Object obj) {
		if (obj != null) {
			if (obj instanceof Task) {
				return title.equals(((Task) obj).getTitle());
			}
		}
		return false;
	}

	public synchronized boolean remove(){
		return true;
	}
	
	public boolean save(){
		synchronized (addSave){
			try{
				Thread.sleep(1*1000);
			} catch (InterruptedException e){
				e.printStackTrace();}
			return true;
		}
	}



}
