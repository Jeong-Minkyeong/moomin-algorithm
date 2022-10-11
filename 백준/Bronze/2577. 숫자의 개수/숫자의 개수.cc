#include <iostream>
#include <string>


using namespace std;

int main() {


	int a, b, c = 0;
	int num_arr[10] = { 0,0,0,0,0,0,0,0,0,0 };


	cin >> a;

	cin >> b;

	cin >> c;

	int sum = a * b * c;
	int num = 0;

	string s_sum = to_string(sum);

	
	for (int i = 0; i < s_sum.size(); i++) {

		num_arr[(s_sum[i] - '0')] += 1;
		
	}

	for (int i = 0; i < 10; i++) {

		cout << num_arr[i] << '\n';

	}


}