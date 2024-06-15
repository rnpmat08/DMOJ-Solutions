#include <iostream>
#include <queue>

using namespace std;

int G[1001][1001], D[1001];
bool V[1001];

int main() {
    int N, M; cin >> N >> M;
    for (int i = 2; i <= N; i++) D[i] = 2e9;
    for (int i = 0; i < M; i++) {
        int u, v, w; cin >> u >> v >> w;
        (G[u][v] > 0) ? G[u][v] = min(G[u][v], w) : G[u][v] = w;
        G[v][u] = G[u][v];
    }
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    pq.push({0, 1});
    while (!pq.empty()) {
        int C = pq.top().second, curDist = pq.top().first;
        pq.pop();
        V[C] = true;
        for (int i = 1; i <= N; i++) {
            if (G[C][i] > 0 && curDist + G[C][i] < D[i] && !V[i]) {
                D[i] = curDist + G[C][i];
                pq.push({curDist + G[C][i], i});
            }
        }
    }
    for (int i = 1; i <= N; i++) cout << (D[i] != 2e9 ? to_string(D[i]) : "-1") << "\n";
    return 0;
}