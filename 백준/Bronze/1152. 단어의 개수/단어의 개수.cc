#include <iostream>
#include <string>

using namespace std;


int main() {
	
	string str;
	int count = 0;

	getline(cin, str);


	for (int i = 0; str[i] != NULL; i++) {

			if( str[i] == ' ') {

				count++;
			}
	}
	
	if (str[0] == ' ') {

		count--;
	}

	if (str[str.size() - 1] == ' ') {

		count--;
	}

	count++;

	cout << count << '\n';

}