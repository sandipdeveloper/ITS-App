package com.asu.its_app.model;
import java.lang.Math;

public class Model {

	double findA(double C, double B)
	{
		double A;
		A=C*C-B*B;
		A=Math.sqrt(A);
		return(A);
	}
	double findB(double A, double C)
	{
		double B;
		B=C*C-A*A;
		B=Math.sqrt(B);
		return(B);
	}
	double findC(double B, double A)
	{
		double C;
		C=B*B+A*A;
		C=Math.sqrt(C);
		return(C);
	}
}
