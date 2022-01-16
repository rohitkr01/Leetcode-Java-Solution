class Solution {
	public int bitwiseComplement(int N) {
		if (N == 0)
			return 1;
		int findScope = 1;
		while (findScope <= N) {
			findScope *= 2;
		}
		return findScope - N - 1;
	}
}
