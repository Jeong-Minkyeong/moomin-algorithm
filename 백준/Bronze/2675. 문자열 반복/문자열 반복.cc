#include <iostream>
#include <string>

using namespace std;

int main() {

	string S;
	int T,R = 0;

	cin >> T;

	for (int i = 0; i < T; i++) {

		cin >> R;
		cin >> S;

		for (int a = 0; a < S.size(); a++) {

			for (int k = 0; k < R; k++) {

				cout << S[a];

			}
		}

		cout << '\n';
	
	}

}
