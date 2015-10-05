package com.cun.java.learning;
/*题目描述
某国为了防御敌国的导弹袭击，开发出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，雷达捕捉到敌国的导弹来袭，并观测到导弹依次飞来的高度，请计算这套系统最多能拦截多少导弹。拦截来袭导弹时，必须按来袭导弹袭击的时间顺序，不允许先拦截后面的导弹，再拦截前面的导弹。
输入
每组输入有两行，第一行，输入雷达捕捉到的敌国导弹的数量k（k<=25），第二行，输入k个正整数，表示k枚导弹的高度，按来袭导弹的袭击时间顺序给出，以空格分隔。
输出
每组输出只有一行，包含一个整数，表示最多能拦截多少枚导弹。

样例输入
4
9 6 7 8
7
4 5 6 7 13 42 3
5
6 5 4 3 5
0

样例输出
2
2
4
来源
2007年北京大学计算机研究生机试真题*/
public class _1085拦截导弹 {
	/*
	 * 说明，此题可以从最长不增子序列考虑，因为只求最后的数目，
	 * 可以保持一个全局变量，记录之前的高度最低值，如果当前的高度低于此全局值，则sum++即可
	 */
}
