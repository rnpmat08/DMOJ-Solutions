#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> G[30001];
bool V[30001];
int D[30001];

int main() {
    int N, M, K, ans = 0; cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        G[a].push_back(b);
        G[b].push_back(a);
    }
    cin >> K;
    queue<int> Q;
    for (int i = 0; i < K; i++) {
        int O; cin >> O;
        Q.push(O);
        V[O] = true;
        D[O] = 0;
    }
    while (!Q.empty()) {
        int C = Q.front();
        ans = D[C];
        Q.pop();
        for (int i : G[C]) {
            if (!V[i]) {
                V[i] = true;
                D[i] = D[C] + 1;
                Q.push(i);
            }
        }
    }
    cout << ans;
    return 0;
}