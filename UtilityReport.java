import java.util.Map;
import java.util.HashMap;

class UtilityReport{
	private Map<String,Double> m;

	public UtilityReport(){
		this.m= new HashMap<>();
	}

	public void addStudent(String studentName,double percentage){
		m.put(studentName,percentage);
	}

	public void showReport(){
		System.out.println("Student Report :");
		for(Map.Entry<String,Double> entry : m.entrySet()){
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
	}

	public static void main(String[] args) {
	UtilityReport report = new UtilityReport();

	report.addStudent("khushi",90.5);
	report.addStudent("disha",75);	
	report.showReport();
	}
}