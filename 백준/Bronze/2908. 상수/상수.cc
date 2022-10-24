#include <iostream>
#include <string>

using namespace std;

int main() {


	string s1, s2;
	int num = 0;
	int num2 = 0;
	char temp[4] = {};
	char temp2[4] = {};

	cin >> s1;
	cin >> s2;

	for (int i = 3; i > 0; i--) {

		temp[3-i] = s1[i-1];


	}

	
	for (int i = 3; i > 0; i--) {

		temp2[3-i] = s2[i-1];


	}

	num = stoi(temp);
	num2 = stoi(temp2);
	
	if (num > num2) {

		cout << num;

	}

	else
		cout << num2;

}
