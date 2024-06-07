#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

vector<int> G[101];
int ants[101], car[101];
bool V[101];

int main() {
    int N, M, X, Y; cin >> N >> M;
    for (int i = 0; i < M; i++) {
        cin >> X >> Y;
        G[X].push_back(Y);
        G[Y].push_back(X);
    }
    int W, disp; cin >> W;
    queue<int> Q;
    for (int i = 0; i < W; i++) {
        cin >> disp;
        Q.push(disp);
        ants[disp] = 0;
        V[disp] = true;
    }
    while (!Q.empty()) {
        int C = Q.front();
        Q.pop();
        for (int i : G[C]) {
            if (!V[i]) {
                V[i] = true;
                ants[i] = ants[C] + 4;
                Q.push(i);
            }
        }
    }
    memset(V, false, sizeof(V));
    car[1] = 0;
    V[1] = 0;
    Q.push(1);
    while (!Q.empty()) {
        int C = Q.front();
        Q.pop();
        for (int i : G[C]) {
            if (!V[i] && car[C] + 1 < ants[i]) {
                V[i] = true;
                car[i] = car[C] + 1;
                Q.push(i);
            }
        }
    }
    cout << (V[N] ? to_string(car[N]) : "sacrifice bobhob314");
    return 0;
}