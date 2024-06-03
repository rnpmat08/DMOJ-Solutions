#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> G[2001];
bool V[2001];

int main() {
    int N, M, A, B; cin >> N >> M >> A >> B;
    for (int i = 0; i < M; i++) {
        int X, Y; cin >> X >> Y;
        G[X].push_back(Y); G[Y].push_back(X);
    }
    queue<int> Q; Q.push(A); V[A] = true;
    while (!Q.empty()) {
        int C = Q.front();
        Q.pop();
        for (int i : G[C]) {
            if (!V[i]) {
                V[i] = true;
                Q.push(i);
            }
        }
    }
    (V[B]) ? cout << "GO SHAHIR!" : cout << "NO SHAHIR!";
    return 0;
}