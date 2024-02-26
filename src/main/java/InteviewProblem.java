import java.util.ArrayList;
import java.util.List;

public class InteviewProblem {

	
	public static void main(String[] args) {
		
		String names[] = {"aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah", "allessandra", "allianna",
		            "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle", "annebelle"};
		
	
		for(String name: names) {
			 System.out.println( name);
			if(name.startsWith("aa")) {
				
				String aaname= name;
				/// Find the unique characters in the string
				for(int i=0;i<name.length();i++)
				{
					 // take the first char and compare it with aaname;
					 String alphabet = name.substring(i,1);
					 System.out.println(" Alphabet for compare " + alphabet);
					 boolean found = false;
					 String uniqueChars = "";
					 for(int j=0;j<aaname.length();j++)
					 {
						if(aaname.substring(j).equalsIgnoreCase(alphabet)) {
							found = true;
							uniqueChars = uniqueChars+aaname.substring(j);
 							break;
						}
					 }
					 
					 System.out.println(" Unique Characters :: = " + uniqueChars);
					 
					 
				}
				
				
				
			}
		}
	}
}
