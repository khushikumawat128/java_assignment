class Main{
	public static void main(String[] args) {
		Cktplayer cp= new Cktplayer("Virat Kohli", 12000);
		Ftplayer fp = new Ftplayer("Cristiano Ronaldo",400);
		cp.printDetails();
		System.out.println();
		fp.printDetails();
	}
}
interface Printable{
	public void printDetails();
}

class Cktplayer implements Printable{
	private String name;
	private int run;

	public Cktplayer(String name, int run){
		this.name=name;
		this.run=run;
	}
	public void printDetails(){
		System.out.println("Cricketer Name :-"+name);
		System.out.println("Runs made :-"+run);
	}
}

class Ftplayer implements Printable{
	private String name;
	private int goal;

	public Ftplayer(String name, int goal){
		this.name=name;
		this.goal=goal;
	}

	public void printDetails(){
		System.out.println("Football Player Name :-"+name);
		System.out.println("Goals made :-"+goal);
	}
}