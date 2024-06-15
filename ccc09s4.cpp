#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

#include <iostream>
#include <queue>

using namespace std;

int C[5001], cost[5001], G[5001][5001];
bool V[5001], pen[5001];

int main() {
    int N, T; scan(N); scan(T);
    for (int i = 1; i <= N; i++) C[i] = 2e9;
    for (int i = 0; i < T; i++) {
        int x, y, c; scan(x); scan(y); scan(c);
        G[x][y] = c;
        G[y][x] = c;
    }
    int K; cin >> K;
    for (int i = 0; i < K; i++) {
        int z, P; scan(z); scan(P);
        cost[z] = P;
        pen[z] = true;
    }
    int D, ans = 2e9; scan(D);
    priority_queue<pair<int, int> , vector<pair<int, int>> , greater<>> pq;
    pq.push({0, D});
    while (!pq.empty()) {
        int curCity = pq.top().second, curCost = pq.top().first;
        V[curCity] = true;
        pq.pop();
        for (int i = 1; i <= N; i++) {
            if (G[curCity][i] != 0 && curCost + G[curCity][i] + cost[i] < C[i] && !V[i]) {
                C[i] = curCost + G[curCity][i] + cost[i];
                if (pen[i]) ans = min(ans, C[i]);
                pq.push({C[i] - cost[i], i});
            }
        }
    }
    if (pen[D]) ans = min(ans, cost[D]);
    cout << ans;
    return 0;
}
