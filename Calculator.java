import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Calculator {


	public static int calculate(String str){
		if(str.equals("")){
			return 0;
		}
		else{
			String regex = ",";
			if(str.matches("//(.*)\n(.*)")){
				regex = Character.toString(str.charAt(2));
				str = str.substring(4);
			}
			
			String numList[] = splitNum(str, regex + "|\n");
			return sum(numList);
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNum(String numbers, String divider){
	    return numbers.split(divider);
	}

	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
        	if(toInt(number) < 1000)
        	 	total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
    }
}
