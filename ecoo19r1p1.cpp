#include <iostream>
#include <cstring>

using namespace std;

int E[1001];

int main() {
    for (int i = 0; i < 10; i++) {
        int N, M, D, TC, L = 0; cin >> N >> M >> D; TC = N;
        for (int j = 0; j < M; j++) {
            int A; cin >> A;
            E[A]++;
        }
        for (int j = 1; j <= D; j++) {
            if (N == 0) {
                L++; N = TC;
            }
            N += E[j]; TC += E[j]; N--;
        }
        cout << L << "\n";
        memset(E, 0, sizeof(E));
    }
    return 0;
}
