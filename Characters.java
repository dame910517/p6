package p6;

import java.util.Arrays;

public class Characters {

	public static Array7x7[][] translate(String input) {
		return  translate(input, Color.WHITE, Color.BLACK);
	}

	public static Array7x7[][] translate(String input, int fore, int back) {
		Array7x7[][] res = new Array7x7[1][input.length()];
		input = input.toLowerCase();
		for (int i = 0; i < input.length(); i++) {
			res[0][i] = translate(input.charAt(i), fore, back);
		}
		return res;
	}

	public static Array7x7 translate(char input) {
		return translate(input, Color.WHITE, Color.BLACK); 
	}

	public static Array7x7 translate(char input, int back, int fore) {
		Array7x7 res = space();
		switch (input) {
		case ' ':
			res = space(back, fore);
			break;
		case '6':
			res = six(back, fore);
			break;
		case 'a':
			res = a(back, fore);
			break;
		case 'b':
			res = b(back, fore);
			break;
		case 'd':
			res = d(back, fore);
			break;
		case 'e':
			res = e(back, fore);
			break;
		case 'f':
			res = f(back, fore);
			break;
		case 'g':
			res = g(back, fore);
			break;
		case 'h':
			res = h(back, fore);
			break;
		case 'i':
			res = i(back, fore);
			break;
		case 'm':
			res = m(back, fore);
			break;
		case 'n':
			res = n(back, fore);
			break;
		case 'o':
			res = o(back, fore);
			break;
		case 'p':
			res = p(back, fore);
			break;
		case 'r':
			res = r(back, fore);
			break;
		case 's':
			res = s(back, fore);
			break;
		case 't':
			res = t(back, fore);
			break;
		case 'w':
			res = w(back, fore);
			break;
		case '!':
			res = exclamation(back, fore);
			break;
		default:
			res = notFound(back, fore);
			break;
		}
		return res;
	}

	public static Array7x7 space() {
		return space(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 space(int O, int X) {
		int[][] res = new int[7][7];
		for (int[] row : res) 
			Arrays.fill(row, O);
		return new Array7x7(res);
	}

	public static Array7x7 six() {
		return six(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 six(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, O, O},
				{O, X, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 a() {
		return a(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 a(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 b() {
		return b(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 b(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 d() {
		return d(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 d(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 e() {
		return e(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 e(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, X, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 f() {
		return f(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 f(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O},
				{O, X, X, X, O, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 g() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 g(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, O, O},
				{O, X, O, X, X, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 h() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 h(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, X, X, X, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 i() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 i(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 m() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 m(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, X, O, X, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 n() {
		return g(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 n(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, X, O, O, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, O, X, X, O},
				{O, X, O, O, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 o() {
		return p(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 o(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 p() {
		return p(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 p(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, O, O},
				{O, O, X, O, O, O, O},
				{O, X, X, X, O, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 r() {
		return r(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 r(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, O, X, X, X, O, O},
				{O, O, X, O, O, X, O},
				{O, O, X, O, O, X, O},
				{O, X, X, X, O, X, O}};
		return new Array7x7(res);
	}

	public static Array7x7 s() {
		return s(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 s(int O, int X) {
		int[][] res = {
				{O, O, X, X, X, O, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, O, O},
				{O, O, X, X, X, O, O},
				{O, O, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 t() {
		return t(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 t(int O, int X) {
		int[][] res = {
				{O, X, X, X, X, X, O},
				{O, X, O, X, O, X, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, X, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 w() {
		return t(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 w(int O, int X) {
		int[][] res = {
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, O, O, X, O},
				{O, X, O, X, O, X, O},
				{O, X, O, X, O, X, O},
				{O, O, X, O, X, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 exclamation() {
		return t(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 exclamation(int O, int X) {
		int[][] res = {
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, X, O, O, O},
				{O, O, O, O, O, O, O},
				{O, O, O, X, O, O, O}};
		return new Array7x7(res);
	}

	public static Array7x7 notFound() {
		return t(Color.WHITE, Color.BLACK);
	}

	public static Array7x7 notFound(int O, int X) {
		int[][] res = {
				{X, O, O, O, O, O, X},
				{O, X, O, O, O, X, O},
				{O, O, X, O, X, O, O},
				{O, O, O, X, O, O, O},
				{O, O, X, O, X, O, O},
				{O, X, O, O, O, X, O},
				{X, O, O, O, O, O, X}};
		return new Array7x7(res);
	}
}