#include <iostream>
#include <queue>

using namespace std;
bool V[1001][1001];
vector<pair<int, int>> F[1000001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int M, N;
    cin >> M >> N;
    for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++) {
            int num; cin >> num;
            F[num].push_back({i, j});
        }
    }
    queue<int> Q;
    Q.push(M * N);
    while (!Q.empty()) {
        int val = Q.front();
        Q.pop();
        for (pair i : F[val]) {
            if (!V[i.first][i.second]) {
                V[i.first][i.second] = true;
                Q.push(i.first * i.second);
            }
        }
    }
    cout << ((V[1][1]) ? "yes" : "no");
    return 0;
}