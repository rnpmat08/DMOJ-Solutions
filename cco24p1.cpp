#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> G[1000001];
int dp[1000001];

int main() {
    int N, M; cin >> N >> M;
    priority_queue<pair<int, int>> pq;
    for (int i = 1; i <= N; i++) {
        cin >> dp[i];
        pq.push({dp[i], i});
    }
    for (int i = 0, a, b, c; i < M; i++) {
        cin >> a >> b >> c;
        G[a].push_back({b, c});
        G[b].push_back({a, c});
    }
    while (!pq.empty()) {
        auto [val, n] = pq.top();
        pq.pop();
        if (val >= dp[n]) {
            for (auto [u, cost] : G[n]) {
                if (dp[u] < val - cost) {
                    dp[u] = val - cost;
                    pq.push({dp[u], u});
                }
            }
        }
    }
    for (int i = 1; i <= N; i++) cout << dp[i] << "\n";
    return 0;
}