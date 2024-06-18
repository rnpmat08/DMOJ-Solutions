#include <iostream>
#include <queue>

using namespace std;

int S[1000001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int inc = 1; long long N, M, K; cin >> N >> M >> K;
    queue<int> Q;
    if (M * (N - M) + (M * (M + 1)) / 2 < K || N > K) {
        cout << -1;
        return 0;
    }
    K -= N;
    while (K > 0) {
        if (inc < K) {
            K -= inc;
            Q.push(inc);
        } else {
            Q.push(static_cast<int> (K));
            K = 0;
        }
        if (inc + 1 <= K && inc + 1 < M) inc++;
    }
    int size = Q.size();
    for (int i = 1; i <= N; i++) {
        if (Q.empty()) break;
        int C = Q.front(); Q.pop();
        (i - C - 1 >= 0) ? S[i] = S[i - C - 1] : S[i] = S[i - 1] % M + 1;
    }
    for (int i = size + 1; i < N; i++) S[i] = S[i - 1];
    for (int i = 0; i < N - 1; i++) {
        cout << S[i] + 1<< " ";
    }
    cout << S[N - 1] + 1;
    return 0;
}