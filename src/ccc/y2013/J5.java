package ccc.y2013;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class J5 {
	static class Pair {
		int A;
		int B;

		public Pair(int A, int B) {
			this.A = A;
			this.B = B;
		}

		public int hashCode() {
			return A * B;
		}

		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair c = (Pair) o;
				if (c.A == A && c.B == B)
					return true;
				if (c.B == A && c.A == B)
					return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int G = s.nextInt();
		HashSet<Pair> gamesLeft = new HashSet<>();
		gamesLeft.add(new Pair(1, 2));
		gamesLeft.add(new Pair(1, 3));
		gamesLeft.add(new Pair(1, 4));
		gamesLeft.add(new Pair(2, 3));
		gamesLeft.add(new Pair(2, 4));
		gamesLeft.add(new Pair(3, 4));

		int[] S = new int[4 + 1];

		Pair tmp = new Pair(0, 0);

		for (int i = 0; i < G; i++) {
			int A = s.nextInt();
			int B = s.nextInt();
			int Sa = s.nextInt();
			int Sb = s.nextInt();
			tmp.A = A;
			tmp.B = B;
			gamesLeft.remove(tmp);
			if (Sa > Sb) {
				S[A] += 3;
			} else if (Sa < Sb) {
				S[B] += 3;
			} else if (Sa == Sb) {
				S[A]++;
				S[B]++;
			}
		}

		int[] state = new int[6];
		int idx = -1;
		int[] count = new int[6];
		int total = 0;

		idx++;
		for (count[idx] = 0; count[idx] < 3; count[idx]++) {
			state[idx] = count[idx];
			idx++;
			if (idx == gamesLeft.size()) {
				int[] res = Arrays.copyOf(S, 5);
				for (int i = 0; i < idx; i++) {
					Pair g = (Pair) gamesLeft.toArray()[i];
					if (state[i] == 0) {// a win
						res[g.A] += 3;
					} else if (state[i] == 1) {// b win
						res[g.B] += 3;
					} else {// tie
						res[g.A]++;
						res[g.B]++;
					}
				}

				boolean flag = true;
				for (int i = 1; i < 5; i++) {
					if (T != i && res[T] <= res[i]) {
						flag = false;
						break;
					}
				}
				if (flag)
					total++;
			}else{
				
				for (count[idx] = 0; count[idx] < 3; count[idx]++) {
					state[idx] = count[idx];
					idx++;
					if (idx == gamesLeft.size()) {
						int[] res = Arrays.copyOf(S, 5);
						for (int i = 0; i < idx; i++) {
							Pair g = (Pair) gamesLeft.toArray()[i];
							if (state[i] == 0) {// a win
								res[g.A] += 3;
							} else if (state[i] == 1) {// b win
								res[g.B] += 3;
							} else {// tie
								res[g.A]++;
								res[g.B]++;
							}
						}

						boolean flag = true;
						for (int i = 1; i < 5; i++) {
							if (T != i && res[T] <= res[i]) {
								flag = false;
								break;
							}
						}
						if (flag)
							total++;
					}else{
						
						for (count[idx] = 0; count[idx] < 3; count[idx]++) {
							state[idx] = count[idx];
							idx++;
							if (idx == gamesLeft.size()) {
								int[] res = Arrays.copyOf(S, 5);
								for (int i = 0; i < idx; i++) {
									Pair g = (Pair) gamesLeft.toArray()[i];
									if (state[i] == 0) {// a win
										res[g.A] += 3;
									} else if (state[i] == 1) {// b win
										res[g.B] += 3;
									} else {// tie
										res[g.A]++;
										res[g.B]++;
									}
								}

								boolean flag = true;
								for (int i = 1; i < 5; i++) {
									if (T != i && res[T] <= res[i]) {
										flag = false;
										break;
									}
								}
								if (flag)
									total++;
							}else{
								
								for (count[idx] = 0; count[idx] < 3; count[idx]++) {
									state[idx] = count[idx];
									idx++;
									if (idx == gamesLeft.size()) {
										int[] res = Arrays.copyOf(S, 5);
										for (int i = 0; i < idx; i++) {
											Pair g = (Pair) gamesLeft.toArray()[i];
											if (state[i] == 0) {// a win
												res[g.A] += 3;
											} else if (state[i] == 1) {// b win
												res[g.B] += 3;
											} else {// tie
												res[g.A]++;
												res[g.B]++;
											}
										}

										boolean flag = true;
										for (int i = 1; i < 5; i++) {
											if (T != i && res[T] <= res[i]) {
												flag = false;
												break;
											}
										}
										if (flag)
											total++;
									}else{
										
										for (count[idx] = 0; count[idx] < 3; count[idx]++) {
											state[idx] = count[idx];
											idx++;
											if (idx == gamesLeft.size()) {
												int[] res = Arrays.copyOf(S, 5);
												for (int i = 0; i < idx; i++) {
													Pair g = (Pair) gamesLeft.toArray()[i];
													if (state[i] == 0) {// a win
														res[g.A] += 3;
													} else if (state[i] == 1) {// b win
														res[g.B] += 3;
													} else {// tie
														res[g.A]++;
														res[g.B]++;
													}
												}

												boolean flag = true;
												for (int i = 1; i < 5; i++) {
													if (T != i && res[T] <= res[i]) {
														flag = false;
														break;
													}
												}
												if (flag)
													total++;
											}else{
												
												for (count[idx] = 0; count[idx] < 3; count[idx]++) {
													state[idx] = count[idx];
													idx++;
													if (idx == gamesLeft.size()) {
														int[] res = Arrays.copyOf(S, 5);
														for (int i = 0; i < idx; i++) {
															Pair g = (Pair) gamesLeft.toArray()[i];
															if (state[i] == 0) {// a win
																res[g.A] += 3;
															} else if (state[i] == 1) {// b win
																res[g.B] += 3;
															} else {// tie
																res[g.A]++;
																res[g.B]++;
															}
														}

														boolean flag = true;
														for (int i = 1; i < 5; i++) {
															if (T != i && res[T] <= res[i]) {
																flag = false;
																break;
															}
														}
														if (flag)
															total++;
													}else{
														
														for (count[idx] = 0; count[idx] < 3; count[idx]++) {
															state[idx] = count[idx];
															idx++;
															if (idx == gamesLeft.size()) {
																int[] res = Arrays.copyOf(S, 5);
																for (int i = 0; i < idx; i++) {
																	Pair g = (Pair) gamesLeft.toArray()[i];
																	if (state[i] == 0) {// a win
																		res[g.A] += 3;
																	} else if (state[i] == 1) {// b win
																		res[g.B] += 3;
																	} else {// tie
																		res[g.A]++;
																		res[g.B]++;
																	}
																}

																boolean flag = true;
																for (int i = 1; i < 5; i++) {
																	if (T != i && res[T] <= res[i]) {
																		flag = false;
																		break;
																	}
																}
																if (flag)
																	total++;
															}else{
																System.out.println("Friendship is Magic");
																
															}

															idx--;
														}
													}

													idx--;
												}
											}

											idx--;
										}
									}

									idx--;
								}
							}

							idx--;
						}
					}

					idx--;
				}
			}

			idx--;
		}

		System.out.println(total);

		s.close();
	}
}
