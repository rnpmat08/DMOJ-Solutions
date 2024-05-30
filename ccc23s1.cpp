#pragma GCC optimize("Ofast,unroll-loops")
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

using namespace std;
int F[2][200000];

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int N, A = 0;
    scan(N);
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < N; j++) {
            scan(F[i][j]);
        }
    }
    for (int i = 0; i < N; i++) {
        if (F[0][i] == 1) {
            A += 3;
            if (i > 0 && F[0][i - 1] == 1) {
                A -= 2;
            }
        }
        if (F[1][i] == 1) {
            A += 3;
            if (i > 0 && F[1][i - 1] == 1) {
                A -= 2;
            }
            if (i % 2 == 0 && F[0][i] == 1) {
                A -= 2;
            }
        }
    }
    printf("%d", A);
    return 0;
}