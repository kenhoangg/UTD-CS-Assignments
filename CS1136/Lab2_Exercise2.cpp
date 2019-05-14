// CS 1136 Lab 2 Exercise 2
// Program by: Kenny Hoang

#include <iostream>
using namespace std;
int main()
{
	/*
	 @double profit calculated by taking the product of the manufacturer price and profit margin.
	 @double mPrice a set number representing the manufacturer price.
	 @double pMargin a set number that represents the profit margin of a company's product.
	 @consumPrice a number that represents the cost at which a customer would buy a product.
	*/
	double profit, mPrice, pMargin, consumPrice;

	pMargin = .45;
	mPrice = 32.75;

	//Calculating the profit of the sale of one product.
	profit = mPrice * pMargin;
    //Calculating the selling price.
	consumPrice = mPrice + profit;

	cout << "The profit for the circuit board is: " << profit << endl;
	cout << "The selling price of the circuit boards is: " << consumPrice << endl;
	system("pause");
}