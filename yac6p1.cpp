#include <iostream>

using namespace std;

int main() {
    int N, M; cin >> N >> M; 
    for (int i = 1; i <= N; i++) {
        for (int j = i + 1; j <= N; j++) {
            if (M == 0) return 0;
            cout << i << " " << j << "\n";
            M--;
        }
    }
    return 0;
}
