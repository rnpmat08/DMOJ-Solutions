#include <iostream>

using namespace std;

int G[4][4];

int main() {
    for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++) cin >> G[i][j];
    int E = 0;
    for (int i = 0; i < 4; i++) {
	    bool C = false;
	    for (int j = 0; j < 4; j++) {
	        if (G[i][j] == 1) {
		    C = true;
		    E++;
	        }
	    }
	    if (!C) {
	        cout << "No\n";
	        return 0;
	    }
    }
    (E == 6) ? cout << "Yes\n" : cout << "No\n"; 
    return 0;
}