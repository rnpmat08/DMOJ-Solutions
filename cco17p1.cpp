#include <iostream>
#include <vector>

using namespace  std;

vector<int> G[5001];

int main() {
    int K, V = 0, ed = 0; cin >> K;
    for (int N = 5000; N >= 2; N--) {
        while (K >= N * (N - 1) / 2) {
            int S = V + 1, E = V + N;
            if (V > 0) {
                G[V].push_back(S);
                ed++;
            }
            ed += E - S + 1;
            for (int i = S; i < E; i++) G[i].push_back(i + 1);
            G[E].push_back(S);
            K -= N * (N - 1) / 2;
            V += N;
        }
    }
    cout << V << " " << ed << "\n";
    for (int i = 1; i <= 5000; i++) {
        if (!G[i].empty()) for (int j : G[i]) cout << i << " " << j << "\n";
    }
    return 0;
}