#include <iostream>

using namespace std;

int main() {
    int N; long long A, B, P;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A >> B >> P;
        (A * B != P) ? cout << "16 BIT S/W ONLY\n" : cout << "POSSIBLE DOUBLE SIGMA\n";
    }
    return 0;
}
