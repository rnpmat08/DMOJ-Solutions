#include <iostream>
#include <queue>

using namespace std;

int G[2001][2001], D[2001];
bool V[2001];

int main() {
    int N, M, B, Q; cin >> N >> M >> B >> Q;
    for (int i = 1; i <= N; i++) D[i] = 2e9;
    for (int i = 0; i < M; i++) {
        int X, Y, Z; cin >> X >> Y >> Z;
        G[X][Y] = Z;
        G[Y][X] = G[X][Y];
    }
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    pq.push({0, B});
    D[B] = 0;
    while (!pq.empty()) {
        int C = pq.top().second, curDist = pq.top().first;
        V[C] = true;
        pq.pop();
        for (int i = 1; i <= N; i++) {
            if (G[C][i] > 0 && curDist + G[C][i] < D[i] && !V[i]) {
                D[i] = curDist + G[C][i];
                pq.push({D[i], i});
            }
        }
    }
    for (int i = 0; i < Q; i++) {
        int A; cin >> A;
        cout << (D[A] == 2e9 ? -1 : D[A]) << "\n";
    }
    return 0;
}
