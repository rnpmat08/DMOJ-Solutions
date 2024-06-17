#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> G[100001];
bool V[100001];

bool taller(int a, int b, int N) {
    queue<int> Q;
    for (int i = 1; i <= N; i++) V[i] = false;
    Q.push(a);
    V[a] = true;
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
    return V[b];
}

int main() {
    int N, M; cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int U, V; cin >> U >> V;
        G[U].push_back(V);
    }
    int P, Q; cin >> P >> Q;
    if (taller(P, Q, N)) {
        cout << "yes";
    } else if (taller(Q, P, N)) {
        cout << "no";
    } else {
        cout << "unknown";
    }
    return 0;
}