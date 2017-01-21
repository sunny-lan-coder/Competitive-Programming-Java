package ccc.s2011;

import java.util.Scanner;

public class S4 {
	
//	on - on
//	an - on, an
//	bn - on, bn
//	op - on, op
//	abn - on, an, bn, abn
//	ap - on, an, op, ap
//	bp - on, bn, op, bp
//	abp - on, an, bn, abn, op, ap, bp, abp
//
//	on - on, an, bn, op, ap, bp, abn, abp
//	an - an, abn, ap, abp
//	bn - bn, abn, bp, abp
//	op - op, ap, bp, abp
//	ap - op, ap, abp
//	bp - op, bp, abp
//	abn - abn, abp
//	abp - abp	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int on = s.nextInt();
		int op = s.nextInt();
		int an = s.nextInt();
		int ap = s.nextInt();
		int bn = s.nextInt();
		int bp = s.nextInt();
		int abn = s.nextInt();
		int abp = s.nextInt();
		int pon = s.nextInt();
		int pop = s.nextInt();
		int pan = s.nextInt();
		int pap = s.nextInt();
		int pbn = s.nextInt();
		int pbp = s.nextInt();
		int pabn = s.nextInt();
		int pabp = s.nextInt();
		s.close();

		int tmp;

		// l1
		int ron = 0;
		tmp = Math.min(pon - ron, Math.max(on, 0));
		ron += tmp;
		on -= tmp;

		// l2
		int ran = 0;
		tmp = Math.min(pan - ran, Math.max(on, 0));
		ran += tmp;
		on -= tmp;
		tmp = Math.min(pan - ran, Math.max(an, 0));
		ran += tmp;
		an -= tmp;

		int rbn = 0;
		tmp = Math.min(pbn - rbn, Math.max(on, 0));
		rbn += tmp;
		on -= tmp;
		tmp = Math.min(pbn - rbn, Math.max(bn, 0));
		rbn += tmp;
		bn -= tmp;

		int rop = 0;
		tmp = Math.min(pop - rop, Math.max(on, 0));
		rop += tmp;
		on -= tmp;
		tmp = Math.min(pop - rop, Math.max(op, 0));
		rop += tmp;
		op -= tmp;

		// l3
		int rabn = 0;
		tmp = Math.min(pabn - rabn, Math.max(on, 0));
		rabn += tmp;
		on -= tmp;
		tmp = Math.min(pabn - rabn, Math.max(an, 0));
		rabn += tmp;
		an -= tmp;
		tmp = Math.min(pabn - rabn, Math.max(bn, 0));
		rabn += tmp;
		bn -= tmp;
		tmp = Math.min(pabn - rabn, Math.max(abn, 0));
		rabn += tmp;
		abn -= tmp;

		int rap = 0;
		tmp = Math.min(pap - rap, Math.max(on, 0));
		rap += tmp;
		on -= tmp;
		tmp = Math.min(pap - rap, Math.max(an, 0));
		rap += tmp;
		an -= tmp;
		tmp = Math.min(pap - rap, Math.max(op, 0));
		rap += tmp;
		op -= tmp;
		tmp = Math.min(pap - rap, Math.max(ap, 0));
		rap += tmp;
		ap -= tmp;

		int rbp = 0;
		tmp = Math.min(pbp - rbp, Math.max(on, 0));
		rbp += tmp;
		on -= tmp;
		tmp = Math.min(pbp - rbp, Math.max(bn, 0));
		rbp += tmp;
		bn -= tmp;
		tmp = Math.min(pbp - rbp, Math.max(op, 0));
		rbp += tmp;
		op -= tmp;
		tmp = Math.min(pbp - rbp, Math.max(bp, 0));
		rbp += tmp;
		bp -= tmp;

		// l4
		int rabp = 0;
		tmp = Math.min(pabp - rabp, Math.max(on, 0));
		rabp += tmp;
		on -= tmp;
		tmp = Math.min(pabp - rabp, Math.max(an, 0));
		rabp += tmp;
		an -= tmp;
		tmp = Math.min(pabp - rabp, Math.max(bn, 0));
		rabp += tmp;
		bn -= tmp;
		tmp = Math.min(pabp - rabp, Math.max(op, 0));
		rabp += tmp;
		op -= tmp;
		tmp = Math.min(pabp - rabp, Math.max(ap, 0));
		rabp += tmp;
		ap -= tmp;
		tmp = Math.min(pabp - rabp, Math.max(bp, 0));
		rabp += tmp;
		bp -= tmp;
		tmp = Math.min(pabp - rabp, Math.max(abn, 0));
		rabp += tmp;
		abn -= tmp;
		tmp = Math.min(pabp - rabp, Math.max(abp, 0));
		rabp += tmp;
		abp -= tmp;

		System.out.println(ron + ran + rbn + rop + rabn + rap + rbp + rabp);
	}

}
