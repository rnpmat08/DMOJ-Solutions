#include <iostream>

using namespace std;

int H[5000], S[5001];

int main() {
    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> H[i];
        S[i + 1] = 5e+8;
    }
    for (int i = 0; i < N; i++) {
        int sym = 0;
        for (int l = i, r = i; l >= 0 && r < N; l--, r++) {
            int diff = r - l + 1;
            sym += abs(H[l] - H[r]);
            S[diff] = min(sym, S[diff]);
        }
        sym = 0;
        for (int l = i, r = i + 1; l >= 0 && r < N; l--, r++) {
            int diff = r - l + 1;
            sym += abs(H[l] - H[r]);
            S[diff] = min(sym, S[diff]);
        }
    }
    for (int i = 1; i < N; i++) cout << S[i] << " ";
    cout << S[N] << "\n";
    return 0;
}