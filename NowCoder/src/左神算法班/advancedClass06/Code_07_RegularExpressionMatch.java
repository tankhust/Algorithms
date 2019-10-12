package 左神算法班.advancedClass06;

public class Code_07_RegularExpressionMatch {//字符串匹配问题

	public static boolean isValid(char[] s, char[] e) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '*' || s[i] == '.') {
				return false;
			}
		}
		for (int i = 0; i < e.length; i++) {
			if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isMatch(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		return isValid(s, e) ? process(s, e, 0, 0) : false;
	}


	//str[i....一直到最后]这个字符串，能不能被exp[j...一直到最后]这个字符串，匹配出来
	public static boolean process(char[] str, char[] exp, int i, int j) {
		if (j == exp.length) {//exp耗尽了，str耗尽了就为true，否则为false
			return i == str.length;
		}

		//str aaaabb
		//exp cb....
		//j上面还有字符，考察j+1的情况
		if (j + 1 == exp.length || exp[j + 1] != '*') {//j为exp中最后一个，或j后面不为'*'
			return i != str.length && (exp[j] == str[i] || exp[j] == '.')
					&& process(str, exp, i + 1, j + 1);
		}


		//exp的j+1位置,不仅有字符而且字符是'*'
		//str aaaabb
		//exp a*....
		//i++尝试str中第i个a
		while (i != str.length && (exp[j] == str[i] || exp[j] == '.')) {
			if (process(str, exp, i, j + 2)) {
				return true;
			}
			i++;
		}

		//str aaaabb
		//exp c*....
		return process(str, exp, i, j + 2);
	}

	public static boolean isMatchDP(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		if (!isValid(s, e)) {
			return false;
		}//有效性检查
		boolean[][] dp = initDPMap(s, e);//填好最后一排和倒数两列
		for (int i = s.length - 1; i > -1; i--) {
			for (int j = e.length - 2; j > -1; j--) {
				if (e[j + 1] != '*') {
					dp[i][j] = (s[i] == e[j] || e[j] == '.')
							&& dp[i + 1][j + 1];
				} else {
					int si = i;
					while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
						if (dp[si][j + 2]) {
							dp[i][j] = true;
							break;
						}
						si++;
					}
					if (dp[i][j] != true) {
						dp[i][j] = dp[si][j + 2];
					}
				}
			}
		}
		return dp[0][0];
	}

	public static boolean[][] initDPMap(char[] s, char[] e) {
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = new boolean[slen + 1][elen + 1];
		dp[slen][elen] = true;
		for (int j = elen - 2; j > -1; j = j - 2) {
			if (e[j] != '*' && e[j + 1] == '*') {
				dp[slen][j] = true;
			} else {
				break;//范式断掉就直接break,....d*c*a*b*
			}
		}
		if (slen > 0 && elen > 0) {
			if ((e[elen - 1] == '.' || s[slen - 1] == e[elen - 1])) {
				dp[slen - 1][elen - 1] = true;
			}
		}
		return dp;
	}

	public static boolean f(char[] str, char[] exp, int i, int j) {


		if (j < exp.length - 1 && exp[j + 1] != '*') {
			if (str[i] != exp[j] && exp[j] != '.') {
				return false;
			}

			return f(str, exp, i + 1, j + 1);
		}
		//..
		//...
		return false;
	}


	public static void main(String[] args) {
		String str = "abcccdefg";
		String exp = "ab.*d.*e.*";
		System.out.println(isMatch(str, exp));
		System.out.println(isMatchDP(str, exp));

	}

}
