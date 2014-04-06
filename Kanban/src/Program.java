import java.util.Date;

public class Program {

	public static IDashboard dashboard = new DashboardList();
	
	public static void main(String[] args) throws Exception {
		System.out.println("Start " + new Date());
		Task task;
		for (int i = 0; i < 15; i++) {
			task = new Task("Task " + i, State.DO_TO);
			if (task.save()) {
				System.out.println("Saved " + task);
			}
		}
		
		System.out.println("End " + new Date());
	}
	
}
//