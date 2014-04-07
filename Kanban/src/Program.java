import java.util.Date;

public class Program {
//
	public static IDashboard dashboard = new DashboardList();

	public static void main(String[] args) throws Exception {
		System.out.println("Start " + new Date());

		Thread thread;
		User user;
		for (int i = 0; i < 15; i++){
			user = new User();
			thread = new Thread(user);
			thread.setName("Title" + i);
			int priority = 1 + (int) (Math.random() * ((10 - 1) + 1));
			thread.setPriority(priority);
			thread.start();
		}

		// SLEEP
		/*
		Task task;
		for (int i = 0; i < 15; i++) {
			task = new Task("Task " + i, State.DO_TO);
			if (task.save()) {
				System.out.println("Saved " + task);
			}
		}
		*/

		System.out.println("End " + new Date());
	}

}
