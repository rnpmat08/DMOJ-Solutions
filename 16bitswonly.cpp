#pragma GCC optimize("Ofast,unroll-loops")
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    long long A, B, P;
    scan(N);
    for (int i = 0; i < N; i++) {
        scan(A); scan(B); scan(P);
        (A * B != P) ? printf("16 BIT S/W ONLY\n") : printf("POSSIBLE DOUBLE SIGMA\n");
    }
    return 0;
}