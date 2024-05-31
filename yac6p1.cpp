#pragma GCC optimize("Ofast,unroll-loops")
#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, M; scan(N); scan(M);
    for (int i = 1; i <= N; i++) {
        for (int j = i + 1; j <= N; j++) {
            if (M == 0) break;
            printf("%d ", i); printf("%d\n", j);
            M--;
        }
    }
    return 0;
}