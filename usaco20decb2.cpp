#pragma GCC optimize("Ofast,unroll-loops")
#include <iostream>
#include <vector>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, ans = 0; scan(N);
    vector<int> P(N);
    for (int i = 0; i < N; i++) scan(P[i]);
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j <= N; j++) {
            vector<int> V(P.begin() + i, P.begin() + j);
            double A = 0; int avg = 0;
            for (int k : V) A += k;
            A /= V.size(); avg = static_cast<int> (A);
            if (avg == A) {
                for (int k : V) {
                    if (k == avg) {
                        ans++;
                        break;
                    }
                }
            }
        }
    }
    printf("%d", ans);
    return 0;
}
