#pragma GCC optimize("Ofast,unroll-loops")
#include <iostream>
#include <cstring>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

using namespace std;

int E[1001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    for (int i = 0; i < 10; i++) {
        int N, M, D, L = 0; scan(N); scan(M); scan(D); int TC = N;
        for (int j = 0; j < M; j++) {
            int A; scan(A);
            E[A]++;
        }
        for (int j = 1; j <= D; j++) {
            if (N == 0) {
                L++;
                N = TC;
            }
            N += E[j]; TC += E[j];
            N--;
        }
        printf("%d\n", L);
        memset(E, 0, sizeof(E));
    }
    return 0;
}