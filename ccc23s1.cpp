#include <iostream>

using namespace std;
int F[2][200000];

int main() {
    int N, A = 0; cin >> N;
    for (int i = 0; i < 2; i++) for (int j = 0; j < N; j++) cin >> F[i][j];
    for (int i = 0; i < N; i++) {
        if (F[0][i] == 1) {
            A += 3;
            if (i > 0 && F[0][i - 1] == 1) A -= 2;
        }
        if (F[1][i] == 1) {
            A += 3;
            if (i > 0 && F[1][i - 1] == 1) A -= 2;
            if (i % 2 == 0 && F[0][i] == 1)A -= 2;
        }
    }
    cout << A;
    return 0;
}
