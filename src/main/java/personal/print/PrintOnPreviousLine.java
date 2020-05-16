package personal.print;

//https://stackoverflow.com/questions/2864622/how-do-i-run-class-files-on-windows-from-command-line
public class PrintOnPreviousLine {
	
	public static void main(String[] args){
		System.out.println(" abcd");  //you have to add " " at beginning
//		System.out.println("\033[1A" + "\033[2J" + "1234");
		//1A is 1 line, 2A is 2 lines, 0 is second char, 1 is third, can not go to first, what is why we need " abcd" in first print.
		System.out.println("\033[1A\033["  + 0 + 'C' + "1234"); 
	}

}
