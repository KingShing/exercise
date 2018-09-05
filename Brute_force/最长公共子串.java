public class 最长公共子串{

	//字符串所有字串
	public static String[] getAllSubstrings(String str){
		if(str.length()==0)
			return null;
		int len = str.length();
		String strs[] = new String[len*(len+1)/2];
		int index = -1;
		for (int i = 0;i<len;i++ ) {
			for (int j =i+1;j<=len ; j++) {
				strs[++index] = str.substring(i,j);
			}
		}
		return strs;
	}


	//最长公共子串
	public static String getSameStr(String str1,String str2){
		String res  = "";
		for (String s : getAllSubstrings(str1)) {
			if(str2.contains(s))
				res  = s.length()>res.length()? s:res;
		}
		return res;
	}



	public static void main(String args[]){
		String str = "hello";
		String str2 = "sellsshelo";
		String[] strs = getAllSubstrings(str);

		for (String s : strs) {
			System.out.println(s);
		}

		System.out.println("------------");
		String res = getSameStr(str,str2);
		System.out.println(res);
	}
}
