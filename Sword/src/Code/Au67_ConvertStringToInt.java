package Code;

public class Au67_ConvertStringToInt {

	public static int convert(String str){
		char c;
		char sign = '+';
		int num = 0;
		
		if(str == null || str.isEmpty())
			return 0;
		for(int i = 0; i < str.length(); i++){
			c = str.charAt(i);
			if(i == 0){
				if(c == '+'|| c =='-')
					sign = c;
			}else{
				if(c < '0' || c > '9')
					return 0;
				else{
					if((Integer.MAX_VALUE - num * 10 < c - '0') || (Integer.MIN_VALUE + num * 10 > '0' - c))
						return 0;
					num = num * 10 + c - '0';	
				}
			}
		}
		if(sign == '-')
			num *= -1;
		return num;
	}
	public static void main(String[] args) {
//		String a = "90a9d";
//		String a = "-97-99";
		String a = "-2147483649";
		System.out.println(convert(a));
	}
}
